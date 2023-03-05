package sk.lukasdancak.treekey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.lukasdancak.treekey.addrequest.TreeAddRecord;
import sk.lukasdancak.treekey.entity.TreeModel;
import sk.lukasdancak.treekey.service.TreeService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/trees")
public class TreeController {

    TreeService treeService;

    public TreeController(TreeService treeService) {
        this.treeService = treeService;
    }

    @GetMapping()
    List<TreeModel> get() {
      return  treeService.getAll();
    }

    @PostMapping()
    TreeModel post(@RequestBody TreeAddRecord treeAddRecord){

       return treeService.add(treeAddRecord);
    }
}
