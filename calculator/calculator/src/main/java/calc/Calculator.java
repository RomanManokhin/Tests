package calc;

/**
 * Класс для осуществления математических вычислений
 */
public class Calculator {

    /**
     * Метод для вычисления
     */
    public String calculate(String firstNumber, String sign, String secondNumber, int type) throws Exception {
        String result;

        NumberConverter nc = new NumberConverter();

        if (nc.check(firstNumber) == 0 && nc.check(secondNumber) == 1
                || nc.check(firstNumber) == 1 && nc.check(secondNumber) == 0) {
            throw new Exception("Операция не возможна между арабскими и римскими цифрами");
        }

        switch (sign) {
            case "+":
                result = String.valueOf(nc.convertToNumber(firstNumber) + nc.convertToNumber(secondNumber));
                break;
            case "-":
                result = String.valueOf(nc.convertToNumber(firstNumber) - nc.convertToNumber(secondNumber));
                break;
            case "*":
                result = String.valueOf(nc.convertToNumber(firstNumber) * nc.convertToNumber(secondNumber));
                break;
            case "/":
                result = String.valueOf(nc.convertToNumber(firstNumber) / nc.convertToNumber(secondNumber));
                break;
            default:
                throw new Exception("Введён не корректный математический символ");
        }

        if (type == 1) {
            try {
                result = nc.arabicNumberToRoman(Integer.parseInt(result));
            } catch (NullPointerException e){
                throw new NullPointerException("Нельзя отнимать меньшее от большего," +
                        " так же нельзя отнимать одинаковые римские цифры");
            }

        }

        return result;
    }
}


