package mission.exception;

public enum ReservationError {
    INVALID_TIME_RANGE("시작 시간이 종료 시간보다 늦을 수 없습니다."),
    PAST_RESERVATION("과거 시간으로는 예약할 수 없습니다."),
    DUPLICATE_RESERVATION("해당 시간에 이미 예약이 존재합니다.");

    private final String message;

    ReservationError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
