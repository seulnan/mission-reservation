package mission;

import mission.exception.InvalidReservationException;
import mission.exception.ReservationError;
import mission.model.Reservation;
import mission.repository.ReservationRepository;
import mission.validate.ReservationValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReservationValidatorTest {

    ReservationRepository repository;
    ReservationValidator validator;

    @BeforeEach
    void setUp() {
        repository = new ReservationRepository();
        validator = new ReservationValidator(repository);
    }

    @Test
    void 시작시간이_종료시간보다_늦으면_예외() {
        Reservation r = new Reservation(
                LocalDateTime.of(2025, 7, 28, 14, 0),
                LocalDateTime.of(2025, 7, 28, 13, 0),
                "홍길동"
        );

        InvalidReservationException e = assertThrows(InvalidReservationException.class,
                () -> validator.validate(r));
        assertTrue(e.getMessage().contains(ReservationError.INVALID_TIME_RANGE.getMessage()));
    }

    @Test
    void 과거시간에_대한_예약이면_예외() {
        Reservation r = new Reservation(
                LocalDateTime.now().minusHours(2),
                LocalDateTime.now().minusHours(1),
                "김철수"
        );

        InvalidReservationException e = assertThrows(InvalidReservationException.class,
                () -> validator.validate(r));
        assertTrue(e.getMessage().contains(ReservationError.PAST_RESERVATION.getMessage()));
    }

    @Test
    void 겹치는_시간이_있으면_예외() {
        // 기존 예약 등록
        Reservation existing = new Reservation(
                LocalDateTime.of(2025, 7, 28, 11, 0),
                LocalDateTime.of(2025, 7, 28, 13, 0),
                "기존예약"
        );
        repository.save(existing);

        // 겹치는 새 예약
        Reservation newRes = new Reservation(
                LocalDateTime.of(2025, 7, 28, 12, 30),
                LocalDateTime.of(2025, 7, 28, 13, 30),
                "새예약"
        );

        InvalidReservationException e = assertThrows(InvalidReservationException.class,
                () -> validator.validate(newRes));
        assertTrue(e.getMessage().contains(ReservationError.DUPLICATE_RESERVATION.getMessage()));
    }

    @Test
    void 유효한_예약이면_예외_없이_통과() {
        Reservation r = new Reservation(
                LocalDateTime.now().plusHours(1),
                LocalDateTime.now().plusHours(2),
                "유효예약"
        );

        assertDoesNotThrow(() -> validator.validate(r));
    }
}
