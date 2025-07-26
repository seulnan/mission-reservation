package mission.view;
import api.Console;

public class InputView {

    public String read() {
        System.out.println("예약할 날짜를 입력해주세요. \n>> ");
        return Console.readLine();
    }
}

