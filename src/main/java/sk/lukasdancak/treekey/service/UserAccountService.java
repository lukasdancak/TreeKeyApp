package sk.lukasdancak.treekey.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import sk.lukasdancak.treekey.entity.UserAccount;
import sk.lukasdancak.treekey.repository.UserAccountRepository;

import java.time.Instant;
import java.util.Optional;

@Service
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Transactional
    public UserAccount upsertFromGoogle(OidcUser googleUser) {
        String subject = googleUser.getSubject();
        if (subject == null || subject.isBlank()) {
            throw new IllegalArgumentException("Google did not provide a subject identifier");
        }

        UserAccount account = userAccountRepository.findByGoogleSubject(subject)
                .orElseGet(UserAccount::new);
        account.setGoogleSubject(subject);
        account.setEmail(googleUser.getEmail());
        account.setDisplayName(googleUser.getFullName());
        account.setPictureUrl(googleUser.getPicture());
        account.setLastLoginAt(Instant.now());
        return userAccountRepository.save(account);
    }

    @Transactional(readOnly = true)
    public Optional<UserAccount> findByGoogleSubject(String subject) {
        return userAccountRepository.findByGoogleSubject(subject);
    }
}
