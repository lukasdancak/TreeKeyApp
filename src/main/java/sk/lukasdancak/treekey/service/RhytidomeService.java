package sk.lukasdancak.treekey.service;

import org.springframework.stereotype.Service;
import sk.lukasdancak.treekey.entity.RhytidomeModel;
import sk.lukasdancak.treekey.repository.RhytidomeRepository;

import java.util.List;

@Service
public class RhytidomeService {

    private final RhytidomeRepository rhytidomeRepository;

    public RhytidomeService(RhytidomeRepository rhytidomeRepository) {
        this.rhytidomeRepository = rhytidomeRepository;
    }

    public List<RhytidomeModel> getAll(){
        return rhytidomeRepository.findAll()
                                  .stream()
                                  .filter(t->!t.getName().equals("N/A"))
                                  .toList();
    }
}
