package sk.lukasdancak.treekey.entity;

import jakarta.persistence.*;
import sk.lukasdancak.treekey.noentity.TreeProperty;

import java.util.Collection;

@Entity
@Table(name = "flowers")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class FlowerModel extends TreeProperty {

    @OneToMany(mappedBy = "flower")
    private Collection<TreeModel> trees;

    public FlowerModel() {
    }

    public Collection<TreeModel> getTrees() {
        return trees;
    }

    public void setTrees(Collection<TreeModel> trees) {
        this.trees = trees;
    }
}
