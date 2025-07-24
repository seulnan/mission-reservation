package mission;

import mission.controller.ReservationController;

public class Application {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        ReservationController controller = config.reservationController();
        controller.run();
    }
}
