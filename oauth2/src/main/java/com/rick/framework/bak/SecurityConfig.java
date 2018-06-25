//package com.rick.framework.com.rick.framework.config;
//
//import com.rick.framework.bak.oauth2.UserDetailsServiceImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.com.rick.framework.config.BeanIds;
//import org.springframework.security.com.rick.framework.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.com.rick.framework.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.com.rick.framework.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.com.rick.framework.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
//
//
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/favor.ioc");
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService())
//                .passwordEncoder(passwordEncoder());
//    }
//
//    @Bean
//    public UserDetailsServiceImpl userDetailsService(){
//        return new UserDetailsServiceImpl();
//    }
//
//    @Bean
//    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
//        return new SecurityEvaluationContextExtension();
//    }
//
//    //不定义没有password grant_type
//    @Override
//    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin().loginPage("/login").permitAll().and().authorizeRequests().antMatchers("/health","css/**")
//                .anonymous().and().authorizeRequests().anyRequest().authenticated();
//        //super.configure(http);
//    }
//}
