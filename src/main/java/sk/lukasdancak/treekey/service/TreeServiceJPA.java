package sk.lukasdancak.treekey.service;

import org.springframework.stereotype.Service;
import sk.lukasdancak.treekey.entity.TreeModel;
import sk.lukasdancak.treekey.repository.TreeRepository;

import java.util.List;

@Service
public class TreeServiceJPA implements TreeService {


    private final TreeRepository treeRepository;

    public TreeServiceJPA(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }

    @Override
    public List<TreeModel> getAll(){
        return (treeRepository.findAll().stream().toList());
    }

    @Override
    public TreeModel add(String latinName, String slovakName, String leafsType) {
        return treeRepository.save(new TreeModel(null, latinName, slovakName, leafsType));
    }
}
