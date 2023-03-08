package sk.lukasdancak.treekey.entity;

import jakarta.persistence.*;

@Entity
@Table(name="trees")
public class TreeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id = null;
    private String latinName;
    private String slovakName;
    private String family; // slovak: čeľaď
    private String habitus; // bush, creeper, tree, etc.; slovak: ker, strom, liana, atď
    private String rhytidome; // ross, slovak: borka, kora
    private String leaf; // leaf  type
    private String flower; // flower type
    private String fruit; // fruit type
    private String description; // info about tree
    private String imageFolder; // link to folder with images

    public TreeModel() {
        this(null,"","","","","","","",
                "","","");
    }

    public TreeModel(Long id, String latinName, String slovakName, String family, String habitus, String rhytidome,
                     String leaf, String flower, String fruit, String description, String imageFolder) {
        this.id = id;
        this.latinName = latinName;
        this.slovakName = slovakName;
        this.family = family;
        this.habitus = habitus;
        this.rhytidome = rhytidome;
        this.leaf = leaf;
        this.flower = flower;
        this.fruit = fruit;
        this.description = description;
        this.imageFolder = imageFolder;
    }


}
