package mission.util;

import mission.model.Reservation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InputParser {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    public static Reservation parse(String input) {
        try {
            String[] parts = input.split(" - ");
            LocalDateTime startsAt = LocalDateTime.parse(parts[0], FORMATTER);
            LocalDateTime endsAt = LocalDateTime.parse(parts[1], FORMATTER);
            String name = parts[2].trim();
            return new Reservation(startsAt, endsAt, name);
        } catch (Exception e) {
            throw new IllegalArgumentException("입력 형식이 올바르지 않습니다. 예: 2025-07-28T11:00 - 2025-07-28T13:00 - 홍길동");
        }
    }
}

