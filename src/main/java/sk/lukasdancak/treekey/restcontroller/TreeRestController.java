package sk.lukasdancak.treekey.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.lukasdancak.treekey.customexception.BadRequestCustom;
import sk.lukasdancak.treekey.dto.TreeDTO;
import sk.lukasdancak.treekey.entity.TreeModel;
import sk.lukasdancak.treekey.mapper.TreeMapper;
import sk.lukasdancak.treekey.service.TreeService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/trees")
public class TreeRestController {

    private final TreeService treeService;
    private final TreeMapper treeMapper = new TreeMapper();

    public TreeRestController(TreeService treeService) {
        this.treeService = treeService;
    }

    // RESt API endpoint for getting all trees
    @GetMapping("/get-all")
    ResponseEntity<?> get() {
        List<TreeModel> treeModelList = null;
        try {
            treeModelList = treeService.getAll();
        } catch (Exception e) {
            //log e
            return new ResponseEntity<>("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        List<TreeDTO> treeDTOList = new ArrayList<>();
        for (TreeModel t : treeModelList) {
            treeDTOList.add(treeMapper.toDTO(t));
        }
        return new ResponseEntity<>(treeDTOList, HttpStatus.OK);

    }
    //  temporaly disabled API link for adding new tree
//    @PostMapping("/add-tree")
//    ResponseEntity<?> post(@RequestBody TreeDTO treeDTO) {
//        try {
//            return new ResponseEntity<>(treeMapper.toDTO(treeService.add(treeDTO)), HttpStatus.OK);
//        } catch (BadRequestCustom e) {
//            //log e
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            //log e
//            return new ResponseEntity<>("Internal error", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
