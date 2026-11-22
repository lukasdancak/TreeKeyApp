package sk.lukasdancak.treekey.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.util.Assert;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(GoogleAuthProperties.class)
public class SecurityConfig {

    @Bean
    ClientRegistrationRepository googleClientRegistrationRepository(GoogleAuthProperties properties) {
        Assert.hasText(properties.getClientId(),
                "Set APP_AUTH_GOOGLE_CLIENT_ID when APP_AUTH_GOOGLE_ENABLED=true");
        Assert.hasText(properties.getClientSecret(),
                "Set APP_AUTH_GOOGLE_CLIENT_SECRET when APP_AUTH_GOOGLE_ENABLED=true");

        ClientRegistration google = ClientRegistration.withRegistrationId("google")
                .clientId(properties.getClientId())
                .clientSecret(properties.getClientSecret())
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
                .scope("openid", "profile", "email")
                .authorizationUri("https://accounts.google.com/o/oauth2/v2/auth")
                .tokenUri("https://oauth2.googleapis.com/token")
                .userInfoUri("https://openidconnect.googleapis.com/v1/userinfo")
                .userNameAttributeName(IdTokenClaimNames.SUB)
                .jwkSetUri("https://www.googleapis.com/oauth2/v3/certs")
                .issuerUri("https://accounts.google.com")
                .clientName("Google")
                .build();

        return new InMemoryClientRegistrationRepository(google);
    }

    @Bean
    SecurityFilterChain googleLoginSecurityFilterChain(
            HttpSecurity http,
            GoogleLoginSuccessHandler successHandler) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/account", "/account/**").authenticated()
                        .anyRequest().permitAll())
                .oauth2Login(oauth2 -> oauth2.successHandler(successHandler));
        return http.build();
    }
}
