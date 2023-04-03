package sk.lukasdancak.treekey.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "leafs")
public class LeafModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    private String name; //name of leaf

    private String description; // description of leaf

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
