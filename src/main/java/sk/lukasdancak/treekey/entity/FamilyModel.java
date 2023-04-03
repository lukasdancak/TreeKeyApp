package sk.lukasdancak.treekey.entity;

import jakarta.persistence.*;
import sk.lukasdancak.treekey.noentity.TreeProperty;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "families")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class FamilyModel extends TreeProperty {

    @OneToMany(mappedBy = "family")
    private Collection<TreeModel> trees;

    public FamilyModel() {
    }


    public Collection<TreeModel> getTrees() {
        return trees;
    }

    public void setTrees(Collection<TreeModel> trees) {
        this.trees = trees;
    }
}
