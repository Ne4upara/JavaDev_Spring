package sergey.goit.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpdateNoteResponseTest {

    @Test
    void testGetError() {
        UpdateNoteResponse response = new UpdateNoteResponse(UpdateNoteResponse.Error.INSUFFICIENT_PRIVILEGES);
        assertEquals(UpdateNoteResponse.Error.INSUFFICIENT_PRIVILEGES, response.getError());
    }

    @Test
    void testSetError() {
        UpdateNoteResponse response = new UpdateNoteResponse(UpdateNoteResponse.Error.INVALID_CONTENT);
        response.setError(UpdateNoteResponse.Error.INVALID_TITLE);
        assertEquals(UpdateNoteResponse.Error.INVALID_TITLE, response.getError());
    }

    @Test
    void testSuccess() {
        UpdateNoteResponse response = UpdateNoteResponse.success();
        assertEquals(UpdateNoteResponse.Error.OK, response.getError());
    }

    @Test
    void testFailed() {
        UpdateNoteResponse response = UpdateNoteResponse.failed(UpdateNoteResponse.Error.INVALID_NOTE_ID);
        assertEquals(UpdateNoteResponse.Error.INVALID_NOTE_ID, response.getError());
    }
}