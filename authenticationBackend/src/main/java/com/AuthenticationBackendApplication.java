package com;

import com.utils.ClientResources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.filter.CompositeFilter;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@Controller
@EnableOAuth2Client
@EnableAuthorizationServer
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class AuthenticationBackendApplication extends WebSecurityConfigurerAdapter {

	private static final Logger log = LoggerFactory.getLogger(AuthenticationBackendApplication.class);

	@Qualifier("oauth2ClientContext")
	@Autowired
	OAuth2ClientContext oauth2ClientContext;

	@Bean
	@ConfigurationProperties("facebook")
	public ClientResources facebook() {
		return new ClientResources();
	}

	@Bean
	@ConfigurationProperties("github")
	public ClientResources github() {
		return new ClientResources();
	}

	@Bean
	@ConfigurationProperties("instagram")
	public ClientResources instagram() {
		return new ClientResources();
	}

//	@Bean
//	public OAuth2RestTemplate oauth2RestTemplate(OAuth2ProtectedResourceDetails resource, @Qualifier("oauth2ClientContext") OAuth2ClientContext context) {
//		return new OAuth2RestTemplate(resource, context);
//	}

//	@Bean
//	public AuthoritiesExtractor authoritiesExtractor(OAuth2RestOperations template) {
//		return map -> {
//			String url = (String) map.get("organizations_url");
//			@SuppressWarnings("unchecked")
//			List<Map<String, Object>> orgs = template.getForObject(url, List.class);
//			if (orgs.stream()
//					.anyMatch(org -> "spring-projects".equals(org.get("login")))) {
//				return AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
//			}
//			throw new BadCredentialsException("Not in Spring Projects origanization");
//		};
//	}

	/** FILTER **/
	@Bean
	public FilterRegistrationBean oauth2ClientFilterRegistration(
			OAuth2ClientContextFilter filter) {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(filter);
		registration.setOrder(-100);
		return registration;
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.antMatcher("/**")
			.authorizeRequests()
			.antMatchers("/", "/login**", "/webjars/**")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and().exceptionHandling().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/"))
			.and().logout().logoutSuccessUrl("/").permitAll()
			.and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
			.and().addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class);;
	}

	private Filter ssoFilter() {
		CompositeFilter filter = new CompositeFilter();
		List<Filter> filters = new ArrayList<>();
		filters.add(ssoFilter(facebook(), "/login/facebook"));
		filters.add(ssoFilter(github(), "/login/github"));
		filters.add(ssoFilter(instagram(), "/login/instagram"));
		filter.setFilters(filters);
		return filter;
	}

	private Filter ssoFilter(ClientResources client, String path) {
		OAuth2ClientAuthenticationProcessingFilter filter = new OAuth2ClientAuthenticationProcessingFilter(path);
		OAuth2RestTemplate template = new OAuth2RestTemplate(client.getClient(), oauth2ClientContext);
		filter.setRestTemplate(template);
		UserInfoTokenServices tokenServices = new UserInfoTokenServices(
				client.getResource().getUserInfoUri(), client.getClient().getClientId());
		tokenServices.setRestTemplate(template);
		filter.setTokenServices(tokenServices);
		return filter;
	}

//	@RequestMapping("/unauthenticated")
//	public String unauthenticated() {
//		return "redirect:/?error=true";
//	}

	@Configuration
	@EnableResourceServer
	protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
		@Override
		public void configure(HttpSecurity http) throws Exception {
			http
					.antMatcher("/me")
					.authorizeRequests().anyRequest().authenticated();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationBackendApplication.class, args);
	}

}

