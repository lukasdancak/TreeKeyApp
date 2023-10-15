package sk.lukasdancak.treekey.service;

import org.springframework.stereotype.Service;
import sk.lukasdancak.treekey.customexception.BadRequestCustom;
import sk.lukasdancak.treekey.customexception.DbComunicationProblemCustom;
import sk.lukasdancak.treekey.dto.TreeDTO;
import sk.lukasdancak.treekey.dto.TreeSearchDTO;
import sk.lukasdancak.treekey.entity.FamilyModel;
import sk.lukasdancak.treekey.entity.TreeModel;
import sk.lukasdancak.treekey.repository.TreeRepositoryCustom;
import sk.lukasdancak.treekey.repository.TreeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreeService {


    private final TreeRepository treeRepository;
    private final FamilyService familyService;
    private final LeafBladeShapesService leafBladeShapesService;

    public TreeService(TreeRepository treeRepository, FamilyService familyService, LeafBladeShapesService leafBladeShapesService) {
        this.treeRepository = treeRepository;
        this.familyService = familyService;
        this.leafBladeShapesService = leafBladeShapesService;
    }

    // check if received TreeDTO has values in database and if yes then return TreeModel



    public List<TreeModel> getAll() {
        return (treeRepository.findAll().stream().toList());
    }


    public TreeModel add(TreeDTO treeDTO) {
        List<String> errors = new ArrayList<>(); // list for errors from treeDTO check
        FamilyModel family = null;
        //check variable latinName for null or empty string
        if (treeDTO.latinName() == null || treeDTO.latinName() == "") {
            errors.add("Empty latinName of treeDTO");
        }
        //check variable slovakName for null or empty string
        if (treeDTO.slovakName() == null || treeDTO.slovakName() == "") {
            errors.add("Empty slovakName of treeDTO");
        }
        //check variable familyName for null or empty string
        if (treeDTO.familyName() == null || treeDTO.familyName() == "") {
            errors.add("Empty familyName of treeDTO");
        } else {
            try {
                // check if in database in table families exists record with name familyName
                family = familyService.getFamilyByName(treeDTO.familyName());
            } catch (Exception e) {
                throw new DbComunicationProblemCustom(
                        "Problem s databazou: treeService.add()>familyService.getFamilyByName(...)", e);
            }
            if (family == null) {
                errors.add("Posted familyname is not allowed becasue it is not in database in table families");
            }

        }

        if (!errors.isEmpty()) {
            throw new BadRequestCustom("Najdeny problem pri overeni treeDTO objektu v metode .add(): " + errors.toString());
        }

        TreeModel tree = new TreeModel();
        tree.setLatinName(treeDTO.latinName());
        tree.setSlovakName(treeDTO.slovakName());
        tree.setFamily(family);
        try {
            return treeRepository.save(tree);
        } catch (Exception e) {
            throw new DbComunicationProblemCustom("Problem s databazou: treeService.add()>treeRepository.save(tree)", e);
        }
    }

    public List<TreeModel> searchTrees(TreeSearchDTO treeSearchDTO) {

        return treeRepository.searchTreesByProperties(treeSearchDTO);
    }

    public TreeModel getTreeByNameInKebabCaseIgnoreCase(String treeName){

        treeName = treeName.replaceAll("-"," ");
        return treeRepository.findByLatinNameIgnoreCase(treeName);

    }
}
