google:
  client:
    clientId: 12894100090-tqso3lih5o42isneort886la2pesafmp.apps.googleusercontent.com
    clientSecret: 9xfU16efvxQ-BTMsXT9wOLpw
    accessTokenUri: https://accounts.google.com/o/oauth2/token
    userAuthorizationUri: https://accounts.google.com/o/oauth2/auth
    clientAuthenticationScheme: form
    scope: profile email
  resource:
    userInfoUri:  https://www.googleapis.com/oauth2/v3/userinfo
linkedIn:
  client:
    clientId: 771mrzk94hye1w
    clientSecret: iIJFgBf9lCb18zYe
    accessTokenUri: https://www.linkedin.com/oauth/v2/accessToken
    userAuthorizationUri: https://www.linkedin.com/oauth/v2/authorization
  resource:
    userInfoUri: https://api.linkedin.com/v1/people/~?format=json
twitter:
  client:
    clientId: oXJIDGVdB0PDnMICDwKckyzKm
    clientSecret: Z4BpN51kNsb2wbEfzDXm40v38W3I2P1u4H6fvfM6HQraVfry5j
    accessTokenUri: https://api.twitter.com/oauth/access_token
    userAuthorizationUri: https://api.twitter.com/oauth/authorize
    clientAuthenticationScheme: form
  resource:
    userInfoUri:  https://api.twitter.com/1.1/users/show.json
    
#-- Get an Access Token --#
curl acme:acmesecret@localhost:8080/oauth/token -d grant_type=client_credentials