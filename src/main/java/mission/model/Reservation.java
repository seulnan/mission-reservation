package mission.model;

import java.time.LocalDateTime;

public class Reservation {
    private final LocalDateTime reservedAt;
    private final LocalDateTime startsAt;
    private final LocalDateTime endsAt;
    private final String name;

    public Reservation(LocalDateTime startsAt, LocalDateTime endsAt, String name) {
        this.reservedAt = LocalDateTime.now();
        this.startsAt = startsAt;
        this.endsAt = endsAt;
        this.name = name;
    }

    public LocalDateTime getReservedAt() { return reservedAt; }
    public LocalDateTime getStartsAt() { return startsAt; }
    public LocalDateTime getEndsAt() { return endsAt; }
    public String getName() { return name; }
}
