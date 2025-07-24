package mission.validate;

import java.time.LocalDateTime;
import mission.exception.ReservationError;
import mission.model.Reservation;

import java.time.LocalDate;
import java.util.List;
import mission.repository.ReservationRepository;

public class ReservationValidator {
    private final ReservationRepository repository;

    public ReservationValidator(ReservationRepository repository) {
        this.repository = repository;
    }

    public void validate(Reservation newReservation) {
        if (newReservation.getStartsAt().isAfter(newReservation.getEndsAt())) {
            throw new IllegalArgumentException(ReservationError.INVALID_TIME_RANGE.getMessage());
        }

        if (newReservation.getStartsAt().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException(ReservationError.PAST_RESERVATION.getMessage());
        }

        repository.findAll().forEach(existing -> {
            boolean overlap = !(newReservation.getEndsAt().isBefore(existing.getStartsAt()) ||
                    newReservation.getStartsAt().isAfter(existing.getEndsAt()));
            if (overlap) {
                throw new IllegalArgumentException(ReservationError.DUPLICATE_RESERVATION.getMessage());
            }
        });
    }
}
