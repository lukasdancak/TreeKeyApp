package sk.lukasdancak.treekey.mapper;

import sk.lukasdancak.treekey.dto.*;
import sk.lukasdancak.treekey.entity.HabitusModel;
import sk.lukasdancak.treekey.entity.RhytidomeModel;
import sk.lukasdancak.treekey.entity.TreeModel;
import sk.lukasdancak.treekey.entity.leafproperties.LeafBladeShapesNode;
import sk.lukasdancak.treekey.entity.leafproperties.LeafVeinsTypesNode;

public class myTreeMapper {

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
                            treeModel.getIsNative()
                        );
    }

    public LeafVeinsTypeDTO toDTO(LeafVeinsTypesNode leafVeinsTypesNode) {
        String parentName="root";
        if(leafVeinsTypesNode.getParentNode()!=null ){parentName= leafVeinsTypesNode.getParentNode().getName();}


        return new LeafVeinsTypeDTO(
                leafVeinsTypesNode.getName(),
                leafVeinsTypesNode.getDescription(),
                leafVeinsTypesNode.getLevel(),
                leafVeinsTypesNode.getPrefix(),
                parentName
        );
    }

    public LeafBladeShapeDTO toDTO(LeafBladeShapesNode leafBladeShapesNode) {
        String parentName="root";
        if(leafBladeShapesNode.getParentNode()!=null ){parentName= leafBladeShapesNode.getParentNode().getName();}


        return new LeafBladeShapeDTO(
                leafBladeShapesNode.getName(),
                leafBladeShapesNode.getDescription(),
                leafBladeShapesNode.getLevel(),
                leafBladeShapesNode.getPrefix(),
                parentName
        );
    }

    public HabitusDTO toDTO(HabitusModel habitus){
        return new HabitusDTO(habitus.getName(), habitus.getDescription());
    }

    public RhytidomeDTO toDTO(RhytidomeModel rhytidome){
        return new RhytidomeDTO(rhytidome.getName(), rhytidome.getDescription());
    }



}
