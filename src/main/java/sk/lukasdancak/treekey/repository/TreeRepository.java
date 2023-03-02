package sk.lukasdancak.treekey.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.lukasdancak.treekey.entity.TreeModel;

@Repository
public interface TreeRepository extends CrudRepository<TreeModel,Long> {

}
