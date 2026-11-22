package sk.lukasdancak.treekey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sk.lukasdancak.treekey.entity.TreeComment;

import java.util.List;

public interface TreeCommentRepository extends JpaRepository<TreeComment, Long> {

    @Query("""
            select comment
            from TreeComment comment
            join fetch comment.author
            where comment.tree.id = :treeId
            order by comment.createdAt desc
            """)
    List<TreeComment> findAllForTree(@Param("treeId") Long treeId);
}
