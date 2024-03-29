package sk.lukasdancak.treekey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.lukasdancak.treekey.entity.TreeModel;

@Repository
public interface TreeRepository extends JpaRepository<TreeModel,Long>, TreeRepositoryCustom {


        TreeModel findByLatinNameIgnoreCase(String latinName);
}
