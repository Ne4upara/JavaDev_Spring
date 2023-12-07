package sergey.goit.controler;

import org.springframework.web.bind.annotation.*;
import sergey.goit.dto.*;
import sergey.goit.service.NoteService;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/notes")

public class NoteRestController {

    private final NoteService noteService;

    public NoteRestController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public GetAllNoteResponse getAllNotes(@RequestParam(value = "sortBy", required = false) String sortBy,
                                          @RequestParam(value = "sortOrder", required = false) String sortOder){
        return noteService.getAllNotes(sortBy,sortOder);
    }

    @PostMapping
    public CreateNoteResponse createNote (@RequestBody CreateNoteRequest createNoteRequest, Principal principal){
        return noteService.createNote(principal.getName(), createNoteRequest);
    }

    @PostMapping("/{id}")
    public UpdateNoteResponse updateNote
            (@PathVariable Long id, @RequestBody UpdateNoteRequest request, Principal principal){
        return noteService.updateNote(id, request, principal.getName());
    }

    @PostMapping("/remove/{id}")
    public DeleteNoteResponse deleteNoteBuId(@PathVariable Long id, Principal principal){
        return noteService.deleteNoteById(id, principal);
    }
}