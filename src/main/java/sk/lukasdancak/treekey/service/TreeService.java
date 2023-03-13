package sk.lukasdancak.treekey.service;

import org.springframework.stereotype.Service;
import sk.lukasdancak.treekey.dto.TreeDTO;
import sk.lukasdancak.treekey.entity.TreeModel;
import sk.lukasdancak.treekey.repository.TreeRepository;

import java.util.List;

@Service
public class TreeService {


    private final TreeRepository treeRepository;
    private final FamilyService familyService;

    public TreeService(TreeRepository treeRepository, FamilyService familyService) {
        this.treeRepository = treeRepository;
        this.familyService = familyService;
    }


    public List<TreeModel> getAll() {
        return (treeRepository.findAll().stream().toList());
    }


    public TreeModel add(TreeDTO treeDTO) {
        TreeModel tree = new TreeModel();
        tree.setLatinName(treeDTO.latinName());
        tree.setSlovakName(treeDTO.slovakName());
        tree.setFamily(familyService.getFamilyByName(treeDTO.familyName()));


        return treeRepository.save(tree);
    }
}
