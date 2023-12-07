package sergey.goit.dto;

public class UpdateNoteResponse {

    private Error error;

    public enum Error {
        OK,
        INSUFFICIENT_PRIVILEGES,
        INVALID_NOTE_ID,
        INVALID_TITLE,
        INVALID_CONTENT
    }

    public UpdateNoteResponse(Error error) {
        this.error = error;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public static UpdateNoteResponse success() {
        return new UpdateNoteResponse(UpdateNoteResponse.Error.OK);
    }

    public static UpdateNoteResponse failed(UpdateNoteResponse.Error error) {
        return new UpdateNoteResponse(error);
    }
}
