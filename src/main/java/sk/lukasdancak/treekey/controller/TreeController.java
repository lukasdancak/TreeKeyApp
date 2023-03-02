package sk.lukasdancak.treekey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/trees")
public class TreeController {
    private List<String> trees = new ArrayList<String>(Arrays.asList("sdfsdfdsf","sdfdsfdsf"));

    @GetMapping()
    List<String> get() {
        return trees;
    }
}
