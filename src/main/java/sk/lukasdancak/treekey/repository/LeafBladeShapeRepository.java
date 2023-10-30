package sk.lukasdancak.treekey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.lukasdancak.treekey.entity.leafproperties.LeafBladeShapesNode;

@Repository
public interface LeafBladeShapeRepository extends JpaRepository<LeafBladeShapesNode, String> {
}
