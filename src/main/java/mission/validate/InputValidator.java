package mission.validate;


import mission.exception.InputError;
import mission.exception.InvalidInputException;

public class InputValidator {
    public void validate(String input) {
        if (input == null || input.isBlank()) {
            throw new InvalidInputException(InputError.NULL_INPUT);
        }

        if (!input.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2} - \\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2} - .+")) {
            throw new InvalidInputException(InputError.INVALID_FORMAT);
        }
    }
}
