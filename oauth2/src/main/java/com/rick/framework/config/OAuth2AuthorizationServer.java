package com.rick.framework.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    private static final String DEMO_RESOURCE_ID = "order";
    @Autowired
    AuthenticationManager authenticationManager;
//    @Autowired
//    RedisConnectionFactory redisConnectionFactory;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //配置两个客户端,一个用于password认证一个用于client认证
        clients.inMemory().withClient("client_1")
                .resourceIds(DEMO_RESOURCE_ID)
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("select")
                .authorities("client")
                .secret("123456")
                .and().withClient("client_2")
                .resourceIds(DEMO_RESOURCE_ID)
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("select")
                .authorities("client")
                .secret("123456")
        .and().withClient("client_3")
                .secret("123456")
//                .resourceIds(DEMO_RESOURCE_ID)
                .redirectUris("http://localhost:9001/callback")
                // 授权码模式
                .authorizedGrantTypes("authorization_code")
//                .authorities("client")
                .scopes("select")
                .and()
                .withClient("webapp")
                .scopes("xx")
                .authorizedGrantTypes("implicit");
    }

    //http://localhost:3333/oauth/authorize?client_id=client_3&redirect_uri=http://localhost:9001/callback&response_type=code&scope=select

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
//                .tokenStore(new RedisTokenStore(redisConnectionFactory))
                .authenticationManager(authenticationManager);
    }

//    @Bean
//    public TokenStore tokenStore() {
//        RedisTokenStore redis = new RedisTokenStore(redisConnectionFactory);
//        return redis;
//    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        //允许表单认证
        oauthServer.allowFormAuthenticationForClients();
        oauthServer.tokenKeyAccess("isAnonymous() || hasAuthority('ROLE_TRUSTED_CLIENT')")
                .checkTokenAccess("hasAuthority('ROLE_TRUSTED_CLIENT')");
    }

//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
//    }

//    @Primary
//    @Bean
//    public DefaultTokenServices defaultTokenServices(){
//        DefaultTokenServices tokenServices = new DefaultTokenServices();
//        tokenServices.setTokenStore(tokenStore());
//        tokenServices.setSupportRefreshToken(true);
//        //tokenServices.setClientDetailsService(clientDetails());
//        tokenServices.setAccessTokenValiditySeconds(60*60*12); // token有效期自定义设置，默认12小时
//        tokenServices.setRefreshTokenValiditySeconds(60 * 60 * 24 * 7);//默认30天，这里修改
//        return tokenServices;
//    }

}
