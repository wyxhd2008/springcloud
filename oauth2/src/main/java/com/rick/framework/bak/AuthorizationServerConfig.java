//package com.rick.framework.com.rick.framework.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.oauth2.com.rick.framework.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.com.rick.framework.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.com.rick.framework.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.com.rick.framework.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.com.rick.framework.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
//import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
//
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
////    @Autowired
////    private RedisConnectionFactory redisConnectionFactory;
//
////    @Autowired
////    private DataSource dataSource;
//
//
////    @Bean
////    public RedisTokenStore tokenStore(){
////        return new RedisTokenStore(redisConnectionFactory);
////    }
//
////    @Override
////    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
////        endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore());
////    }
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                .withClient("android")
//                .scopes("xx") //此处的scopes是无用的，可以随意设置
//                .secret("android")
//                .authorizedGrantTypes("password", "authorization_code", "refresh_token")
//                .and()
//                .withClient("webapp")
//                .scopes("xx")
//                .authorizedGrantTypes("implicit");
//    }
//
////    @Bean
////    public ClientDetailsService clientDetails() {
////        return new JdbcClientDetailsService(dataSource);
////    } @Bean
////    public ClientDetailsService clientDetails() {
////        return new JdbcClientDetailsService(dataSource);
////    }
//
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
//}
