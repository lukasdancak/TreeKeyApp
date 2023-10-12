package sk.lukasdancak.treekey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sk.lukasdancak.treekey.dto.LeafBladeShapeDTO;
import sk.lukasdancak.treekey.dto.TreeDTO;
import sk.lukasdancak.treekey.dto.TreeSearchDTO;
import sk.lukasdancak.treekey.entity.TreeModel;
import sk.lukasdancak.treekey.entity.leafproperties.LeafBladeShapesNode;
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

    @RequestMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("showBanner", true);
        return "home";
    }


    @RequestMapping(value = "/search-tree-no-js", method = {RequestMethod.GET, RequestMethod.POST })
    public String postSearchTreeNoJS(@ModelAttribute("treeSearchDTO") TreeSearchDTO treeSearchDTO, Model model) {
        List<TreeModel> allTreesEntity = treeService.searchTrees(treeSearchDTO);
        List<TreeDTO> allTreesDTO = allTreesEntity.stream().map(t->treeMapper.toDTO(t)).collect(Collectors.toList());
        List<LeafBladeShapeDTO> leafShapesDTO = leafBladeShapesService.getAll()
                                                                      .stream()
                                                                      .map(l->leafBladeShapeMapper.toDTO(l))
                                                                      .collect(Collectors.toList());
        model.addAttribute("allTrees", allTreesDTO);
        model.addAttribute("treeSearchDTO", treeSearchDTO);
        model.addAttribute("leafShapes", leafShapesDTO);
        return "searchtreenojs";
    }


}
