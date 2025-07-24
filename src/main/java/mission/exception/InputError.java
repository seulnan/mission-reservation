package mission.exception;

public enum InputError {
    NULL_INPUT("입력이 비어 있습니다."),
    INVALID_FORMAT("입력 형식이 잘못되었습니다. 예: 2025-07-28T11:00 - 2025-07-28T13:00 - 홍길동");

    private final String message;


    InputError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
