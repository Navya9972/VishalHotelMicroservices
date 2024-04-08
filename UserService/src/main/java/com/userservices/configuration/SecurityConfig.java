//package com.userservices.configuration;
//
//import org.keycloak.OAuth2Constants;
//import org.keycloak.admin.client.Keycloak;
//import org.keycloak.admin.client.KeycloakBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    @Autowired
//    public JwtAuthConverter jwtAuthConverter;
//
//    @Autowired
//    private JWTAuthenticationEntrypoint entryPoint;
//    @Autowired
//    private CustomAccessDeniedHandler customaccessdenied;
//    @Value("${keycloak.admin.server-url}")
//    private String keycloakServerUrl ;
//
//    @Value("${keycloak.admin.realm}")
//    private String realm;
//
//    @Value("${keycloak.admin.client-id}")
//    private String clientId;
//
//    @Value("${keycloak.admin.client-secret}")
//    private String clientSecret;
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public Keycloak keycloakBean(){
//        System.out.println(keycloakServerUrl);
//        Keycloak keycloak = KeycloakBuilder.builder()
//                .serverUrl(keycloakServerUrl)
//                .realm(realm)
//                .username("vishal")
//                .password("pass@1234")
//                .grantType(OAuth2Constants.PASSWORD)
//                .clientId(clientId)
//                .clientSecret(clientSecret)
//                .build();
//        return keycloak;
//    }
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http.cors(ex -> ex.disable());
//
//        http.authorizeHttpRequests(authorize ->{
//            authorize
//                    .requestMatchers("/swagger-ui/**","/v3/api-docs/**").permitAll()
//                    .requestMatchers("/user/createUser").hasRole("user")
//                    .requestMatchers("/user/getUser/**").hasRole("user")
//                    .requestMatchers("/user/getAllUsers").hasRole("admin")
//                    .anyRequest().authenticated();
//        });
//
//        http.oauth2ResourceServer(t ->{
//            t.jwt(jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(jwtAuthConverter));
//        });
//
//        http.sessionManagement(
//                t -> t.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        );
//
//        return http.build();
//}
//
//}
