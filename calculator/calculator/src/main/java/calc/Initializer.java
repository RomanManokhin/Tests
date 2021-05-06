package calc;

import java.util.Scanner;

/**
 * Класс для инициализации программы
 */
public class Initializer {

    static Scanner sc = new Scanner(System.in);

    /**
     * Метод для получения данных от пользователя
     * */
    public static String[] parserString() throws Exception {
        System.out.println("Введите данные для расчета");

        String userInput = sc.nextLine();

        String[] valuesOfUserInput = userInput.split(" ");

        if (valuesOfUserInput.length != 3) throw new Exception("Не корректный ввод");

        return valuesOfUserInput;

    }

    /**
     * Метод для инициализации калькулятора
     * */
    static String initCalc() throws Exception {
        Calculator calculator = new Calculator();
        NumberConverter nc = new NumberConverter();

        String[] array = parserString();

        return calculator.calculate(array[0], array[1], array[2], nc.check(array[0]));
    }

}
