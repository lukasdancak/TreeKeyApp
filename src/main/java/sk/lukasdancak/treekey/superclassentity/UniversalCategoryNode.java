package sk.lukasdancak.treekey.superclassentity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class UniversalCategoryNode {
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
    UniversalCategoryNode parentNode;

    //if empty then THIS is last child node
    @OneToMany(mappedBy = "parentNode")
    Collection<UniversalCategoryNode> childrenNodes;

}