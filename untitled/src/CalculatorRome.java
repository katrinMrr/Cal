public class CalculatorRome {

    static String[] romeNumbers = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    static int[] numbers = {100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] romeNumber = {"X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};

    public static boolean isRome(String value) {
        for (String s : romeNumber) {
            if (value.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static int converterToInt(String value) throws Exception {         //преобразование вводимых чисел в арабские
        return switch (value) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> throw new Exception("Числа должны быть от 1 до 10");
        };
    }

    public static String converterToRome(int total) {               //перевожу результат обратно в Римские цифры
        String totalRome = "";
        if (total <= 0) {
            totalRome = "т.к. в римской системе нет отрицательных чисел";
        } else {
            while (total > 0) {
                for (int i = 0; i < numbers.length; i++) {
                    if (total >= numbers[i]) {
                        totalRome += romeNumbers[i];
                        total -= numbers[i];
                        i--;
                    }
                }

            }

        }
        return totalRome;
    }
}


