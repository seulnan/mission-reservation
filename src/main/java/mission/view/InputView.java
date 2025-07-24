package mission.view;
import api.Console;

public class InputView {

    public String read() {
        System.out.println("예약할 날짜를 입력해주세요. \n>> ");
        String input = Console.readLine();
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값이 비어 있습니다.");
        }
        return input;
    }
}

