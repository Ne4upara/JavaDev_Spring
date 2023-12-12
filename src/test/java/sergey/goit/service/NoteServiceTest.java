package sergey.goit.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sergey.goit.dto.GetAllNoteResponse;
import sergey.goit.model.Note;
import sergey.goit.repository.NoteRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NoteServiceTest {
    @Mock
    private NoteRepository noteRepository;
    @InjectMocks
    private NoteService service;

    @Test
    void getAllNotes() {
        Note note = new Note();
        when(noteRepository.findAll()).thenReturn(List.of(note));
        GetAllNoteResponse allNotes = service.getAllNotes(null, null);
        assertThat(allNotes.getUserNotes()).hasSize(1);

    }

    @Test
    void createNote() {
    }

    @Test
    void updateNote() {
    }

    @Test
    void deleteNoteById() {
    }
}