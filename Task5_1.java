// Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
// что 1 человек может иметь несколько телефонов.
// Добавить функции 1) Добавление номера 2) Вывод всего
// Пример:
// Я ввожу: 1// К: Введите фамилию // Я: Иванов
// К: Введите номер// Я: 1242353
// К: Введите 1) Добавление номера// 2) Вывод всего
// Я ввожу: 1// К: Введите фамилию// Я: Иванов// К: Введите номер// Я: 547568
// К: Введите 1) Добавление номера// 2) Вывод всего
// Я: 2// Иванов: 1242353, 547568

package HW5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task5_1 {
    public static void main(String[] args) {
        Map<String, String> phonebook = new HashMap<>();
        Scanner input = new Scanner(System.in);
        System.out.printf("\nChoose option:\n1 - add contact\n2 - display all contacts\n0 - exit\n");
        String ent = input.nextLine();
        while (!ent.equals("0")) {
            if (ent.equals("1")) {
                System.out.println("Enter name");
                String name = input.nextLine();
                System.out.println("Enter phone number");
                String phone = input.nextLine();
                if (phonebook.containsKey(name)) {
                    phonebook.put(name, phonebook.get(name) + ", " + phone);
                } else {
                    phonebook.put(name, phone);
                }
            }
            if (ent.equals("2")) {
                for (Map.Entry<String, String> el : phonebook.entrySet()) {
                    System.out.printf("%s: %s \n", el.getKey(), el.getValue());
                }
            }
            System.out.printf("\nChoose option:\n1 - add contact\n2 - display all contacts\n0 - exit\n");
            ent = input.nextLine();
        }
        input.close();
    }

}
