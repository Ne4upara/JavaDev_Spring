package sergey.goit.dto;

import org.junit.jupiter.api.Test;
import sergey.goit.model.Note;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class GetAllNoteResponseTest {

    @Test
    public void testGetUserNotes() {
        List<Note> notes = Arrays.asList(new Note(), new Note());
        GetAllNoteResponse response = new GetAllNoteResponse(GetAllNoteResponse.Error.OK, notes);
        assertEquals(notes, response.getUserNotes());
    }

    @Test
    public void testSetUserNotes() {
        List<Note> notes = Arrays.asList(new Note(), new Note());
        GetAllNoteResponse response = new GetAllNoteResponse(GetAllNoteResponse.Error.OK, null);
        response.setUserNotes(notes);
        assertEquals(notes, response.getUserNotes());
    }

    @Test
    public void testGetError() {
        GetAllNoteResponse response = new GetAllNoteResponse(GetAllNoteResponse.Error.INVALID_SORT_BY, null);
        assertEquals(GetAllNoteResponse.Error.INVALID_SORT_BY, response.getError());
    }

    @Test
    public void testSetError() {
        GetAllNoteResponse response = new GetAllNoteResponse(null, null);
        response.setError(GetAllNoteResponse.Error.INVALID_SORT_ORDER);
        assertEquals(GetAllNoteResponse.Error.INVALID_SORT_ORDER, response.getError());
    }

    @Test
    public void testSuccess() {
        List<Note> notes = Arrays.asList(new Note(), new Note());
        GetAllNoteResponse response = GetAllNoteResponse.success(notes);
        assertEquals(GetAllNoteResponse.Error.OK, response.getError());
        assertEquals(notes, response.getUserNotes());
    }

    @Test
    public void testFailed() {
        GetAllNoteResponse response = GetAllNoteResponse.failed(GetAllNoteResponse.Error.NOT_TWO_OPERATORS);
        assertEquals(GetAllNoteResponse.Error.NOT_TWO_OPERATORS, response.getError());
        assertNull(response.getUserNotes());
    }
}