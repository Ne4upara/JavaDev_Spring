package sergey.goit.service;

import org.springframework.stereotype.Service;
import sergey.goit.entities.Note;
import sergey.goit.repository.NoteRepository;
import java.util.List;

@Service
public class NoteCrudJpa {

    private final NoteRepository noteRepository;

    public NoteCrudJpa(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    public Note save(Note note){
        return noteRepository.save(note);
    }

    public void delete(Note note){
        noteRepository.delete(note);
    }

    public Note getNoteById(int id){
        return noteRepository.findById(id).orElse(null);
    }

    public List<Note> allNote(){
        return noteRepository.findAll();
    }
}