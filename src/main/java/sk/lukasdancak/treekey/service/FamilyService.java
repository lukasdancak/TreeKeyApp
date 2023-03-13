package sk.lukasdancak.treekey.service;

import org.springframework.stereotype.Service;
import sk.lukasdancak.treekey.entity.FamilyModel;
import sk.lukasdancak.treekey.repository.FamilyRepository;

import java.util.List;

@Service
public class FamilyService {


    private final FamilyRepository familyRepository;

    public FamilyService(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }


    public FamilyModel getFamilyByName(String familyName) {
        return familyRepository.findFamilyModelByNameIs(familyName);
    }


}
