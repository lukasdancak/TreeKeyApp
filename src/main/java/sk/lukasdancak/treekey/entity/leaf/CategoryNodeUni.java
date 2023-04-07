package sk.lukasdancak.treekey.entity.leaf;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class CategoryNodeUni {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    CategoryNodeUni parentNode; //if null then THIS is root node

    @OneToMany(mappedBy = "parentNode")
    Collection<CategoryNodeUni> childrenNodes; //if null then THIS is last child

    String name; // name of this category node
    int level; // level of this category node

}
