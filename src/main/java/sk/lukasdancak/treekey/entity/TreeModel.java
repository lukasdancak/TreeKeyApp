package sk.lukasdancak.treekey.entity;

import jakarta.persistence.*;
import sk.lukasdancak.treekey.enums.Habitus;


@Entity
@Table(name = "trees")
public class TreeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id = null;
    @Column(name = "latin_name")
    private String latinName;
    @Column(name = "slovak_name")
    private String slovakName;
    @ManyToOne
    @JoinColumn(name = "family_id")
    private FamilyModel family; // slovak: čeľaď
    @Enumerated(EnumType.STRING)
    private Habitus habitus; // bush, creeper, tree, etc.; slovak: ker, strom, liana, atď
    //    private String rhytidome; // ross, slovak: borka, kora
//    private String leaf; // leaf  type
//    private String flower; // flower type
//    private String fruit; // fruit type
    private String description; // info about tree


    public TreeModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public String getSlovakName() {
        return slovakName;
    }

    public void setSlovakName(String slovakName) {
        this.slovakName = slovakName;
    }

    public FamilyModel getFamily() {
        return family;
    }

    public void setFamily(FamilyModel family) {
        this.family = family;
    }
}
