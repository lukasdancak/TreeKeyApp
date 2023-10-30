package sk.lukasdancak.treekey.service;

import org.springframework.stereotype.Service;
import sk.lukasdancak.treekey.entity.leafproperties.LeafVeinsTypesNode;
import sk.lukasdancak.treekey.repository.LeafVeinsTypeRepository;

import java.util.List;

@Service
public class LeafVeinsTypeService {

    private final LeafVeinsTypeRepository leafVeinsTypeRepository;

    public LeafVeinsTypeService(LeafVeinsTypeRepository leafVeinsTypeRepository) {
        this.leafVeinsTypeRepository = leafVeinsTypeRepository;
    }

    public List<LeafVeinsTypesNode> getAll() {return leafVeinsTypeRepository.findAll().stream().toList();}
}
