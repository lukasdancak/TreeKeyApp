package sk.lukasdancak.treekey.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "families")
public class FamilyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;


    public FamilyModel() {
        this(null,"");
    }

    public FamilyModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @OneToMany(mappedBy = "family")
    private Collection<TreeModel> trees;

//    public Collection<TreeModel> getTrees() {
//        return trees;
//    }
//
//    public void setTrees(Collection<TreeModel> trees) {
//        this.trees = trees;
//    }
}
