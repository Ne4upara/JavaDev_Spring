package sergey.goit.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sergey.goit.entities.Note;
import sergey.goit.service.NoteCrud;
import sergey.goit.service.NoteCrudJpa;

import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {

//    private final NoteCrud noteCrud;
    private final NoteCrudJpa noteCrudJpa;

//    @Autowired
//    public NoteController(NoteCrud noteCrud) {
//        this.noteCrud = noteCrud;
//    }

    public NoteController(NoteCrudJpa noteCrudJpa){
        this.noteCrudJpa=noteCrudJpa;
    }

    @GetMapping("/list")
    public String noteAllList(Model model) {
        List<Note> allList = noteCrudJpa.allNote();
        model.addAttribute("noteList", allList);
        return "list";
    }

//    @PostMapping("/delete/{id}")
//    public String deleteByid(@PathVariable Long id) {
////        noteCrud.deleteById(id);
//        return "redirect:/note/list";
//    }

//    @GetMapping("/edit")
//    public String editNoteById(Model model, @RequestParam(value = "id") Long id) {
//        Note note = noteCrud.getNoteById(id);
//        if (note != null) {
//            model.addAttribute("noteById", note);
//            model.addAttribute("titleMesage", "Edit Notes");
//            return "edit";
//        } else {
//            model.addAttribute("errorMessage", "Not found " + id + " id.");
//            return "errorPage";
//        }
//    }

//    @PostMapping("/edit")
//    public String updateNote(@ModelAttribute Note note) {
////        noteCrud.update(note);
//        return "redirect:/note/list";
//    }

    @PostMapping("/create")
    public String createNote(Model model) {
        Note newNote = new Note();
        noteCrudJpa.save(newNote);
//        addNote(newNote);
        model.addAttribute("noteById", newNote);
        model.addAttribute("titleMesage", "Create Note");
        return "edit";
    }
}