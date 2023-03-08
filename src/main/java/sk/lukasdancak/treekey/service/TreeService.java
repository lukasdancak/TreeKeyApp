package sk.lukasdancak.treekey.service;

import sk.lukasdancak.treekey.addrequest.TreeDTO;
import sk.lukasdancak.treekey.entity.TreeModel;

import java.util.List;

public interface TreeService {
    List<TreeModel> getAll();
    TreeModel add(TreeDTO treeDTO);
}
