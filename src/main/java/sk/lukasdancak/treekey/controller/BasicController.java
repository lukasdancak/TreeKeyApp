package sk.lukasdancak.treekey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sk.lukasdancak.treekey.entity.TreeModel;
import sk.lukasdancak.treekey.service.TreeService;

import java.util.List;

@Controller
public class BasicController {

    private final TreeService treeService;

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
        List<TreeModel> allTreesInDB = treeService.getAll();
        model.addAttribute("AllTrees", allTreesInDB);

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
