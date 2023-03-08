package sk.lukasdancak.treekey.controller;

import org.springframework.web.bind.annotation.*;
import sk.lukasdancak.treekey.addrequest.TreeDTO;
import sk.lukasdancak.treekey.entity.TreeModel;
import sk.lukasdancak.treekey.service.TreeService;

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
    TreeModel post(@RequestBody TreeDTO treeDTO){

       return treeService.add(treeDTO);
    }
}
