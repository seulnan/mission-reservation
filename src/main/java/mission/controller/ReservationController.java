package mission.controller;


import mission.model.Reservation;
import mission.repository.ReservationRepository;
import mission.util.InputParser;
import mission.validate.ReservationValidator;
import mission.view.InputView;
import mission.view.OutputView;

public class ReservationController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final ReservationRepository repository = new ReservationRepository();

    public void run() {
        while (true) {
            String input = inputView.readReservationInput();

            // 종료 조건
            if ("exit".equalsIgnoreCase(input)) {
                break;
            }

            try {
                // 파싱 & 검증 & 저장
                Reservation reservation = InputParser.parse(input);
                ReservationValidator.validateReservationTime(reservation);
                ReservationValidator.validateReservationOverlap(reservation, repository.findAll());
                repository.save(reservation);

                // 저장 직후 자동으로 전체 목록 출력
                outputView.printReservations(repository.findAll());
            } catch (IllegalArgumentException e) {
                // 예외 발생 시 메시지 출력 후 프로그램 종료
                outputView.printError(e.getMessage());
                return;
            }
        }
    }
}
