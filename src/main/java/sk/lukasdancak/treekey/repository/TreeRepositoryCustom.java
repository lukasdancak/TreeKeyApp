package sk.lukasdancak.treekey.repository;

import sk.lukasdancak.treekey.dto.TreeSearchDTO;
import sk.lukasdancak.treekey.entity.TreeModel;

import java.util.List;


public interface TreeRepositoryCustom {

    List<TreeModel> searchTreesByProperties(TreeSearchDTO treeSearchDTO);
}
