package sk.lukasdancak.treekey.service;

import sk.lukasdancak.treekey.addrequest.TreeAddRecord;
import sk.lukasdancak.treekey.entity.TreeModel;

import java.util.List;

public interface TreeService {
    List<TreeModel> getAll();
    TreeModel add(TreeAddRecord treeAddRecord);
}
