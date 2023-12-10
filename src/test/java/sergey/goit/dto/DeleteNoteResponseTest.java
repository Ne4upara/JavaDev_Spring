package sergey.goit.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteNoteResponseTest {

    @Test
    void testGetError() {
        DeleteNoteResponse response = new DeleteNoteResponse(DeleteNoteResponse.Error.HAS_NOT_ADMIN);
        assertEquals(DeleteNoteResponse.Error.HAS_NOT_ADMIN, response.getError());
    }

    @Test
    void testSetError() {
        DeleteNoteResponse response = new DeleteNoteResponse(DeleteNoteResponse.Error.INVALID_NOTE_ID);
        response.setError(DeleteNoteResponse.Error.OK);
        assertEquals(DeleteNoteResponse.Error.OK, response.getError());
    }

    @Test
    void testSuccess() {
        DeleteNoteResponse response = DeleteNoteResponse.success();
        assertEquals(DeleteNoteResponse.Error.OK, response.getError());
    }

    @Test
    void testFailed() {
        DeleteNoteResponse response = DeleteNoteResponse.failed(DeleteNoteResponse.Error.INVALID_NOTE_ID);
        assertEquals(DeleteNoteResponse.Error.INVALID_NOTE_ID, response.getError());
    }
}