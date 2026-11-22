package sk.lukasdancak.treekey.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.lukasdancak.treekey.entity.UserAccount;
import sk.lukasdancak.treekey.service.UserAccountService;

@Controller
@RequestMapping("/account")
public class AccountController {

    private final UserAccountService userAccountService;

    public AccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping
    public String accountPage(@AuthenticationPrincipal OidcUser googleUser, Model model) {
        UserAccount account = userAccountService.findByGoogleSubject(googleUser.getSubject())
                .orElseThrow(() -> new IllegalStateException("Authenticated Google account was not persisted"));
        model.addAttribute("account", account);
        return "account";
    }
}
