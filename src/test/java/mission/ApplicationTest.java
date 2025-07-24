package mission;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import api.TestEnvironment;
import java.util.List;
import org.junit.jupiter.api.Test;


public class ApplicationTest extends TestEnvironment {

    @Test
    void testApplication() {
        // 1) 정상 예약 → 목록 조회 → 종료
        run(
                "2025-07-28T11:00 - 2025-07-28T13:00 - 박호건",
                "exit"
        );
        String output = output();

        // "예약 목록" 으로 시작하는지
        assertTrue(output.startsWith("예약 목록"));
        // 헤더가 포함되어 있는지
        assertTrue(output.contains("|예약 시간\t\t|시작 시간\t\t|종료 시간\t\t|예약자 명\t|"));
        assertTrue(output.contains("|-------------------|-------------------|-------------------|---------------|"));
        // 데이터 라인에 시작 시간과 예약자명이 포함되어 있는지
        assertTrue(output.contains("2025-07-28T11:00") && output.contains("박호건"));

        // 2) 잘못된 입력 (시작 > 종료) 시 IllegalArgumentException 발생
        assertThrows(IllegalArgumentException.class, () -> {
            run("2025-07-29T11:00 - 2025-07-28T13:00 - 박호건");
        });

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
