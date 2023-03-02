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
    private String leafsType;

    public TreeModel() {
        this(null,"","","");
    }

    public TreeModel(Long id, String latinName, String slovakName, String leafsType) {
        this.id = id;
        this.latinName = latinName;
        this.slovakName = slovakName;
        this.leafsType = leafsType;
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

    public String getLeafsType() {
        return leafsType;
    }

    public void setLeafsType(String leafsType) {
        this.leafsType = leafsType;
    }
}
