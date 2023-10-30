package sk.lukasdancak.treekey.service;

import org.springframework.stereotype.Service;
import sk.lukasdancak.treekey.entity.leafproperties.LeafBladeShapesNode;
import sk.lukasdancak.treekey.repository.LeafBladeShapeRepository;

import java.util.List;

@Service
public class LeafBladeShapeService {

    private final LeafBladeShapeRepository leafBladeShapeRepository;

    public LeafBladeShapeService(LeafBladeShapeRepository leafBladeShapeRepository) {
        this.leafBladeShapeRepository = leafBladeShapeRepository;
    }

    public List<LeafBladeShapesNode> getAll() {
        return leafBladeShapeRepository.findAll().stream().toList();
    }

}
