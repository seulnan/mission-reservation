package mission;

import mission.exception.InputError;
import mission.exception.InvalidInputException;
import mission.validate.InputValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    InputValidator validator = new InputValidator();

    @Test
    void 빈_문자열_입력시_예외() {
        InvalidInputException e = assertThrows(InvalidInputException.class,
                () -> validator.validate("   "));
        assertTrue(e.getMessage().contains(InputError.NULL_INPUT.getMessage()));
    }

    @Test
    void 형식이_잘못된_입력시_예외() {
        String input = "2025/07/28 11:00 - 2025/07/28 13:00 - 홍길동";
        InvalidInputException e = assertThrows(InvalidInputException.class,
                () -> validator.validate(input));
        assertTrue(e.getMessage().contains(InputError.INVALID_FORMAT.getMessage()));
    }

    @Test
    void 올바른_형식_입력시_통과() {
        String input = "2025-07-28T11:00 - 2025-07-28T13:00 - 홍길동";
        assertDoesNotThrow(() -> validator.validate(input));
    }
}
