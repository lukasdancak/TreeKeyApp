package sk.lukasdancak.treekey.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "flowers")
public class FlowerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    private String name; //name of flower

    private String description; // description of flower

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
