package sk.lukasdancak.treekey.dto;

import sk.lukasdancak.treekey.entity.FamilyModel;

public record TreeDTO(String latinName, String slovakName, FamilyModel family/*, String habitus, String rhytidome,
                      String leaf, String flower, String fruit, String description, String imageFolder*/) {
}
