package sk.lukasdancak.treekey.entity;

import jakarta.persistence.*;
import sk.lukasdancak.treekey.entity.leafproperties.LeafBladeShapesNode;
import sk.lukasdancak.treekey.entity.leafproperties.LeafVeinsTypesNode;


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

    //description of tree
    @Column(name = "description", nullable = false)
    private String description;

    // slovak: čeľaď
    @ManyToOne
    @JoinColumn(name = "family_name", nullable = false)
    private FamilyModel family;

    // bush, tree, etc.; slovak: ker, strom  atď
    @ManyToOne
    @JoinColumn(name = "primary_habitus_name", nullable = false)
    private HabitusModel primaryHabitus;

    @ManyToOne
    @JoinColumn(name = "secondary_habitus_name", nullable = false)
    private HabitusModel secondaryHabitus;

    // ross, slovak: borka, kora
    @ManyToOne
    @JoinColumn(name = "primary_rhytidome_name", nullable = false)
    private RhytidomeModel primaryRhytidome;

    @ManyToOne
    @JoinColumn(name = "secondary_rhytidome_name", nullable = false)
    private RhytidomeModel secondaryRhytidome;


    //shape of leafs blade
    @ManyToOne
    @JoinColumn(name = "leaf_blade_shapes_node_name")
    LeafBladeShapesNode leafBladeShapesNode;

    //type of veins
    @ManyToOne
    @JoinColumn(name = "leaf_veins_type_name")
    LeafVeinsTypesNode leafVeinsTypesNode;

    // is species the native in Slovakia ?
    @Column(name = "native_species", nullable = false)
    Boolean nativeSpecies;


    // to finish this later
//    @ManyToOne
//    @JoinColumn(name = "flower_id", nullable = false)
//    private FlowerModel flower; // flower

// to finish this later
//    @ManyToOne
//    @JoinColumn(name = "fruit_id", nullable = false)
//    private FruitModel fruit; // fruit


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

    public HabitusModel getPrimaryHabitus() {
        return primaryHabitus;
    }

    public void setPrimaryHabitus(HabitusModel primaryHabitus) {
        this.primaryHabitus = primaryHabitus;
    }

    public RhytidomeModel getPrimaryRhytidome() {
        return primaryRhytidome;
    }

    public void setPrimaryRhytidome(RhytidomeModel primaryRhytidome) {
        this.primaryRhytidome = primaryRhytidome;
    }

    public RhytidomeModel getSecondaryRhytidome() {
        return secondaryRhytidome;
    }

    public void setSecondaryRhytidome(RhytidomeModel secondaryRhytidome) {
        this.secondaryRhytidome = secondaryRhytidome;
    }

    public LeafBladeShapesNode getLeafBladeShapesNode() {
        return leafBladeShapesNode;
    }

    public void setLeafBladeShapesNode(LeafBladeShapesNode leafBladeShapesNode) {
        this.leafBladeShapesNode = leafBladeShapesNode;
    }

    public LeafVeinsTypesNode getLeafVeinsTypesNode() {
        return leafVeinsTypesNode;
    }

    public void setLeafVeinsTypesNode(LeafVeinsTypesNode leafVeinsTypesNode) {
        this.leafVeinsTypesNode = leafVeinsTypesNode;
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
