package sk.lukasdancak.treekey.service;

import org.springframework.stereotype.Service;
import sk.lukasdancak.treekey.customexception.BadRequestCustom;
import sk.lukasdancak.treekey.customexception.DbComunicationProblemCustom;
import sk.lukasdancak.treekey.dto.TreeDTO;
import sk.lukasdancak.treekey.entity.FamilyModel;
import sk.lukasdancak.treekey.entity.TreeModel;
import sk.lukasdancak.treekey.repository.TreeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreeService {


    private final TreeRepository treeRepository;
    private final FamilyService familyService;

    public TreeService(TreeRepository treeRepository, FamilyService familyService) {
        this.treeRepository = treeRepository;
        this.familyService = familyService;
    }


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
        // check if in database exists record with name familyName
        if (treeDTO.familyName() == null || treeDTO.familyName() == "") {
            errors.add("Empty familyName of treeDTO");
        } else {
            try {
                family = familyService.getFamilyByName(treeDTO.familyName());
            } catch (Exception e) {
                throw new DbComunicationProblemCustom(
                        "Problem s databazou: treeService.add()>familyService.getFamilyByName(...)", e);
            }
            if (family == null) {
                errors.add("Posted familyname is not allowed/ not in database");
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
}
