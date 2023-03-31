package sk.lukasdancak.treekey.enums;

public enum Rhytidome {
    SMREKOVY("smrekovy", "dsfdsfsdfdsfsd fsdf dgdfghfgh gf"),
    DUBOVY("dubovy", "fdgdfgdfgdf dfg dfg hfg hfgh fg"),
    BUKOVY("bukovy", "sdfdfgdfhgfdg gf fgh fgh fgh fgh fgh fg");

    String name;
    String descripton;

    Rhytidome(String name, String descripton) {
        this.name = name;
        this.descripton = descripton;
    }
}
