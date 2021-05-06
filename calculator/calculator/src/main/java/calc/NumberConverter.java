package calc;

import java.util.Map;
import java.util.TreeMap;

/**
 * Класс для конвертации и проверки чисел
 */
public class NumberConverter {

    /**
     * Переменная с Римскими цифрами
     */
    private final TreeMap<Integer, String> romanNumbers = new TreeMap<>();

    {
        romanNumbers.put(1, "I");
        romanNumbers.put(4, "IV");
        romanNumbers.put(5, "V");
        romanNumbers.put(10, "X");
        romanNumbers.put(40, "XL");
        romanNumbers.put(50, "L");
        romanNumbers.put(90, "XC");
        romanNumbers.put(100, "C");
    }

    /**
     * Метод для получения Арабской или Римской цифры
     * и ограничитель введённых данных
     */
    public int convertToNumber(String number) throws Exception {
        int result;

        try {
            result = Integer.parseInt(number);
        } catch (Exception e) {
            result = romanToArabic(number);
        }

        if (result < 1 || result > 10) {
            throw new Exception("Число должно быть от 1 до 10 включительно");
        }

        return result;
    }

    /**
     * Метод для конвертации Римской в Арабскую цифру
     */
    public int romanToArabic(String number) throws Exception {
        int result = 0;
        int count = 0;
        int i = 0;

        while (i < number.length()) {
            char symbol = number.charAt(i);
            if (String.valueOf(symbol).equals("I")) count++;
            int num = romanToArabic(symbol);

            if (num < 0) throw new Exception("Введены не верные данные");

            i++;
            if (i == number.length()) {
                result += num;
            } else {
                int secondNum = romanToArabic(number.charAt(i));
                if (secondNum > num) {
                    result += (secondNum - num);
                    i++;
                } else result += num;
            }

        }
        if (count > 3) throw new Exception("Введена не корректная цифра");
        return result;
    }

    /**
     * Метод для конвертации Римских цифр в Арабские по символьно
     */
    public int romanToArabic(char symbol) {
        int result = -1;

        for (Map.Entry<Integer, String> roman : romanNumbers.entrySet()) {
            if (roman.getValue().equals(String.valueOf(symbol))) {
                result = roman.getKey();
            }
        }
        return result;
    }

    /**
     * Метод для проверки числа, является ли оно Арабским или Римским
     */
    public int check(String number) {
        int result;
        try {
            Integer.parseInt(number);
            result = 0;
        } catch (Exception e) {
            result = 1;
        }

        return result;
    }

    /**
     * Конвертация всего числа из Арабского в Римское
     */
    public String arabicNumberToRoman(int number) {

        int i = romanNumbers.floorKey(number);

        if (number == i) {
            return romanNumbers.get(number);
        }

        return romanNumbers.get(i) + arabicNumberToRoman(number - i);
    }

}
