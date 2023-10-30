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

    // this method create sql native query to filter data by properties requested by user, saved in object treeSearchDTO
    // it returns the list of founded TreeModel entities
    @Override
    public List<TreeModel> searchTreesByProperties(TreeSearchDTO treeSearchDTO) {

        StringBuilder sql = new StringBuilder();
        Map<String, Object> params = new HashMap<>();

        // first part of query
        sql.append("SELECT t.* FROM trees t ");

        // to filter by leaf blade shape
        if(treeSearchDTO.getLeafBladeShapeName()!=null ) {
            sql.append("WHERE t.leaf_blade_shape_name IN ( ");
                    sql.append("WITH RECURSIVE leaf_blade_shapes_tree AS ( ");
                        sql.append("SELECT name, parent_name ");
                        sql.append("FROM leaf_blade_shapes_nodes ");
                        sql.append("WHERE NAME = :leafBladeShape ");
                        sql.append("UNION ALL ");
                        sql.append("SELECT lbn.name, lbn.parent_name ");
                        sql.append("FROM leaf_blade_shapes_nodes lbn ");
                        sql.append("JOIN leaf_blade_shapes_tree lbst ON lbn.parent_name = lbst.name ) ");
            sql.append("SELECT name FROM leaf_blade_shapes_tree)");


            params.put("leafBladeShape", treeSearchDTO.getLeafBladeShapeName());
        }

        // to filter by is_native
        if (treeSearchDTO.getIsNative() != null) {
            if (sql.toString().contains("WHERE")) {
                sql.append(" AND is_native = :isNative");
            } else {
                sql.append(" WHERE is_native = :isNative");
            }
            params.put("isNative", treeSearchDTO.getIsNative());
        }

        // to filter by habitus
        if (treeSearchDTO.getHabitusName() != null) {
            if (sql.toString().contains("WHERE")) {
                sql.append(" AND (primary_habitus_name = :habitusName OR secondary_habitus_name = :habitusName)");
            } else {
                sql.append(" WHERE (primary_habitus_name = :habitusName OR secondary_habitus_name = :habitusName)");
            }
            params.put("habitusName", treeSearchDTO.getHabitusName());
        }

        // to filter by rhytidome
        if (treeSearchDTO.getRhytidomeName() != null) {
            if (sql.toString().contains("WHERE")) {
                sql.append(" AND (primary_rhytidome_name = :rhytidomeName OR secondary_rhytidome_name = :rhytidomeName)");
            } else {
                sql.append(" WHERE (primary_rhytidome_name = :rhytidomeName OR secondary_rhytidome_name = :rhytidomeName)");
            }
            params.put("rhytidomeName", treeSearchDTO.getRhytidomeName());
        }

        // to filter by leaf veins types
        if (treeSearchDTO.getLeafVeinsTypeName() != null) {
            if (sql.toString().contains("WHERE")) {
                sql.append(" AND ");
            } else {
                sql.append(" WHERE ");
            }
            sql.append("t.leaf_veins_type_name  IN ( ");
                    sql.append("WITH RECURSIVE leaf_veins_types_tree AS (");
                        sql.append("SELECT name, parent_name FROM leaf_veins_types_nodes ");
                        sql.append("WHERE NAME = :leafVeinsType ");
                        sql.append("UNION ALL ");
                        sql.append("SELECT lvn.name, lvn.parent_name ");
                        sql.append("FROM leaf_veins_types_nodes lvn ");
                        sql.append("JOIN leaf_veins_types_tree lvst ON lvn.parent_name = lvst.name ) ");
            sql.append("SELECT name FROM leaf_veins_types_tree)");

            params.put("leafVeinsType", treeSearchDTO.getLeafVeinsTypeName());
        }

        // final creation of query
        Query query = entityManager.createNativeQuery(sql.toString(), TreeModel.class);
        for (Map.Entry<String, Object> param : params.entrySet()) {
            query.setParameter(param.getKey(), param.getValue());
        }

            return query.getResultList();



    }
}
