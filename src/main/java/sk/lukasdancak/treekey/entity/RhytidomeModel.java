package sk.lukasdancak.treekey.entity;

import jakarta.persistence.*;
import sk.lukasdancak.treekey.noentitysuperclass.TreeProperty;

import java.util.Collection;

@Entity
@Table(name = "rhytidomes")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class RhytidomeModel extends TreeProperty {

    @OneToMany(mappedBy = "rhytidome")
    private Collection<TreeModel> trees;

    public RhytidomeModel() {
    }

    public Collection<TreeModel> getTrees() {
        return trees;
    }

    public void setTrees(Collection<TreeModel> trees) {
        this.trees = trees;
    }
}
