package sk.lukasdancak.treekey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.lukasdancak.treekey.entity.RhytidomeModel;

@Repository
public interface RhytidomeRepository extends JpaRepository<RhytidomeModel, String> {
}
