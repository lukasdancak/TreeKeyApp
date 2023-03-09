package sk.lukasdancak.treekey.entity;

import jakarta.persistence.*;

@Entity
@Table(name="trees")
public class TreeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id = null;
    @Column(name="latin_name")
    private String latinName;
    @Column(name="slovak_name")
    private String slovakName;
//    @ManyToOne
//    @JoinColumn(name="family_id")
//    private FamilyModel family; // slovak: čeľaď

//    private String habitus; // bush, creeper, tree, etc.; slovak: ker, strom, liana, atď
//    private String rhytidome; // ross, slovak: borka, kora
//    private String leaf; // leaf  type
//    private String flower; // flower type
//    private String fruit; // fruit type
//    private String description; // info about tree
//    private String imageFolder; // link to folder with images

//    public FamilyModel getFamily() {
//        return family;
//    }
//
//    public void setFamily(FamilyModel family) {
//        this.family = family;
//    }

    public TreeModel() {
        this(null,"",""/*,null/*,"","","","",
                "","",""*/);
    }

    public TreeModel(Long id, String latinName, String slovakName/*,FamilyModel family/*, String habitus, String rhytidome,
                     String leaf, String flower, String fruit, String description, String imageFolder*/) {
        this.id = id;
        this.latinName = latinName;
        this.slovakName = slovakName;
       // this.family = family;
//        this.habitus = habitus;
//        this.rhytidome = rhytidome;
//        this.leaf = leaf;
//        this.flower = flower;
//        this.fruit = fruit;
//        this.description = description;
//        this.imageFolder = imageFolder;
    }


}
