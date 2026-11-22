package sk.lukasdancak.treekey.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import sk.lukasdancak.treekey.service.UserAccountService;

import java.io.IOException;

@Component
public class GoogleLoginSuccessHandler implements AuthenticationSuccessHandler {

    private final UserAccountService userAccountService;
    private final SavedRequestAwareAuthenticationSuccessHandler delegate =
            new SavedRequestAwareAuthenticationSuccessHandler();

    public GoogleLoginSuccessHandler(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        if (!(authentication.getPrincipal() instanceof OidcUser oidcUser)) {
            throw new ServletException("Google login did not provide an OpenID Connect user");
        }

        userAccountService.upsertFromGoogle(oidcUser);
        delegate.onAuthenticationSuccess(request, response, authentication);
    }
}
