package sk.lukasdancak.treekey.service;

import org.springframework.stereotype.Service;
import sk.lukasdancak.treekey.entity.TreeModel;
import sk.lukasdancak.treekey.repository.TreeRepository;

import java.util.List;

@Service
public class TreeServiceJPA implements TreeService {


    TreeRepository treeRepository;

    public TreeServiceJPA(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }

    @Override
    public List<TreeModel> getAll(){
        return (List<TreeModel>) treeRepository.findAll();
    }
}
