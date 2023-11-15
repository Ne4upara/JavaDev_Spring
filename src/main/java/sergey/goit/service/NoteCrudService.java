package sergey.goit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sergey.goit.entities.Note;
import sergey.goit.repository.NoteRepository;
import java.util.List;

@Service
public class NoteCrudService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteCrudService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note save(Note note) {
        return noteRepository.save(note);
    }

    public void delete(Note note) {
        noteRepository.delete(note);
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public List<Note> allNote() {
        return noteRepository.findAll();
    }

    public List<Note> allNoteSorted(String sortOrder) {
        Sort sort = sortOrder.equals("asc") ?
                Sort.by(Sort.Order.asc("title")) :
                Sort.by(Sort.Order.desc("title"));
        return noteRepository.findAll(sort);
    }

    public List<Note> searchBy(String searchBy, String query) {
        if (searchBy.equals("title")) {
            return noteRepository.searchByTitle(query);
        } else if (searchBy.equals("content")) {
            return noteRepository.searchByContent(query);
        }
        return null;
    }
}