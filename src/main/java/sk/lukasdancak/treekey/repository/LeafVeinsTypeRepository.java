package sk.lukasdancak.treekey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.lukasdancak.treekey.entity.leafproperties.LeafBladeShapesNode;
import sk.lukasdancak.treekey.entity.leafproperties.LeafVeinsTypesNode;

public interface LeafVeinsTypeRepository extends JpaRepository<LeafVeinsTypesNode, String> {
}
