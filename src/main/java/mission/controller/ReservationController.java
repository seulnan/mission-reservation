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
    private final InputParser parser;
    private final InputValidator inputValidator;
    private final ReservationValidator reservationValidator;
    private final ReservationRepository repository;

    public ReservationController(InputView inputView, OutputView outputView, InputParser parser,
                                 InputValidator inputValidator, ReservationValidator reservationValidator,
                                 ReservationRepository repository) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.parser = parser;
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
                Reservation reservation = parser.parse(input);
                reservationValidator.validate(reservation);
                repository.save(reservation);
                outputView.printSaved(reservation);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
            outputView.printAll(repository.findAll());
        }
    }
}
