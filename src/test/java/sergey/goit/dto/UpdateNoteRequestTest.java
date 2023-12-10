package sergey.goit.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpdateNoteRequestTest {

    @Test
    void testGetTitle() {
        UpdateNoteRequest request = new UpdateNoteRequest("Test Title", "Test Content");
        assertEquals("Test Title", request.getTitle());
    }

    @Test
    void testSetTitle() {
        UpdateNoteRequest request = new UpdateNoteRequest("Test Title", "Test Content");
        request.setTitle("New Title");
        assertEquals("New Title", request.getTitle());
    }

    @Test
    void testGetContent() {
        UpdateNoteRequest request = new UpdateNoteRequest("Test Title", "Test Content");
        assertEquals("Test Content", request.getContent());
    }

    @Test
    void testSetContent() {
        UpdateNoteRequest request = new UpdateNoteRequest("Test Title", "Test Content");
        request.setContent("New Content");
        assertEquals("New Content", request.getContent());
    }
}