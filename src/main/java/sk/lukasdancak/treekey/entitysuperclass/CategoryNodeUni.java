package sk.lukasdancak.treekey.entitysuperclass;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class CategoryNodeUni {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //Long id;

    // name of this category node
    @Id
    String name;

    // level of this category node
    int level;

    // if null then THIS is root node
    @ManyToOne
    @JoinColumn(name = "parent_name")
    CategoryNodeUni parentNode;

    //if empty then THIS is last child node
    @OneToMany(mappedBy = "parentNode")
    Collection<CategoryNodeUni> childrenNodes;

}
