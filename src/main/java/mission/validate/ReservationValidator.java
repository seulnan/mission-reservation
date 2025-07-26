package mission.validate;

import java.time.LocalDateTime;
import mission.exception.InvalidReservationException;
import mission.exception.ReservationError;
import mission.model.Reservation;
import mission.repository.ReservationRepository;

public class ReservationValidator {
    private final ReservationRepository repository;

    public ReservationValidator(ReservationRepository repository) {
        this.repository = repository;
    }

    public void validate(Reservation newReservation) {
        validateTimeOrder(newReservation);
        validateNotPast(newReservation);
        validateNoOverlap(newReservation);
    }

    private void validateTimeOrder(Reservation reservation) {
        if (reservation.getStartsAt().isAfter(reservation.getEndsAt())) {
            throw new InvalidReservationException(ReservationError.INVALID_TIME_RANGE);
        }
    }

    private void validateNotPast(Reservation reservation) {
        if (reservation.getStartsAt().isBefore(LocalDateTime.now())) {
            throw new InvalidReservationException(ReservationError.PAST_RESERVATION);
        }
    }

    private void validateNoOverlap(Reservation newReservation) {
        repository.findAll().forEach(existing -> {
            boolean overlap = !(newReservation.getEndsAt().isBefore(existing.getStartsAt()) ||
                    newReservation.getStartsAt().isAfter(existing.getEndsAt()));
            if (overlap) {
                throw new InvalidReservationException(ReservationError.DUPLICATE_RESERVATION);
            }
        });
    }

}
