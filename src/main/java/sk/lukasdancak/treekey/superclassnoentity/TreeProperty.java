package sk.lukasdancak.treekey.superclassnoentity;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class TreeProperty {

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long id;
    @Id
    @Column(nullable = false)
    private String name; //name of flower

    private String description; // description of flower


//    public Long getId() {
//        return id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
