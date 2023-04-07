package sk.lukasdancak.treekey.entity.leafproperties;


import jakarta.persistence.*;
import sk.lukasdancak.treekey.entity.TreeModel;
import sk.lukasdancak.treekey.superclassnoentity.TreeProperty;

import java.util.Collection;

@Entity
@Table(name = "leaf_veins_types")
public class LeafVeinsTypeModel extends TreeProperty {


    @OneToMany(mappedBy = "leafVeinsType")
    private Collection<TreeModel> trees;

    @ManyToOne
    @JoinColumn(name = "leaf_veins_types_category_node_name")
    private LeafVeinsTypesCategoryNode leafVeinsTypesCategoryNode;


    public LeafVeinsTypesCategoryNode getLeafVeinsTypesCategoryNode() {
        return leafVeinsTypesCategoryNode;
    }

    public void setLeafVeinsTypesCategoryNode(LeafVeinsTypesCategoryNode leafVeinsTypesCategoryNode) {
        this.leafVeinsTypesCategoryNode = leafVeinsTypesCategoryNode;
    }

    public Collection<TreeModel> getTrees() {
        return trees;
    }

    public void setTrees(Collection<TreeModel> trees) {
        this.trees = trees;
    }
}
