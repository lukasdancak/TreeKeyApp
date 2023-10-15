package sk.lukasdancak.treekey.mapper;

import sk.lukasdancak.treekey.dto.TreeDTO;
import sk.lukasdancak.treekey.entity.TreeModel;

public class TreeMapper {

    public TreeDTO toDTO(TreeModel treeModel) {
        return new TreeDTO(treeModel.getId(),
                            treeModel.getLatinName(),
                            treeModel.getSlovakName(),
                            treeModel.getDescription(),
                            treeModel.getFamily().getName(),
                            treeModel.getPrimaryHabitus().getName(),
                            treeModel.getSecondaryHabitus().getName(),
                            treeModel.getPrimaryRhytidome().getName(),
                            treeModel.getSecondaryRhytidome().getName(),
                            treeModel.getLeafBladeShapesNode().getName(),
                            treeModel.getLeafVeinsTypesNode().getName(),
                            treeModel.getNativeSpecies()
                        );
                                                    }


}
