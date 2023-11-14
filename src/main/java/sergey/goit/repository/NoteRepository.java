package sergey.goit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sergey.goit.entities.Note;

@Repository
public interface NoteRepository extends JpaRepository <Note, Integer>  {
}
