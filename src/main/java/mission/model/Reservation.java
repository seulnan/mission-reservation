package mission.model;

import java.time.LocalDateTime;

public class Reservation {
    private final LocalDateTime startsAt;
    private final LocalDateTime endsAt;
    private final String name;
    private final LocalDateTime reservedAt;

    public Reservation(LocalDateTime startsAt, LocalDateTime endsAt, String name, LocalDateTime reservedAt) {
        this.startsAt = startsAt;
        this.endsAt = endsAt;
        this.name = name;
        this.reservedAt = reservedAt;
    }

    public LocalDateTime getStartsAt() {
        return startsAt;
    }

    public LocalDateTime getEndsAt() {
        return endsAt;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getReservedAt() {
        return reservedAt;
    }
}
