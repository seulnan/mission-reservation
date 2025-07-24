package mission.validate;


import mission.exception.ReservationError;

public class InputValidator {
    public void validate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ReservationError.NULL_INPUT.getMessage());
        }

        if (!input.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2} - \\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2} - .+")) {
            throw new IllegalArgumentException(ReservationError.INVALID_FORMAT.getMessage());
        }
    }
}
