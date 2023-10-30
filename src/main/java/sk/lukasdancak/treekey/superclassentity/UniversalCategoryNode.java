package sk.lukasdancak.treekey.superclassentity;

import jakarta.persistence.*;
import sk.lukasdancak.treekey.superclassnoentity.TreeProperty;

import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class UniversalCategoryNode extends TreeProperty {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //Long id;

    // name of this category node
//    @Id
//    String name;

    // level of this category node
    int level;

    //prefix for level
    String prefix;

    // if null then THIS is root node
    @ManyToOne
    @JoinColumn(name = "parent_name")
    UniversalCategoryNode parentNode;

    //if empty then THIS is last child node
    @OneToMany(mappedBy = "parentNode")
    Collection<UniversalCategoryNode> childrenNodes;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public UniversalCategoryNode getParentNode() {
        return parentNode;
    }
}
