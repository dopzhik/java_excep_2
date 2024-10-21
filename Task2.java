package Exception_HW2;

// Задача 2. Проверка строки на палиндром
// Напишите метод, который проверяет, является ли введенная строка
// палиндромом. Если строка палиндром, возвращайте "Palindrome". Если нет
// — "Not a palindrome".

class PalindromeChecker {
    public static boolean isPalindrome(String input) {
        try {
            boolean ans = true;
            String str = input.replace(" ", "").toLowerCase();
            for (int i = 0; i < str.length() / 2; i++) {
                if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                    ans = false;
            }
            return ans;
            
        } catch (Exception e) {
            System.out.println("Введены не корректные данные");
            return false;
        }
    }
}

public class Task2 {
    public static void main(String[] args) {
        String input;
        if (args.length > 0) {
            input = args[0];
        } else {
            input = "123rerw"; // Значение по умолчанию
        }
        boolean result = PalindromeChecker.isPalindrome(input);
        System.out.println("Is the input a palindrome? " +
                result);
    }
}
