package sergey.goit.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sergey.goit.entities.Note;

import sergey.goit.service.NoteCrudService;

import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {

    private final NoteCrudService noteCrudService;

    @Autowired
    public NoteController(NoteCrudService noteCrudService) {
        this.noteCrudService = noteCrudService;
    }

    @GetMapping("/list")
    public String noteAllList(Model model, @RequestParam(value = "sort", required = false) String sort) {
        List<Note> allList = noteCrudService.allNote();
        if (sort != null && !sort.isEmpty()) {
            allList = noteCrudService.allNoteSorted(sort);
        }
        model.addAttribute("noteList", allList);
        return "list";
    }

    @PostMapping("/delete/{id}")
    public String deleteByid(@PathVariable Long id) {
        Note noteById = noteCrudService.getNoteById(id);
        noteCrudService.delete(noteById);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String editNoteById(Model model, @RequestParam(value = "id") Long id) {
        Note noteById = noteCrudService.getNoteById(id);
        noteCrudService.save(noteById);
        model.addAttribute("noteById", noteById);
        model.addAttribute("titleMesage", "Edit Notes");
        return "edit";
    }

    @PostMapping("/edit")
    public String updateNote(@ModelAttribute Note note) {
        noteCrudService.updatesNote(note);
        return "redirect:/note/list";
    }

    @PostMapping("/create")
    public String createNote(Model model) {
        Note newNote = new Note();
        model.addAttribute("noteById", newNote);
        model.addAttribute("titleMesage", "Create Note");
        return "edit";
    }

    @ModelAttribute("noteList")
    public List<Note> noteList() {
        return noteCrudService.allNote();
    }

    @GetMapping("/search")
    public String searchBy(Model model, @RequestParam("query") String query, @RequestParam("searchBy") String searchBy) {
        List<Note> allList = noteCrudService.searchBy(searchBy, query);
        model.addAttribute("noteList", allList);
        return "list";
    }
}