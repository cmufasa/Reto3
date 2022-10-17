package com.usa.ciclo3.reto5.security;
//
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
////import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.HttpStatusEntryPoint;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
////    @Autowired
////    private UserDetailsService userDetailsService;
////
////    @Bean
////    public BCryptPasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
////
////    @Override
////    public void configure(AuthenticationManagerBuilder build) throws Exception {
////        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
////    }
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests(a -> a
////                .antMatchers("/", "/webjars/**", "/api/**","/h2-console/**",
////                        "/Reservation/**", "/Client/**", "/Cabin/**",
////                        "/Score/**", "/Category/**", "/Message/**", "/Admin/**"
////                ).permitAll()
////                .antMatchers("/editCabin/**", "/addCabin/**", "/deleteCabin")
////                .hasRole("ADMIN")
////                .antMatchers("/")
////                .hasAnyRole("USER", "ADMIN")
////                .and()
////                .formLogin()
////                .loginPage("/login")
////                .and()
////                .exceptionHandling(e -> e
////                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)));
////    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests(a -> a
//                .antMatchers("/**", "/webjars/**","/api/**",
//                        "/Reservation/**","/Client/**","/Cabin/**",
//                        "/Score/**","/Category/**","/Message/**","/Admin/**"
//                ).permitAll()
//                .anyRequest().authenticated())
//                .exceptionHandling(e -> e
//                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
//                .oauth2Login();
//        
//        http.cors().and().csrf().disable();
//    }
//}
