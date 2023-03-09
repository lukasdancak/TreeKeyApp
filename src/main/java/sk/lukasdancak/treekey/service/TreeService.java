package sk.lukasdancak.treekey.service;

import org.springframework.stereotype.Service;
import sk.lukasdancak.treekey.dto.TreeDTO;
import sk.lukasdancak.treekey.entity.TreeModel;
import sk.lukasdancak.treekey.repository.TreeRepository;

import java.util.List;

@Service
public class TreeService {


    private final TreeRepository treeRepository;

    public TreeService(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }


    public List<TreeModel> getAll(){
        return (treeRepository.findAll().stream().toList());
    }


    public TreeModel add(TreeDTO treeDTO) {
        return treeRepository.save(new TreeModel(null, treeDTO.latinName(), treeDTO.slovakName()/*, treeDTO.family()/*,
                treeDTO.habitus(), treeDTO.rhytidome(), treeDTO.leaf(), treeDTO.flower(), treeDTO.fruit(),
                treeDTO.description(), treeDTO.imageFolder()*/));
    }
}
