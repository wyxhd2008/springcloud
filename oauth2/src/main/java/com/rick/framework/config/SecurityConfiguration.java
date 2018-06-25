//package com.rick.framework.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//@EnableWebSecurity
//@Order(2)
//public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {
//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService(){
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("user_1").password("123456").authorities("USER").build());
//        manager.createUser(User.withUsername("user_2").password("123456").authorities("USER").build());
//        return manager;
//    }
//
//    @Bean
//    public static NoOpPasswordEncoder passwordEncoder() {
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // @formatter:off
//        http
//                .antMatcher("/**")
//                // 所有请求都得经过认证和授权
//                .authorizeRequests().anyRequest().authenticated()
//                .and()
//                .csrf().disable()
//                .requestMatchers().anyRequest()
//                .and()
//                .httpBasic()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/oauth/*").permitAll();
////        http
////                .logout()
////                .logoutUrl("/logout")
////                .logoutSuccessUrl("/login")
////                .and()
////                .formLogin()
////                .loginProcessingUrl("/login").defaultSuccessUrl("/index")
////                .failureUrl("/login?authentication_error=true")
////                .loginPage("/login").permitAll().and().requiresChannel().antMatchers("/**").requiresInsecure();
//
////        http.
////                antMatcher("/**")
////                // 所有请求都得经过认证和授权
////                .authorizeRequests().anyRequest().authenticated()
////                .and().authorizeRequests().antMatchers("/","/anon").permitAll()
////                .and()
////                // 这里之所以要禁用csrf，是为了方便。
////                // 否则，退出链接必须要发送一个post请求，请求还得带csrf token
////                // 那样我还得写一个界面，发送post请求
////                .csrf().disable()
////                // 退出的URL是/logout
////                .logout().logoutUrl("/logout").permitAll()
////                // 退出成功后，跳转到/路径。
////                .logoutSuccessUrl("/");
////
////        http.authorizeRequests().anyRequest().fullyAuthenticated();
////        http.formLogin().loginPage("/login").failureUrl("/login?error").permitAll();
////        http.logout().permitAll();
//
//        // @formatter:on
//    }
//
//    //不定义没有password grant_type
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        AuthenticationManager manager = super.authenticationManagerBean();
//        return manager;
//    }
//
//}
