package sk.lukasdancak.treekey.service;

import org.springframework.stereotype.Service;
import sk.lukasdancak.treekey.entity.leafproperties.LeafBladeShapesNode;
import sk.lukasdancak.treekey.repository.LeafBladeShapesRepository;

import java.util.List;

@Service
public class LeafBladeShapesService {

    private final LeafBladeShapesRepository leafBladeShapesRepository;

    public LeafBladeShapesService(LeafBladeShapesRepository leafBladeShapesRepository) {
        this.leafBladeShapesRepository = leafBladeShapesRepository;
    }

    public List<LeafBladeShapesNode> getAll() {
        return leafBladeShapesRepository.findAll().stream().toList();
    }

    public List<LeafBladeShapesNode> findAllChildrenNodes(LeafBladeShapesNode node) {return null;}
}
