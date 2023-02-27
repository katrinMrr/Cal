import java.util.Scanner;
import java.lang.Exception;

public class Calculator {
   static boolean isRome;
    public static void main(String[] args) throws Exception {
        System.out.println("введите пример");
        Scanner scanner = new Scanner(System.in);
        String primer = scanner.nextLine();   //вызываю метод Записи с клавы
        int total = getTotal(primer);
        if (isRome) {
            System.out.println(CalculatorRome.converterToRome(total));
        } else {
            System.out.println(total);
        }
    }

    public static int getTotal(String primer) throws Exception {
        int num1,num2,total;
        String oper;
        String[] strings = primer.split("[+\\-*/]");       // разделяем методом split на массив стринг
        if (strings.length > 2) throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        if (strings.length < 2) throw new Exception("строка не является математической операцией");
        String operation = detectOperation(primer);
        if (operation == null) throw new Exception("Операция не поддерживается");
        if (CalculatorRome.isRome(strings[0]) && CalculatorRome.isRome(strings[1])) {
            num1 = CalculatorRome.converterToInt(strings[0]);
            num2 = CalculatorRome.converterToInt(strings[1]);
            isRome = true;
        } else if (!CalculatorRome.isRome(strings[0]) && !CalculatorRome.isRome(strings[1])) {
            num1 = Integer.parseInt(strings[0]);
            num2 = Integer.parseInt(strings[1]);
            isRome = false;
        } else {
            throw new Exception("используются одновременно разные системы счисления");
        }
        if (num1 > 10 || num2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        switch (detectOperation(primer)) {
            case "+":
                total = num1 + num2;
                break;
            case "-":
                total = num1 - num2;
                break;
            case "*":
                total = num1 * num2;
                break;
            default:
                total = num1 / num2;
                break;
        }
        return total;
    }

    public static String detectOperation(String oper) {
        if (oper.contains("+")) return "+";
        else if (oper.contains("-")) return "-";
        else if (oper.contains("*")) return "*";
        else if (oper.contains("/")) return "/";
        else return null;
    }
}