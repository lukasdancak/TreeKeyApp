package sk.lukasdancak.treekey.entity;

import jakarta.persistence.*;
import sk.lukasdancak.treekey.noentity.TreeProperty;

import java.util.Collection;

@Entity
@Table(name = "leafs")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class LeafModel extends TreeProperty {

    @OneToMany(mappedBy = "leaf")
    private Collection<TreeModel> trees;

    public LeafModel() {
    }

    public Collection<TreeModel> getTrees() {
        return trees;
    }

    public void setTrees(Collection<TreeModel> trees) {
        this.trees = trees;
    }
}
