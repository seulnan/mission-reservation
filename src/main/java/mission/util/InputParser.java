package mission.util;

import mission.model.Reservation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InputParser {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    public static Reservation parse(String input) {
        // 입력 형식: 2025-07-28T11:00 - 2025-07-28T13:00 - 박호건
        String[] parts = input.split(" - ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
        }

        LocalDateTime start = LocalDateTime.parse(parts[0].trim(), formatter);
        LocalDateTime end = LocalDateTime.parse(parts[1].trim(), formatter);
        String name = parts[2].trim();

        return new Reservation(start, end, name, LocalDateTime.now());
    }
}

