package sk.lukasdancak.treekey.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.data.jpa.repository.JpaContext;
import sk.lukasdancak.treekey.dto.TreeSearchDTO;
import sk.lukasdancak.treekey.entity.TreeModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TreeRepositoryCustomImpl implements TreeRepositoryCustom {

//    @PersistenceContext
    private EntityManager entityManager;


    //why JpaContext? => https://docs.spring.io/spring-data/jpa/docs/1.9.2.RELEASE/reference/html/#jpa.misc.jpa-context
    public TreeRepositoryCustomImpl(JpaContext jpaContext) {
        this.entityManager = jpaContext.getEntityManagerByManagedType(TreeModel.class);
    }


    @Override
    public List<TreeModel> searchTreesByProperties(TreeSearchDTO treeSearchDTO) {

        StringBuilder sql = new StringBuilder();
        Map<String, Object> params = new HashMap<>();

        // query by leaf balde shape
        if(treeSearchDTO.getLeafBladeShapeName()!=null ) {
            sql.append("WITH RECURSIVE leaf_blade_shapes_tree AS (   SELECT name, parent_name   FROM leaf_blade_shapes_nodes   WHERE name = :leafBladeShape   UNION ALL   SELECT lbn.name, lbn.parent_name   FROM leaf_blade_shapes_nodes lbn   JOIN leaf_blade_shapes_tree lbst ON lbn.parent_name = lbst.name ) SELECT t.* FROM trees t WHERE t.leaf_blade_shapes_node_name IN (   SELECT name   FROM leaf_blade_shapes_tree )");
            params.put("leafBladeShape", treeSearchDTO.getLeafBladeShapeName());
        }else{
            sql.append("SELECT * FROM trees");
        }

        Query query = entityManager.createNativeQuery(sql.toString(), TreeModel.class);

        for (Map.Entry<String, Object> param : params.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }

            return query.getResultList();



    }
}
