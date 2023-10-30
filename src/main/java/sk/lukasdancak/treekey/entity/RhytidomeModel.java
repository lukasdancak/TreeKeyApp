package sk.lukasdancak.treekey.entity;

import jakarta.persistence.*;
import sk.lukasdancak.treekey.superclassnoentity.TreeProperty;

import java.util.Collection;

@Entity
@Table(name = "rhytidomes")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class RhytidomeModel extends TreeProperty {

    // list of trees which have THIS rhytidome setted as primary
    @OneToMany(mappedBy = "primaryRhytidome")
    private Collection<TreeModel> treesWithAsPrimary;

    // list of trees which have THIS rhytidome setted as secondary
    @OneToMany(mappedBy = "secondaryRhytidome")
    private Collection<TreeModel> treesWithAsSecondary;

    public RhytidomeModel() {
    }

    public Collection<TreeModel> getTreesWithAsPrimary() {
        return treesWithAsPrimary;
    }

    public void setTreesWithAsPrimary(Collection<TreeModel> treesWithAsPrimary) {
        this.treesWithAsPrimary = treesWithAsPrimary;
    }
}
