package mission.controller;

import mission.model.Reservation;
import mission.repository.ReservationRepository;
import mission.util.InputParser;
import mission.validate.InputValidator;
import mission.validate.ReservationValidator;
import mission.view.InputView;
import mission.view.OutputView;

public class ReservationController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;
    private final ReservationValidator reservationValidator;
    private final ReservationRepository repository;

    public ReservationController(InputView inputView, OutputView outputView,
                                 InputValidator inputValidator, ReservationValidator reservationValidator,
                                 ReservationRepository repository) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
        this.reservationValidator = reservationValidator;
        this.repository = repository;
    }

    public void run() {
        while (true) {
            String input = inputView.read();
            if (input.equalsIgnoreCase("exit")) {
                outputView.printExit();
                return;
            }

            try {
                inputValidator.validate(input);
                Reservation reservation = InputParser.parse(input);
                reservationValidator.validate(reservation);
                repository.save(reservation);
                outputView.printSaved();
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
            outputView.printAll(repository.findAll());
        }
    }
}
