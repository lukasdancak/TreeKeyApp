package sk.lukasdancak.treekey.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "rhytidome")
public class RhytidomeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    private String name; //name of rhytidome

    private String description; // description of rhytidome

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
