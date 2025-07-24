package mission.view;

import java.time.format.DateTimeFormatter;
import mission.model.Reservation;

import java.util.List;


public class OutputView {
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    public void printSaved(Reservation r) {
        System.out.println("예약이 완료되었습니다.");
    }

    public void printAll(List<Reservation> reservations) {
        System.out.println("예약 목록");
        System.out.println("|예약 시간\t\t\t|시작 시간\t\t\t|종료 시간\t\t\t|예약자 명\t|");
        System.out.println("|-------------------|-------------------|-------------------|---------------|");
        for (Reservation r : reservations) {
            System.out.printf("|%s\t|%s\t|%s\t|%s\t|\n",
                    FORMAT.format(r.getReservedAt()),
                    FORMAT.format(r.getStartsAt()),
                    FORMAT.format(r.getEndsAt()),
                    r.getName());
        }
    }

    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void printExit() {
        System.out.println("프로그램을 종료합니다.");
    }
}
