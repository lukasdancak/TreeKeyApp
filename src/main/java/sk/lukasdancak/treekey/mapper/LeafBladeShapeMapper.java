package sk.lukasdancak.treekey.mapper;

import sk.lukasdancak.treekey.dto.LeafBladeShapeDTO;
import sk.lukasdancak.treekey.entity.leafproperties.LeafBladeShapesNode;

public class LeafBladeShapeMapper {

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
}
