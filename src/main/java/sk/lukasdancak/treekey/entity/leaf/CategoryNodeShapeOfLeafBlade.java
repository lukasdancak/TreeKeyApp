package sk.lukasdancak.treekey.entity.leaf;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "category_nodes_shape_of_leaf_blade")
public class CategoryNodeShapeOfLeafBlade extends CategoryNodeUni {

    @OneToMany(mappedBy = "categoryNode")
    private Collection<ShapeOfLeafBlade> categoryNodeMembers;   // if THIS is the last child then here are objects
    // linked to THIS category node


}
