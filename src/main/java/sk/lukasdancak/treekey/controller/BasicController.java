package sk.lukasdancak.treekey.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import sk.lukasdancak.treekey.dto.*;
import sk.lukasdancak.treekey.entity.TreeModel;
import sk.lukasdancak.treekey.mapper.myTreeMapper;
import sk.lukasdancak.treekey.service.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BasicController {

    private final TreeService treeService;
    private final LeafBladeShapeService leafBladeShapesService;
    private final LeafVeinsTypeService leafVeinsTypeService;
    private final HabitusService habitusService;
    private final RhytidomeService rhytidomeService;
    private final myTreeMapper myTreeMapper;


    public BasicController(TreeService treeService, LeafBladeShapeService leafShapesService, LeafVeinsTypeService leafVeinsTypeService, HabitusService habitusService, RhytidomeService rhytidomeService) {
        this.treeService = treeService;
        this.leafBladeShapesService = leafShapesService;
        this.leafVeinsTypeService = leafVeinsTypeService;
        this.habitusService = habitusService;
        this.rhytidomeService = rhytidomeService;

        this.myTreeMapper = new myTreeMapper();

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

    @RequestMapping("/ostranke")
    public String aboutPage(){
        return "aboutpage";
    }


    @RequestMapping(value = "/kluc", method = {RequestMethod.GET, RequestMethod.POST })
    public String postSearchTreeNoJS(@ModelAttribute("treeSearchDTO") TreeSearchDTO treeSearchDTO, Model model) {
        System.out.println(treeSearchDTO.toString());
        System.out.println("Is leafBladeShape NULL ?:");
        System.out.println(treeSearchDTO.getLeafBladeShapeName()==null);
        System.out.println("pred treeService.searchTrees(treeSearchDTO); ");

        List<TreeModel> allTreesEntity = treeService.searchTrees(treeSearchDTO);

        System.out.println("po treeService.searchTrees(treeSearchDTO); ");

        List<TreeDTO> allTreesDTO = allTreesEntity.stream().map(t-> myTreeMapper.toDTO(t)).collect(Collectors.toList());



        List<LeafBladeShapeDTO> leafShapesDTO = leafBladeShapesService.getAll()
                                                                      .stream()
                                                                      .map(l-> myTreeMapper.toDTO(l))
                                                                      .collect(Collectors.toList());
        //get list of all leaf veins type nodes converted to theirs DTOs
        List<LeafVeinsTypeDTO> leafVeinsTypesDTO = leafVeinsTypeService.getAll()
                                                                       .stream()
                                                                       .map(l->myTreeMapper.toDTO(l))
                                                                       .collect(Collectors.toList());
        List<HabitusDTO> habituseDTOs = habitusService.getAll()
                        .stream()
                                .map(l->myTreeMapper.toDTO(l))
                                        .collect(Collectors.toList());

        List<RhytidomeDTO> rhytidomeDTOs = rhytidomeService.getAll()
                        .stream()
                                .map(l->myTreeMapper.toDTO(l))
                                        .collect(Collectors.toList());

        model.addAttribute("allTrees", allTreesDTO);
        model.addAttribute("treeSearchDTO", treeSearchDTO);
        model.addAttribute("leafShapes", leafShapesDTO);
        model.addAttribute("leafVeinsTypes", leafVeinsTypesDTO);
        model.addAttribute("habituses", habituseDTOs);
        model.addAttribute("rhytidomes", rhytidomeDTOs);
        return "key";
    }

    @RequestMapping(value="/tree/{treeName}")
    public String treePage( Model model, @PathVariable String treeName ) {

        TreeModel tree = treeService.getTreeByNameInKebabCaseIgnoreCase(treeName);
        TreeDTO treeDTO = myTreeMapper.toDTO(tree);
        System.out.println(treeDTO.toString() );

        model.addAttribute("tree", treeDTO);



        return "tree";
    }



}
