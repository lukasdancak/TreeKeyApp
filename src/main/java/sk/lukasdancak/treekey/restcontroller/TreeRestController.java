package sk.lukasdancak.treekey.restcontroller;

import org.springframework.web.bind.annotation.*;
import sk.lukasdancak.treekey.dto.TreeDTO;
import sk.lukasdancak.treekey.entity.TreeModel;
import sk.lukasdancak.treekey.service.TreeService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/trees")
public class TreeRestController {

    private final TreeService treeService;

    public TreeRestController(TreeService treeService) {
        this.treeService = treeService;
    }

    @GetMapping()
    List<TreeDTO> get() {
        List<TreeModel> treeModelList = treeService.getAll();
        List<TreeDTO> treeDTOList = new ArrayList<>();
        for (TreeModel t : treeModelList
        ) {
            TreeDTO dto = new TreeDTO(t.getLatinName(), t.getSlovakName(), t.getFamily().getName());
            treeDTOList.add(dto);


        }

        return treeDTOList;

    }

    @PostMapping()
    TreeDTO post(@RequestBody TreeDTO treeDTO) {

        TreeModel t = treeService.add(treeDTO);
        TreeDTO dto = new TreeDTO(t.getLatinName(), t.getSlovakName(), t.getFamily().getName());
        return dto;
    }
}
