package sergey.goit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sergey.goit.model.Note;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("FROM Note n WHERE n.title LIKE %:title%")
    List<Note> searchByTitle(@Param("title") String title);

    @Query("FROM Note n WHERE n.content LIKE %:content%")
    List<Note> searchByContent(@Param("content") String content);
}
