package sk.lukasdancak.treekey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sk.lukasdancak.treekey.dto.TreeDTO;
import sk.lukasdancak.treekey.dto.TreeSearchDTO;

@Controller
public class BasicController {

    @RequestMapping("/")
    public String mainPage() {
        return "home";
    }

    @RequestMapping("/searchtree")
    public String searchNoJSPage(Model model, @RequestParam String habitusName) {
        TreeSearchDTO treeSearchRequest = new TreeSearchDTO(habitusName);
        // check data of treeSearchRequest in database
        //if OK then get the list of finded trees
        // add list to model
        // return page
        return "searchnojs";
    }
}
