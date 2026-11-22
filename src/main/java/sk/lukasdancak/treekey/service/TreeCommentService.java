package sk.lukasdancak.treekey.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.lukasdancak.treekey.entity.TreeComment;
import sk.lukasdancak.treekey.entity.TreeModel;
import sk.lukasdancak.treekey.entity.UserAccount;
import sk.lukasdancak.treekey.repository.TreeCommentRepository;
import sk.lukasdancak.treekey.repository.TreeRepository;
import sk.lukasdancak.treekey.repository.UserAccountRepository;

import java.util.List;

@Service
public class TreeCommentService {

    private final TreeCommentRepository treeCommentRepository;
    private final TreeRepository treeRepository;
    private final UserAccountRepository userAccountRepository;

    public TreeCommentService(
            TreeCommentRepository treeCommentRepository,
            TreeRepository treeRepository,
            UserAccountRepository userAccountRepository) {
        this.treeCommentRepository = treeCommentRepository;
        this.treeRepository = treeRepository;
        this.userAccountRepository = userAccountRepository;
    }

    @Transactional(readOnly = true)
    public List<TreeComment> getCommentsForTree(Long treeId) {
        return treeCommentRepository.findAllForTree(treeId);
    }

    @Transactional
    public void addComment(Long treeId, String googleSubject, String content) {
        TreeModel tree = treeRepository.findById(treeId)
                .orElseThrow(() -> new IllegalArgumentException("Tree does not exist: " + treeId));
        UserAccount author = userAccountRepository.findByGoogleSubject(googleSubject)
                .orElseThrow(() -> new IllegalStateException("Authenticated Google account was not persisted"));

        treeCommentRepository.save(new TreeComment(tree, author, content.strip()));
    }
}
