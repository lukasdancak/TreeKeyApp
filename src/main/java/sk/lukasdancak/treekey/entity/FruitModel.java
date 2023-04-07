//package sk.lukasdancak.treekey.entity;
//
//import jakarta.persistence.*;
//import sk.lukasdancak.treekey.noentity.TreeProperty;
//
//import java.util.Collection;
//
//@Entity
//@Table(name = "fruits")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//public class FruitModel extends TreeProperty {
//
//    @OneToMany(mappedBy = "fruit")
//    private Collection<TreeModel> trees;
//
//    public FruitModel() {
//    }
//
//    public Collection<TreeModel> getTrees() {
//        return trees;
//    }
//
//    public void setTrees(Collection<TreeModel> trees) {
//        this.trees = trees;
//    }
//}
