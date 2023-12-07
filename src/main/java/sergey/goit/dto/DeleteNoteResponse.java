package sergey.goit.dto;

public class DeleteNoteResponse {

    private Error error;

    public enum Error {
        OK,
        HAS_NOT_ADMIN,
        INVALID_NOTE_ID
    }

    public DeleteNoteResponse(Error error) {
        this.error = error;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public static DeleteNoteResponse success() {
        return new DeleteNoteResponse(DeleteNoteResponse.Error.OK);
    }

    public static DeleteNoteResponse failed(DeleteNoteResponse.Error error) {
        return new DeleteNoteResponse(error);
    }
}
