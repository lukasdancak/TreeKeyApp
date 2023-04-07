package sk.lukasdancak.treekey.entity.leafproperties;

import jakarta.persistence.*;
import sk.lukasdancak.treekey.entity.TreeModel;
import sk.lukasdancak.treekey.noentitysuperclass.TreeProperty;

import java.util.Collection;

@Entity
public class ShapeOfLeafBlade extends TreeProperty {

    //category node of THIS shape of leaf blade
    @ManyToOne
    @JoinColumn
    CategoryNodeShapeOfLeafBlade categoryNode;

    //list of trees which have THIS type of shape of leaf blade
    @OneToMany(mappedBy = "shapeOfLeafBlade")
    private Collection<TreeModel> trees;

    public Collection<TreeModel> getTrees() {
        return trees;
    }

    public void setTrees(Collection<TreeModel> trees) {
        this.trees = trees;
    }
}
