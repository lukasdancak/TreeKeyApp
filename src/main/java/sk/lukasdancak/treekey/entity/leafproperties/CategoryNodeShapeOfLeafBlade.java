package sk.lukasdancak.treekey.entity.leafproperties;

import jakarta.persistence.*;
import sk.lukasdancak.treekey.entitysuperclass.CategoryNodeUni;

import java.util.Collection;

@Entity
@Table(name = "category_nodes_shape_of_leaf_blade")
public class CategoryNodeShapeOfLeafBlade extends CategoryNodeUni {

    // if THIS is the last child node, then here are objects linked to THIS category node
    @OneToMany(mappedBy = "categoryNode")
    private Collection<ShapeOfLeafBlade> categoryNodeMembers;

}
