package sk.lukasdancak.treekey.dto;

public record LeafVeinsTypeDTO(
        String name,
        String description,
        Integer level,
        String prefix,
        String parentName
) {
}
