package mission.repository;

import mission.model.Reservation;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {
    private final List<Reservation> reservations = new ArrayList<>();

    public void save(Reservation reservation) {
        reservations.add(reservation);
    }

    public List<Reservation> findAll() {
        return new ArrayList<>(reservations);
    }
}
