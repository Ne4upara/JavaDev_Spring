package sergey.goit.dto;

import sergey.goit.model.Note;

import java.util.List;

public class GetAllNoteResponse {
    private Error error;

    private List<Note> userNotes;

    public enum Error {
        OK,
        INVALID_SORT_BY,
        INVALID_SORT_ORDER,
        NOT_TWO_OPERATORS
    }

    public GetAllNoteResponse(Error error, List<Note> userNotes) {
        this.error = error;
        this.userNotes = userNotes;
    }

    public List<Note> getUserNotes() {
        return userNotes;
    }

    public void setUserNotes(List<Note> userNotes) {
        this.userNotes = userNotes;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public static GetAllNoteResponse success(List<Note> userNotes) {
        return new GetAllNoteResponse(Error.OK, userNotes);
    }

    public static GetAllNoteResponse failed(Error error) {
        return new GetAllNoteResponse(error, null);
    }
}