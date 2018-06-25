//package com.rick.framework.bak.oauth2;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class UserDetailsServiceImpl implements UserDetailsService {
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        Set<GrantedAuthority> sets = new HashSet<>();
//        GrantedAuthority ga1 = new GrantedAuthority(){
//
//            @Override
//            public String getAuthority() {
//                return "query-demo";
//            }
//        };
//        sets.add(ga1);
//        return new User("zhangsan", "lisi", sets);
//    }
//}
