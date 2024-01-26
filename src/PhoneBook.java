import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        // Добавление контактов в телефонную книгу
        addContact(phoneBook, "Лялина", "908-693-57-85");
        addContact(phoneBook, "Симоненко", "927-695-57-85");
        addContact(phoneBook, "Симоненко", "555-555-555");
        addContact(phoneBook, "Миронов", "927-879-77-85");
        addContact(phoneBook, "Козлов", "927-654-85-85");
        addContact(phoneBook, "Козлов", "999-458-55-85");
        addContact(phoneBook, "Миронов", "927-444-65-85");
        // Вывод телефонной книги
        printPhoneBook(phoneBook);
    }

    public static void addContact(HashMap<String, List<String>> phoneBook, String name, String phone) {
        List<String> phones = phoneBook.getOrDefault(name, new ArrayList<>());
        phones.add(phone);
        phoneBook.put(name, phones);
    }

    public static void printPhoneBook(HashMap<String, List<String>> phoneBook) {
        // Преобразование HashMap в отсортированный список
        List<Map.Entry<String, List<String>>> sortedList = new ArrayList<>(phoneBook.entrySet());
        sortedList.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));

        // Вывод телефонной книги
        for (Map.Entry<String, List<String>> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}