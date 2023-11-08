package sergey.goit.service;

import org.springframework.stereotype.Service;
import sergey.goit.entities.Note;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteCrud {

    private Long count = 0L;
    private Map<Long, Note> notes;

    public NoteCrud() {
        notes = new HashMap<>();
    }

    public void addNote(Note note) {
        count++;
        note.setId(count);
        notes.put(note.getId(), note);
    }

    public Note getNoteById(Long id) {
       try{
           notFoundIdException(id);
        }catch (NotFoundIdException e){
            System.err.println(e.getMessage());
        }
        return notes.get(id);
    }

    public void deleteById(Long id) {
        try {
            notFoundIdException(id);
            notes.remove(id);
        } catch (NotFoundIdException e) {
            System.err.println(e.getMessage());
        }
    }

    public void update(Note note) {
        try {
            notFoundIdException(note.getId());
            notes.put(note.getId(), note);
        } catch (NotFoundIdException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    public void notFoundIdException(Long id) {
        if (!notes.containsKey(id)) {
            throw new NotFoundIdException(id);
        }
    }
}