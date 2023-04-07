package sk.lukasdancak.treekey.entity.leaf;

import jakarta.persistence.*;

@Entity
public class ShapeOfLeafBlade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @ManyToOne
    @JoinColumn
    CategoryNodeShapeOfLeafBlade categoryNode;

}
