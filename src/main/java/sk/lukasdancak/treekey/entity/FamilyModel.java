package sk.lukasdancak.treekey.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "families")
public class FamilyModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name; //name of tree family - meno celade
    private String description; // description of family - popis celade
    @OneToMany(mappedBy = "family")
    private Collection<TreeModel> trees;

    public FamilyModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<TreeModel> getTrees() {
        return trees;
    }

    public void setTrees(Collection<TreeModel> trees) {
        this.trees = trees;
    }
}
