package sk.lukasdancak.treekey.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import sk.lukasdancak.treekey.entity.UserAccount;
import sk.lukasdancak.treekey.repository.UserAccountRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserAccountServiceTest {

    @Mock
    private UserAccountRepository userAccountRepository;

    @Mock
    private OidcUser googleUser;

    @Test
    void upsertFromGoogleCreatesAccountUsingStableGoogleSubject() {
        when(googleUser.getSubject()).thenReturn("google-subject");
        when(googleUser.getEmail()).thenReturn("tree@example.com");
        when(googleUser.getFullName()).thenReturn("Tree User");
        when(googleUser.getPicture()).thenReturn("https://example.com/photo.jpg");
        when(userAccountRepository.findByGoogleSubject("google-subject")).thenReturn(Optional.empty());
        when(userAccountRepository.save(any(UserAccount.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        UserAccount account = new UserAccountService(userAccountRepository).upsertFromGoogle(googleUser);

        assertEquals("google-subject", account.getGoogleSubject());
        assertEquals("tree@example.com", account.getEmail());
        assertEquals("Tree User", account.getDisplayName());
        assertEquals("https://example.com/photo.jpg", account.getPictureUrl());
        assertNotNull(account.getLastLoginAt());
        verify(userAccountRepository).save(account);
    }

    @Test
    void upsertFromGoogleRejectsMissingSubject() {
        when(googleUser.getSubject()).thenReturn(" ");

        UserAccountService service = new UserAccountService(userAccountRepository);

        org.junit.jupiter.api.Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> service.upsertFromGoogle(googleUser));
    }
}
