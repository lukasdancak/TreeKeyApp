package sk.lukasdancak.treekey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.lukasdancak.treekey.entity.HabitusModel;

@Repository
public interface HabitusRepository extends JpaRepository<HabitusModel, String> {
}
