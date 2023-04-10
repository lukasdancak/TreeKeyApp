package sk.lukasdancak.treekey.entity.leafproperties;

import jakarta.persistence.*;
import sk.lukasdancak.treekey.entity.TreeModel;
import sk.lukasdancak.treekey.superclassentity.UniversalCategoryNode;

import java.util.Collection;

@Entity
@Table(name = "leaf_veins_types_nodes")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class LeafVeinsTypesNode extends UniversalCategoryNode {

    // if THIS is the last child node, then here are TreeModel objects linked to THIS node
    @OneToMany(mappedBy = "leafVeinsTypesNode")
    private Collection<TreeModel> trees;

    public Collection<TreeModel> getTrees() {
        return trees;
    }

    public void setTrees(Collection<TreeModel> trees) {
        this.trees = trees;
    }
}
