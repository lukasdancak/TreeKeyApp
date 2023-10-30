package sk.lukasdancak.treekey.entity;

import jakarta.persistence.*;
import sk.lukasdancak.treekey.superclassnoentity.TreeProperty;

import java.util.Collection;

@Entity
@Table(name = "habituses")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class HabitusModel extends TreeProperty {

    @OneToMany(mappedBy = "primaryHabitus")
    private Collection<TreeModel> treesWithAsPrimary;

    @OneToMany(mappedBy = "secondaryHabitus")
    private Collection<TreeModel> treesWithAsSecondary;


    public HabitusModel() {
    }

    public Collection<TreeModel> getTreesWithAsPrimary() {
        return treesWithAsPrimary;
    }

    public Collection<TreeModel> getTreesWithAsSecondary() {
        return treesWithAsSecondary;
    }
}
