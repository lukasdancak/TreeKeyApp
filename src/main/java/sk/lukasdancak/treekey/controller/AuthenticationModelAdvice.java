package sk.lukasdancak.treekey.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
@ControllerAdvice(annotations = Controller.class)
public class AuthenticationModelAdvice {

    @ModelAttribute
    public void addAuthenticationDetails(Model model, Authentication authentication) {
        model.addAttribute("googleLoginEnabled", true);
        model.addAttribute("currentGoogleUser",
                authentication != null && authentication.getPrincipal() instanceof OidcUser oidcUser
                        ? oidcUser
                        : null);
    }
}
