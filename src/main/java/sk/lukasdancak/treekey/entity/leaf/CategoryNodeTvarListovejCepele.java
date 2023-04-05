package sk.lukasdancak.treekey.entity.leaf;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
public class CategoryNodeTvarListovejCepele {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    CategoryNodeTvarListovejCepele parentNode;

    @OneToMany(mappedBy = "parentNode")
    List<CategoryNodeTvarListovejCepele> childrensNodes;

    @OneToMany(mappedBy = "categoryNode")
    private Collection<TvarListovejCepele> categoryNodeMembers;

    String name;


    int level;
}
