package sk.lukasdancak.treekey.repository;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.lukasdancak.treekey.entity.TreeModel;

@Repository
public interface TreeRepository extends JpaRepository<TreeModel,Long> {

}
