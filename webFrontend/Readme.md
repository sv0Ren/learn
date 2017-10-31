facebook:
  client:
    clientId: 295328394316805
    clientSecret: e1d067b6973adc0df9d9ab90bf7daf90
    accessTokenUri: https://graph.facebook.com/oauth/access_token
    userAuthorizationUri: https://www.facebook.com/dialog/oauth
    tokenName: oauth_token
    authenticationScheme: query
    clientAuthenticationScheme: form
  resource:
    userInfoUri: https://graph.facebook.com/me
spring:
   resources:
     chain:
       enabled: true