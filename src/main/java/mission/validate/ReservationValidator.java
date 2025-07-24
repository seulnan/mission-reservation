package mission.validate;

import mission.model.Reservation;

import java.time.LocalDate;
import java.util.List;

public class ReservationValidator {
    private static final LocalDate START_DATE = LocalDate.of(2025, 7, 28);
    private static final LocalDate END_DATE = LocalDate.of(2025, 8, 3);

    public static void validateReservationTime(Reservation r) {
        if (r.startsAt().isAfter(r.endsAt())) {
            throw new IllegalArgumentException("시작 날짜가 종료 날짜보다 늦습니다.");
        }
        if (r.startsAt().toLocalDate().isBefore(START_DATE) ||
                r.endsAt().toLocalDate().isAfter(END_DATE)) {
            throw new IllegalArgumentException("예약 가능한 날짜는 2025-07-28부터 2025-08-03까지입니다.");
        }
    }

    public static void validateReservationOverlap(Reservation newRes, List<Reservation> existing) {
        for (Reservation r : existing) {
            boolean overlaps = newRes.startsAt().isBefore(r.endsAt()) &&
                    newRes.endsAt().isAfter(r.startsAt());
            if (overlaps) {
                throw new IllegalArgumentException("해당 시간에 예약이 존재합니다.");
            }
        }
    }
}
