package sergey.goit.service;

import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sergey.goit.dto.*;
import sergey.goit.model.Note;
import sergey.goit.repository.NoteRepository;

import java.security.Principal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class NoteService {

    private NoteRepository noteRepository;

    private final int MAX_TITLE_LENGTH = 100;
    private final int MAX_CONTENT_LENGTH = 500;
    private Sort sort;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public GetAllNoteResponse getAllNotes(String sortBy, String sortOrder) {
        Optional<GetAllNoteResponse.Error> sortError = validateSorted(sortBy, sortOrder);
        if (sortError.isPresent()) {
            return GetAllNoteResponse.failed(sortError.get());
        }

        if ("asc".equalsIgnoreCase(sortOrder)) {
            sort = Sort.by(Sort.Order.asc(sortBy));
        } else if ("desc".equalsIgnoreCase(sortOrder)) {
            sort = Sort.by(Sort.Order.desc(sortBy));
        }
        List<Note> userNotes = noteRepository.findAll(sort);
        return GetAllNoteResponse.success(userNotes);
    }

    public CreateNoteResponse createNote(String userName, CreateNoteRequest request) {
        Optional<CreateNoteResponse.Error> validationError = validateCreateFields(request);

        if (validationError.isPresent()) {
            return CreateNoteResponse.failed(validationError.get());
        }
        Note note = new Note();
        note.setUserName(userName);
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        noteRepository.save(note);

        return CreateNoteResponse.success();

    }

    public UpdateNoteResponse updateNote(Long id, UpdateNoteRequest request, String userName) {
        Optional<Note> optionalNote = noteRepository.findById(id);

        if (optionalNote.isEmpty()) {
            return UpdateNoteResponse.failed(UpdateNoteResponse.Error.INVALID_NOTE_ID);
        }

        Note note = optionalNote.get();

        if (!userName.equals(note.getUserName())) {
            return UpdateNoteResponse.failed(UpdateNoteResponse.Error.INSUFFICIENT_PRIVILEGES);
        }

        Optional<UpdateNoteResponse.Error> validated = validateUpdateFields(request);

        if (validated.isPresent()) {
            return UpdateNoteResponse.failed(validated.get());
        }

        note.setTitle(request.getTitle());
        note.setContent((request.getContent()));
        noteRepository.save(note);

        return UpdateNoteResponse.success();
    }

    public DeleteNoteResponse deleteNoteById(Long id, Principal principal) {
        Optional<Note> optionalNote = noteRepository.findById(id);

        if (optionalNote.isEmpty()) {
            return DeleteNoteResponse.failed(DeleteNoteResponse.Error.INVALID_NOTE_ID);
        }

        if (!isRoleAdmin(principal)) {
            return DeleteNoteResponse.failed(DeleteNoteResponse.Error.HAS_NOT_ADMIN);
        }

        Note note = optionalNote.get();
        noteRepository.delete(note);

        return DeleteNoteResponse.success();
    }

    private Optional<GetAllNoteResponse.Error> validateSorted(String sortBy, String sortOrder) {

        if (sortBy == null || sortOrder == null) {
            return Optional.of(GetAllNoteResponse.Error.NOT_TWO_OPERATORS);
        }

        if (!sortBy.equals("title") && !sortBy.equals("content")) {
            return Optional.of(GetAllNoteResponse.Error.INVALID_SORT_BY);
        }

        if (!sortOrder.equals("asc") && !sortOrder.equals("desc")) {
            return Optional.of(GetAllNoteResponse.Error.INVALID_SORT_ORDER);
        }

        return Optional.empty();
    }

    private Optional<CreateNoteResponse.Error> validateCreateFields(CreateNoteRequest request) {
        if (Objects.isNull(request.getTitle()) || request.getTitle().length() > MAX_TITLE_LENGTH) {
            return Optional.of(CreateNoteResponse.Error.INVALID_TITLE);
        }

        if (Objects.isNull(request.getContent()) || request.getContent().length() > MAX_CONTENT_LENGTH) {
            return Optional.of(CreateNoteResponse.Error.INVALID_CONTENT);
        }

        return Optional.empty();
    }

    private Optional<UpdateNoteResponse.Error> validateUpdateFields(UpdateNoteRequest request) {
        if (Objects.isNull(request.getTitle()) || request.getTitle().length() > MAX_TITLE_LENGTH) {
            return Optional.of(UpdateNoteResponse.Error.INVALID_TITLE);
        }

        if (Objects.isNull(request.getContent()) || request.getContent().length() > MAX_CONTENT_LENGTH) {
            return Optional.of(UpdateNoteResponse.Error.INVALID_CONTENT);
        }

        return Optional.empty();
    }

    private boolean isRoleAdmin(Principal principal) {
        if (principal != null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String userRole = authentication
                    .getAuthorities()
                    .stream()
                    .findFirst()
                    .map(Objects::toString)
                    .orElse(null);
            if (userRole.equals("ROLE_ADMIN")) {
                return true;
            }
        }
        return false;
    }
}
