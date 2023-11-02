package sergey.goit.service;

public class NotFoundIdException extends RuntimeException{

    public NotFoundIdException(Long id) {
        super("Note not found with id: " + id);
    }
}