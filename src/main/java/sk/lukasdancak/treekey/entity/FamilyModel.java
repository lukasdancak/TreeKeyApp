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

    public FamilyModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTrees(Collection<TreeModel> trees) {
        this.trees = trees;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Collection<TreeModel> getTrees() {
        return trees;
    }


}
