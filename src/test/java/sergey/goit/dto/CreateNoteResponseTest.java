package sergey.goit.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CreateNoteResponseTest {

    @Test
    void testGetError() {
        CreateNoteResponse response = new CreateNoteResponse(CreateNoteResponse.Error.INVALID_TITLE);
        assertEquals(CreateNoteResponse.Error.INVALID_TITLE, response.getError());
    }

    @Test
    void testSetError() {
        CreateNoteResponse response = new CreateNoteResponse(CreateNoteResponse.Error.INVALID_TITLE);
        response.setError(CreateNoteResponse.Error.OK);
        assertEquals(CreateNoteResponse.Error.OK, response.getError());
    }

    @Test
    void testSuccess() {
        CreateNoteResponse response = CreateNoteResponse.success();
        assertEquals(CreateNoteResponse.Error.OK, response.getError());
    }

    @Test
    void testFailed() {
        CreateNoteResponse response = CreateNoteResponse.failed(CreateNoteResponse.Error.INVALID_CONTENT);
        assertEquals(CreateNoteResponse.Error.INVALID_CONTENT, response.getError());
    }
}