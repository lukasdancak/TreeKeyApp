package sk.lukasdancak.treekey.entity.leafproperties;

import jakarta.persistence.*;
import sk.lukasdancak.treekey.entity.TreeModel;
import sk.lukasdancak.treekey.superclassnoentity.TreeProperty;

import java.util.Collection;

@Entity
@Table(name = "leaf_blade_shapes")
public class LeafBladeShapeModel extends TreeProperty {

    //category node of THIS shape of leaf blade
    @ManyToOne
    @JoinColumn
    LeafBladeShapesCategoryNode categoryNode;

    //list of trees which have THIS type of shape of leaf blade
    @OneToMany(mappedBy = "leafBladeShape")
    private Collection<TreeModel> trees;

    public Collection<TreeModel> getTrees() {
        return trees;
    }

    public void setTrees(Collection<TreeModel> trees) {
        this.trees = trees;
    }
}