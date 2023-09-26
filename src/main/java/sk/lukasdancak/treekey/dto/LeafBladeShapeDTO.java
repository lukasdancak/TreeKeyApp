package sk.lukasdancak.treekey.dto;

public record LeafBladeShapeDTO(
        String name,
        String description,
        Integer level,
        String prefix,
        String parentName
) {
}
