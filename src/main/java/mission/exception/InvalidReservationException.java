package mission.exception;

public class InvalidReservationException extends RuntimeException {
  public InvalidReservationException(ReservationError error) {
    super(error.getMessage());
  }
}
