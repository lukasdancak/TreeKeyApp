package sk.lukasdancak.treekey.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sk.lukasdancak.treekey.entity.TreeComment;
import sk.lukasdancak.treekey.entity.TreeModel;
import sk.lukasdancak.treekey.entity.UserAccount;
import sk.lukasdancak.treekey.repository.TreeCommentRepository;
import sk.lukasdancak.treekey.repository.TreeRepository;
import sk.lukasdancak.treekey.repository.UserAccountRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TreeCommentServiceTest {

    @Mock
    private TreeCommentRepository treeCommentRepository;

    @Mock
    private TreeRepository treeRepository;

    @Mock
    private UserAccountRepository userAccountRepository;

    @Test
    void addCommentAssociatesCurrentUserAndTreeAndTrimsContent() {
        TreeModel tree = new TreeModel();
        UserAccount author = new UserAccount();
        when(treeRepository.findById(1L)).thenReturn(Optional.of(tree));
        when(userAccountRepository.findByGoogleSubject("google-subject")).thenReturn(Optional.of(author));

        new TreeCommentService(treeCommentRepository, treeRepository, userAccountRepository)
                .addComment(1L, "google-subject", "  Beautiful tree.  ");

        ArgumentCaptor<TreeComment> commentCaptor = ArgumentCaptor.forClass(TreeComment.class);
        verify(treeCommentRepository).save(commentCaptor.capture());
        TreeComment savedComment = commentCaptor.getValue();
        assertEquals(tree, savedComment.getTree());
        assertEquals(author, savedComment.getAuthor());
        assertEquals("Beautiful tree.", savedComment.getContent());
        assertNotNull(savedComment);
    }
}
