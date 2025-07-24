package mission;

import mission.controller.ReservationController;

public class Application {
    public static void main(String[] args) {
        ReservationController controller = AppConfig.reservationController();
        controller.run();
    }
}
