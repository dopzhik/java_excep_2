package Exception_HW2;

// Задание 1. Проверка корректности даты
// Напишите метод, который проверяет, является ли введенная строка корректной
// датой в формате "YYYY-MM-DD". Дата должна быть в пределах от 0001-01-01
// до 9999-12-31. Если дата корректна, возвращайте её. Если нет — сообщение
// об ошибке.


class DateValidator {
    public static String validateDate(String date) {
        try {
            if (date.length() != 10) {
                throw new RuntimeException("Длина строки: '" + date + "' не равна 10");
            }
            String r1 = date.substring(4,5);
            String r2 = date.substring(7,8);
            // System.out.println(r1 + r2);
            if (!r1.equals("-") || !r2.equals("-")) {
                throw new RuntimeException("Разделитель строки: '"  + date + "' не равен '-'");
            }
    
            int year = Integer.parseInt(date.substring(0,4));
            int month = Integer.parseInt(date.substring(5,7));
            int day = Integer.parseInt(date.substring(8,10));
            System.out.println(day + "-" + month + "-" + year);
    
            if (year < 1 || year > 9999) {
                throw new RuntimeException("год: " + year + " вне диапозона 0001-9999");
            }
    
            if (month < 1 || month > 12) {
                throw new RuntimeException("месяц: '" + month + "' вне диапозона 01-12");
            }
    
            int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 12}; 
    
            if (month == 2 && isLeapYear(year)) {
                months[1] = 29;
            }
    
            if (day < 1 || day > months[month-1]) {
                throw new RuntimeException("день месяца: '" + day + "' вне диапозона 01-"+ months[month-1]);
            }
    
            return date;
        }
        
        catch (NumberFormatException e) {
            return "Ошибка при преобразования числа: " + e.getMessage();
        }
        catch (Exception e) {
            return "Ошибка: " + e.getMessage();
        }
        
    }

    // Метод для проверки високосного года
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}

public class Task1 {
    public static void main(String[] args) {
        String date;
        if (args.length > 0) {
            date = args[0];
        } else {
            date = "2020-02-40"; // Значение по умолчанию
        }
        String result = DateValidator.validateDate(date);
        System.out.println(result);
    }
}
