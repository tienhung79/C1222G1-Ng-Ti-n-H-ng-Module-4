package caculator.service.iml;

import caculator.service.ICaculatorService;
import org.springframework.stereotype.Service;

@Service

public class CaculatorService implements ICaculatorService {
    @Override
    public Object caculate(int number1, int number2, String caculate) {
        String message = "Phép tính không hợp lệ";
        switch (caculate) {
            case "add":
                return number1 + number2;
            case "apart":
                return number1 - number2;
            case "core":
                return number1 * number2;
            case "divide":
                return number1 / number2;
            default:
                return message;
        }

    }
}
