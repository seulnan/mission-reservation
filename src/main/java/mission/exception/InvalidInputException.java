package mission.exception;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(InputError error) {
        super(error.getMessage());
    }
}
