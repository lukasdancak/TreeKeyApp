package sk.lukasdancak.treekey.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "habitus")
public class HabitusModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    private String name; //name of habitus

    private String description; // description of habitus

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
