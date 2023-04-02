package sk.lukasdancak.treekey.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "trees")
public class TreeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id = null;

    @Column(name = "latin_name", nullable = false)
    private String latinName;

    @Column(name = "slovak_name", nullable = false)
    private String slovakName;

    @ManyToOne
    @JoinColumn(name = "family_id", nullable = false)
    private FamilyModel family; // slovak: čeľaď

    @ManyToOne
    @JoinColumn(name = "habitus_id", nullable = false)
    private HabitusModel habitus; // bush, creeper, tree, etc.; slovak: ker, strom, liana, atď

    @ManyToOne
    @JoinColumn(name = "rhytidome_id", nullable = false)
    private RhytidomeModel rhytidome; // ross, slovak: borka, kora


    //    private String leaf; // leaf  type
    //    private String flower; // flower type
    //    private String fruit; // fruit type
    @Column(name = "descrition", nullable = false)
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
