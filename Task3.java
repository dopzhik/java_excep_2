package Exception_HW2;

// Задача 3. Сортировка массива строк

// Напишите метод, который принимает массив строк и сортирует его в
// алфавитном порядке. Если входной массив null, метод должен вернуть пустой
// массив и вывести сообщение об ошибке.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class StringSorter {
    public static String[] sortStrings(String[] strings) {
        try {
            String temp;
            ArrayList<String> list = new ArrayList<>();
            Collections.addAll(list, strings);

            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = i; j < list.size() - 1; j++) {
                    if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                        temp = list.get(j);
                        list.set(j, list.get(j + 1));
                        list.set(j + 1, temp);
                    }
                }

            }
            
            return list.stream().toArray(String[]::new );
        } catch (NullPointerException e) {
            System.out.println("Введено пустое значение: " + e.getMessage());
            // return " ";
        }
        return strings;
    }
}

public class Task3 {
    public static void main(String[] args) {
        String[] strings;
        if (args.length > 0) {
            strings = args[0].split(",");
        } else {
            strings = new String[] { "banana", "apple", "cherry" }; // Значение по умолчанию
        }
        String[] result = StringSorter.sortStrings(strings);
        System.out.println(Arrays.toString(result));
    }
}