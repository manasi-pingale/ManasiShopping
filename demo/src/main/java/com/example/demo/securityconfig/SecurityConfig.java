package com.example.demo.securityconfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTFilter jwtFilter;

    @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security.csrf(custmizer -> custmizer.disable()); //disable default CSRF token and login form
        security.authorizeHttpRequests(request -> request
                .requestMatchers("/register", "/authenticate", "/authenticate")
                .permitAll()
                .anyRequest().authenticated()); // apply authentication but we have not given user and pass
        security.formLogin(Customizer.withDefaults()); //enables thr default form login
        security.httpBasic(Customizer.withDefaults());//enable form login in postman
        security.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        security.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return security.build();


//    Customizer<CsrfConfigurer<HttpSecurity>> csrfHttp = new Customizer<CsrfConfigurer<HttpSecurity>>() {
//        @Override
//        public void customize(CsrfConfigurer<HttpSecurity> httpSecurityCsrfConfigurer) {
//            httpSecurityCsrfConfigurer.disable();
//        }
//    };
//    security.csrf(csrfHttp);
//    return security.build();
   }


//   @Bean
//    public UserDetailsService userDetailsService()
//   {
//
//       UserDetails user1 = User.withDefaultPasswordEncoder()
//               .username("kiran")
//               .password("kiran@123")
//               .build();
//
//       UserDetails user2 = User.withDefaultPasswordEncoder().username("harsh")
//               .password("harsh@123").build();
//       return new InMemoryUserDetailsManager(user1,user2);
//   }

    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

     //   provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        provider.setUserDetailsService(userDetailsService);

        return provider;
    }

   @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
      return authenticationConfiguration.getAuthenticationManager();
   }

}
