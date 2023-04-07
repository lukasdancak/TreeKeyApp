package sk.lukasdancak.treekey.entity.leafproperties;

import jakarta.persistence.*;
import sk.lukasdancak.treekey.entitysuperclass.UniversalCategoryNode;

import java.util.Collection;

@Entity
@Table(name = "leaf_blade_shapes_category_nodes")
public class LeafBladeShapesCategoryNode extends UniversalCategoryNode {

    // if THIS is the last child node, then here are objects linked to THIS category node
    @OneToMany(mappedBy = "categoryNode")
    private Collection<LeafBladeShapeModel> categoryNodeMembers;

}
