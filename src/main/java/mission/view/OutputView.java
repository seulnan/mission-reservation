package mission.view;

import mission.model.Reservation;

import java.util.List;


public class OutputView {

    public void printReservations(List<Reservation> reservations) {
        System.out.println("예약 목록");
        System.out.printf("|예약 시간\t\t|시작 시간\t\t|종료 시간\t\t|예약자 명\t|\n");
        System.out.printf("|-------------------|-------------------|-------------------|---------------|\n");

        for (Reservation r : reservations) {
            System.out.printf("|%s\t|%s\t|%s\t|%s\t\t|\n",
                    r.reservedAt(),
                    r.startsAt(),
                    r.endsAt(),
                    r.name()
            );
        }
    }

    public void printError(String message) {
        System.out.println("IllegalArgumentException : " + message);
    }
}
