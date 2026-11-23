package sk.lukasdancak.treekey.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sk.lukasdancak.treekey.dto.*;
import sk.lukasdancak.treekey.entity.TreeModel;
import sk.lukasdancak.treekey.mapper.myTreeMapper;
import sk.lukasdancak.treekey.service.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BasicController {

    private final TreeService treeService;
    private final LeafBladeShapeService leafBladeShapesService;
    private final LeafVeinsTypeService leafVeinsTypeService;
    private final HabitusService habitusService;
    private final RhytidomeService rhytidomeService;
    private final TreeCommentService treeCommentService;
    private final myTreeMapper myTreeMapper;


    public BasicController(TreeService treeService, LeafBladeShapeService leafShapesService, LeafVeinsTypeService leafVeinsTypeService, HabitusService habitusService, RhytidomeService rhytidomeService, TreeCommentService treeCommentService) {
        this.treeService = treeService;
        this.leafBladeShapesService = leafShapesService;
        this.leafVeinsTypeService = leafVeinsTypeService;
        this.habitusService = habitusService;
        this.rhytidomeService = rhytidomeService;
        this.treeCommentService = treeCommentService;

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
        return "about";
    }

    @RequestMapping("/kontakt")
    public String contactPage(){
        return "contact";
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
    public String treePage(Model model, @PathVariable String treeName) {

        TreeModel tree = treeService.getTreeByNameInKebabCaseIgnoreCase(treeName);
        TreeDTO treeDTO = myTreeMapper.toDTO(tree);
        System.out.println(treeDTO.toString() );

        model.addAttribute("tree", treeDTO);
        model.addAttribute("treeName", treeName);
        model.addAttribute("comments", treeCommentService.getCommentsForTree(tree.getId()));
        model.addAttribute("commentForm", new TreeCommentForm());

        return "tree";
    }

    @PostMapping("/tree/{treeName}/comments")
    public String addTreeComment(
            @PathVariable String treeName,
            @Valid @ModelAttribute("commentForm") TreeCommentForm commentForm,
            BindingResult bindingResult,
            @AuthenticationPrincipal OidcUser googleUser,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
                String errorMessage = bindingResult.getFieldErrors("content").stream()
                        .map(error -> error.getDefaultMessage())
                        .filter(java.util.Objects::nonNull)
                        .findFirst()
                        .orElse("Comment is invalid.");
                redirectAttributes.addFlashAttribute("commentError", errorMessage);
        } else {
            TreeModel tree = treeService.getTreeByNameInKebabCaseIgnoreCase(treeName);
            treeCommentService.addComment(tree.getId(), googleUser.getSubject(), commentForm.getContent());
            redirectAttributes.addFlashAttribute("commentPosted", true);
        }
        return "redirect:/tree/" + treeName;
    }

}
