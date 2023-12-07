package sergey.goit.dto;

public class CreateNoteResponse {

    private Error error;

    public enum Error {
        OK,
        INVALID_TITLE,
        INVALID_CONTENT
    }

    public CreateNoteResponse(Error error) {
        this.error = error;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public static CreateNoteResponse success() {
        return new CreateNoteResponse(Error.OK);
    }

    public static CreateNoteResponse failed(Error error) {
        return new CreateNoteResponse(error);
    }


}
