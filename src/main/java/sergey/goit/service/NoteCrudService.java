package sergey.goit.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sergey.goit.model.Note;
import sergey.goit.exception.NotFoundException;
import sergey.goit.exception.NotSortedException;
import sergey.goit.repository.NoteRepository;
import java.util.List;

@Service
public class NoteCrudService {

    private final NoteRepository noteRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(NoteCrudService.class);

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

    public void updatesNote (Note note){
        save(note);
    }

    public List<Note> allNoteSorted(String sortOrder) {
        if(sortOrder.equals("asc")){
            return noteRepository.findAll(Sort.by(Sort.Order.asc("title")));
        } else if (sortOrder.equals("desc")) {
            return noteRepository.findAll(Sort.by(Sort.Order.desc("title")));
        }else{
            LOGGER.error("Invalid sorted -> " + sortOrder);
            throw new NotSortedException("Invalid sorted");
        }
    }

    public List<Note> searchBy(String searchBy, String query) {
        if (searchBy.equals("title")) {
            return noteRepository.searchByTitle(query);
        } else if (searchBy.equals("content")) {
            return noteRepository.searchByContent(query);
        }
        else {
            LOGGER.error("Invalid search -> " + searchBy);
            throw new NotFoundException("Invalid search criteria -> " + searchBy);

        }
    }
}