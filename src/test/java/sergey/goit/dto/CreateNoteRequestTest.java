package sergey.goit.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateNoteRequestTest {

    @Test
    void testGetTitle() {
        CreateNoteRequest request = new CreateNoteRequest("Test Title","Test Content");
        assertEquals("Test Title", request.getTitle());
    }

    @Test
    void testSetTitle() {
        CreateNoteRequest request = new CreateNoteRequest("Test Title", "Test Content");
        request.setTitle("New Title");
        assertEquals("New Title", request.getTitle());
    }

    @Test
    void testGetContent() {
        CreateNoteRequest request = new CreateNoteRequest("Test Title","Test Content");
        assertEquals("Test Content", request.getContent());
    }

    @Test
    void testSetContent() {
        CreateNoteRequest request = new CreateNoteRequest("Test Title", "Test Content");
        request.setContent("New Content");
        assertEquals("New Content", request.getContent());
    }
}