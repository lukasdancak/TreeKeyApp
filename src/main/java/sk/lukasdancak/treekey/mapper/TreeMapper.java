package sk.lukasdancak.treekey.mapper;

import sk.lukasdancak.treekey.dto.TreeDTO;
import sk.lukasdancak.treekey.entity.TreeModel;

public class TreeMapper {
    public TreeDTO toDTO(TreeModel treeModel) {
        return new TreeDTO(treeModel.getLatinName(), treeModel.getSlovakName(), treeModel.getFamily().getName());
    }
}
