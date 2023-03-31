package sk.lukasdancak.treekey.enums;

public enum Habitus {
    KER("ker", "fdgdfghfgh fgh fgh fgh fgh  f hfgh fgh dfgh fgh"),
    STROM("strom", "fdgd gfd gdfg dfg dfg dfg df"),
    LIANA("liana", "dfg gfd gdf dfg dfg dfgdfg dgd fgdfg dfg dfg");
    String name;
    String description;

    Habitus(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
