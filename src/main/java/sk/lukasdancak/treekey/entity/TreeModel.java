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

    @ManyToOne
    @JoinColumn(name = "leaf_id", nullable = false)
    private LeafModel leaf; // leaf

// to finish this later
//    @ManyToOne
//    @JoinColumn(name = "flower_id", nullable = false)
//    private FlowerModel flower; // flower

// to finish this later
//    @ManyToOne
//    @JoinColumn(name = "fruit_id", nullable = false)
//    private FruitModel fruit; // fruit

    @Column(name = "descrition", nullable = false)
    private String description; // info about tree


    public TreeModel() {
    }

    public Long getId() {
        return id;
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

    public HabitusModel getHabitus() {
        return habitus;
    }

    public void setHabitus(HabitusModel habitus) {
        this.habitus = habitus;
    }

    public RhytidomeModel getRhytidome() {
        return rhytidome;
    }

    public void setRhytidome(RhytidomeModel rhytidome) {
        this.rhytidome = rhytidome;
    }

    public LeafModel getLeaf() {
        return leaf;
    }

    public void setLeaf(LeafModel leaf) {
        this.leaf = leaf;
    }

//    public FlowerModel getFlower() {
//        return flower;
//    }
//
//    public void setFlower(FlowerModel flower) {
//        this.flower = flower;
//    }
//
//    public FruitModel getFruit() {
//        return fruit;
//    }
//
//    public void setFruit(FruitModel fruit) {
//        this.fruit = fruit;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
