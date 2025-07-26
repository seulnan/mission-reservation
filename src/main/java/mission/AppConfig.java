package mission;

import mission.controller.ReservationController;
import mission.repository.ReservationRepository;
import mission.validate.InputValidator;
import mission.validate.ReservationValidator;
import mission.view.InputView;
import mission.view.OutputView;

public class AppConfig {
    public ReservationController reservationController() {
        return new ReservationController(
                inputView(),
                outputView(),
                inputValidator(),
                reservationValidator(),
                reservationRepository()
        );
    }

    // TODO:
    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public InputValidator inputValidator() {
        return new InputValidator();
    }

    public ReservationValidator reservationValidator() {
        return new ReservationValidator(reservationRepository());
    }

    public ReservationRepository reservationRepository() {
        return new ReservationRepository();
    }
}
