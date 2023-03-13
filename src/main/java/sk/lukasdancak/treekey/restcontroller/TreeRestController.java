package sk.lukasdancak.treekey.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<?> get() {
        List<TreeModel> treeModelList = treeService.getAll();
        List<TreeDTO> treeDTOList = new ArrayList<>();
        for (TreeModel t : treeModelList
        ) {
            treeDTOList.add(new TreeDTO(t));
        }

        return new ResponseEntity<>(treeDTOList, HttpStatus.OK);

    }

    @PostMapping()
    ResponseEntity<?> post(@RequestBody TreeDTO treeDTO) {
        try {
            return new ResponseEntity<>(new TreeDTO(treeService.add(treeDTO)), HttpStatus.OK);
        } catch (Exception e) {
            //log of e
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }
}
