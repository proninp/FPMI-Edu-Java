package ru.mfti;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.mfti.ArithmeticCalculator.Calculator;
import ru.mfti.ArithmeticCalculator.ExpressionConverter;
import ru.mfti.ArithmeticCalculator.ICalculate;

//REST API
@RestController
@RequestMapping("api")
public class SummatorController {
    static ICalculate calculator = new Calculator(new ExpressionConverter());

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String demo(String expression) {
        return "Demo - Application is up and running!";
    }

    @GetMapping("/make")
    public String arithmeticExpression(String expression) {
        return fun(expression);
    }

    public static String fun(String str){
        try {
            return calculator.calculate(str);
        } catch (ArithmeticException | IllegalArgumentException ex) {
            return ex.getMessage();
        } catch (Exception ex) {
            return String.format("Сервис вернул ошибку при попытке вычислить варажение. Ошибка:%n%s", ex.getMessage());
        }
    }
}
