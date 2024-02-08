package com.example.labxspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurOAUTH2Github {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests().anyRequest().authenticated().and().oauth2Login();
        return http.build();
    }

//    @Bean
//    public ClientRegistrationRepository clientrepo (){
//        ClientRegistration cliReg = clientRegistration();
//        return new InMemoryClientRegistrationRepository(cliReg);
//    }
//
//    private ClientRegistration clientRegistration() {
//        return CommonOAuth2Provider.GITHUB.getBuilder("github").clientId("e75a46b2054af9403ccf")
//                .clientSecret("345bb55a219ab1f6bac89c5a73f4650d6aeeb22f").build();
//    }
}
