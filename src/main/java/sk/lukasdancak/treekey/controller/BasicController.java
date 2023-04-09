package sk.lukasdancak.treekey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicController {

    @RequestMapping("/")
    public String mainPage() {
        return "home";
    }

    @RequestMapping("/searchnojs")
    public String searchNoJSPage() {
        return "searchnojs";
    }
}
