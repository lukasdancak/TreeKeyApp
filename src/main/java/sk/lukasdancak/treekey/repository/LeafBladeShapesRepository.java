package sk.lukasdancak.treekey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.lukasdancak.treekey.entity.leafproperties.LeafBladeShapesNode;

@Repository
public interface LeafBladeShapesRepository extends JpaRepository<LeafBladeShapesNode, String> {
}
