package sk.lukasdancak.treekey.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import sk.lukasdancak.treekey.dto.LeafBladeShapeDTO;
import sk.lukasdancak.treekey.dto.TreeDTO;
import sk.lukasdancak.treekey.dto.TreeSearchDTO;
import sk.lukasdancak.treekey.entity.TreeModel;
import sk.lukasdancak.treekey.mapper.LeafBladeShapeMapper;
import sk.lukasdancak.treekey.mapper.TreeMapper;
import sk.lukasdancak.treekey.service.LeafBladeShapesService;
import sk.lukasdancak.treekey.service.TreeService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BasicController {

    private final TreeService treeService;
    private final LeafBladeShapesService leafBladeShapesService;
    private TreeMapper treeMapper = new TreeMapper();
    private LeafBladeShapeMapper leafBladeShapeMapper = new LeafBladeShapeMapper();

    public BasicController(TreeService treeService, LeafBladeShapesService leafShapesService) {
        this.treeService = treeService;
        this.leafBladeShapesService = leafShapesService;
    }

    // Binder. Empty String from form is setted to String object as NULL
    // Globall binder via class with @ControllerAdvice annotation is not working now
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("showBanner", true);
        return "home";
    }


    @RequestMapping(value = "/kluc", method = {RequestMethod.GET, RequestMethod.POST })
    public String postSearchTreeNoJS(@ModelAttribute("treeSearchDTO") TreeSearchDTO treeSearchDTO, Model model) {
        System.out.println(treeSearchDTO.toString());
        System.out.println("Is leafBladeShape NULL ?:");
        System.out.println(treeSearchDTO.getLeafBladeShapeName()==null);
        List<TreeModel> allTreesEntity = treeService.searchTrees(treeSearchDTO);
        List<TreeDTO> allTreesDTO = allTreesEntity.stream().map(t->treeMapper.toDTO(t)).collect(Collectors.toList());
        List<LeafBladeShapeDTO> leafShapesDTO = leafBladeShapesService.getAll()
                                                                      .stream()
                                                                      .map(l->leafBladeShapeMapper.toDTO(l))
                                                                      .collect(Collectors.toList());
        model.addAttribute("allTrees", allTreesDTO);
        model.addAttribute("treeSearchDTO", treeSearchDTO);
        model.addAttribute("leafShapes", leafShapesDTO);
        return "key";
    }

    @RequestMapping(value="/tree/{treeName}")
    public String treePage( Model model, @PathVariable String treeName ) {

        TreeModel tree = treeService.getTreeByNameInKebabCaseIgnoreCase(treeName);
        TreeDTO treeDTO = treeMapper.toDTO(tree);
        System.out.println(treeDTO.toString() );

        model.addAttribute("tree", treeDTO);



        return "tree";
    }



}
