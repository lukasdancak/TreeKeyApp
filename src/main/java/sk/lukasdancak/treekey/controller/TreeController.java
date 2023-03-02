package sk.lukasdancak.treekey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/trees")
public class TreeController {
    private List<String> trees = new ArrayList<String>();

    @GetMapping()
    List<String> get() {
        return trees;
    }
    @PostMapping()
    void post(@RequestBody String tree){
        trees.add(tree);
    }
}
