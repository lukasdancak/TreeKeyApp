package sk.lukasdancak.treekey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sk.lukasdancak.treekey.dto.TreeDTO;
import sk.lukasdancak.treekey.entity.TreeModel;
import sk.lukasdancak.treekey.mapper.TreeMapper;
import sk.lukasdancak.treekey.service.TreeService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BasicController {

    private final TreeService treeService;
    private TreeMapper treeMapper = new TreeMapper();

    public BasicController(TreeService treeService) {
        this.treeService = treeService;
    }

    @RequestMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("showBanner", true);
        return "home";
    }

    @GetMapping(value = "/search-tree-no-js")
    public String getSearchTreeNoJS(Model model) {
        List<TreeModel> allTreesEntity = treeService.getAll();
        List<TreeDTO> allTreesDTO = allTreesEntity.stream().map(t->treeMapper.toDTO(t)).collect(Collectors.toList());
        model.addAttribute("allTrees", allTreesDTO);

        return "searchtreenojs";
    }

//    @RequestMapping("/searchtree")
//    public String searchNoJSPage(Model model, @RequestParam String habitusName) {
//        TreeSearchDTO treeSearchRequest = new TreeSearchDTO(habitusName);
//        // check data of treeSearchRequest in database
//        //if OK then get the list of finded trees
//        // add list to model
//        // return page
//        return "searchtreenojs";
//    }
}
