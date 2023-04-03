package sk.lukasdancak.treekey.entity;

import jakarta.persistence.*;
import sk.lukasdancak.treekey.noentity.TreeProperty;

import java.util.Collection;

@Entity
@Table(name = "habituses")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class HabitusModel extends TreeProperty {

    @OneToMany(mappedBy = "habitus")
    private Collection<TreeModel> trees;

    public HabitusModel() {
    }

    public Collection<TreeModel> getTrees() {
        return trees;
    }

    public void setTrees(Collection<TreeModel> trees) {
        this.trees = trees;
    }
}
