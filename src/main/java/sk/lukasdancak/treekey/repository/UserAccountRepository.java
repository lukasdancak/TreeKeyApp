package sk.lukasdancak.treekey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.lukasdancak.treekey.entity.UserAccount;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    Optional<UserAccount> findByGoogleSubject(String googleSubject);
}
