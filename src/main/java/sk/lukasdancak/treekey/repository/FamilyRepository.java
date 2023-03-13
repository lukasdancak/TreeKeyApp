package sk.lukasdancak.treekey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.lukasdancak.treekey.entity.FamilyModel;
import sk.lukasdancak.treekey.entity.TreeModel;

@Repository
public interface FamilyRepository extends JpaRepository<FamilyModel, Long> {

    FamilyModel findFamilyModelByNameIs(String familyName);

}
