package mission.model;

import java.time.LocalDateTime;

public record Reservation(LocalDateTime startsAt, LocalDateTime endsAt, String name, LocalDateTime reservedAt) {
}
