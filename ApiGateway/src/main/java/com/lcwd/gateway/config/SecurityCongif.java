//package com.lcwd.gateway.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//import org.springframework.security.config.Customizer;
//
//
////y we use EnableWebFluxSecurity instaed of EnableWebSecurity beacause we r dealing with spring cloud soo it uses spring flux 
//@EnableWebFluxSecurity
//@Configuration
//public class SecurityCongif {
//
//  @Bean
//  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//     http.csrf(t -> t.disable())
//     .authorizeHttpRequests((requests) -> requests.anyRequest().authenticated())
//     .oauth2ResourceServer(t -> {
//              t.jwt(Customizer.withDefaults());
//           })
//     .sessionManagement(t -> t.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//     return http.build();
//  }
//
//    @Bean
//    UserDetailsService userDetailsService() {
//		UserDetails user = User.builder().username("user").password("password").roles("USER").build();
//		UserDetails admin = User.builder().username("admin").password("password").roles("USER", "ADMIN").build();
//
//		return new InMemoryUserDetailsManager(user, admin);
//	}
//
//}
