package sk.lukasdancak.treekey.dto;

import sk.lukasdancak.treekey.entity.FamilyModel;
import sk.lukasdancak.treekey.entity.TreeModel;

public record TreeDTO(String latinName, String slovakName, String familyName/*, FamilyModel family/*, String habitus, String rhytidome,
                      String leaf, String flower, String fruit, String description, String imageFolder*/) {

    public TreeDTO(TreeModel treeModel) {
        this(treeModel.getLatinName(), treeModel.getSlovakName(), treeModel.getFamily().getName());

    }


}
