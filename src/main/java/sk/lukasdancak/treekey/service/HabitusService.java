package sk.lukasdancak.treekey.service;

import org.springframework.stereotype.Service;
import sk.lukasdancak.treekey.entity.HabitusModel;
import sk.lukasdancak.treekey.repository.HabitusRepository;

import java.util.List;

@Service
public class HabitusService {

    private final HabitusRepository habitusRepository;

    public HabitusService(HabitusRepository habitusRepository) {
        this.habitusRepository = habitusRepository;
    }

    public List<HabitusModel> getAll() {
            return habitusRepository.findAll()
                                    .stream()
                                    .filter(t->!t.getName().equals("N/A"))       //habitus with name "N/A" is filtered out
                                    .toList();

    }
}
