package org.example;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PhoneBook {
    private static Map<String, Set<String>> contacts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            System.out.println("Введите команду: ");
            String input = scanner.nextLine();
            String[] command = input.split(" ");

            if (command[0].equalsIgnoreCase("ADD")) {
                add(command[1], command[2]);
            } else if (command[0].equalsIgnoreCase("GET")) {
                findByNumber(command[1]);
            } else if (command[0].equalsIgnoreCase("REMOVE")) {
                removeContact(command[1]);
            } else if (command[0].equalsIgnoreCase("LIST")) {
                printAllNames();
            } else if (command[0].equalsIgnoreCase("EXIT")) {
                break;
            } else {
                System.out.println("Некорректная команда");
            }
        }
        scanner.close();
    }
    public static void add(String surname, String phoneNumber) {
        if (contacts.containsKey(surname)) {
            Set<String> numbers = contacts.get(surname);
            numbers.add(phoneNumber);
        } else {
            Set<String> numbers = new HashSet<>();
            numbers.add(phoneNumber);
            contacts.put(surname, numbers);
        }

        System.out.println("Запись добавлена");
    }
    public static void findByNumber(String surname) {
        if (contacts.containsKey(surname)) {
            Set<String> numbers = contacts.get(surname);
            System.out.println("Номера телефонов для фамилии " + surname + ":");
            for (String number : numbers) {
                System.out.println(number);
            }
        } else {
            System.out.println("Фамилии " + surname + " не найдено");
        }
    }
    public static void removeContact(String surname) {
        if (contacts.containsKey(surname)) {
            contacts.remove(surname);
            System.out.println("Записи для фамилии " + surname + " удалены");
        } else {
            System.out.println("Фамилии " + surname + " не найдено");
        }
    }
    public static void printAllNames() {
        if (contacts.isEmpty()) {
            System.out.println("Справочник пуст");
        } else {
            System.out.println("Записи в справочнике:");
            for (Map.Entry<String, Set<String>> entry : contacts.entrySet()) {
                String surname = entry.getKey();
                Set<String> numbers = entry.getValue();

                System.out.println("Фамилия: " + surname);
                System.out.println("Номера телефонов:");
                for (String number : numbers) {
                    System.out.println(number);
                }
                System.out.println();
            }
        }
    }
    public static void printMenu(){
        System.out.println("Выберите действие:\n" +
                "ADD - Добавить контакт;\n" +
                "GET - Найти контакт;\n" +
                "REMOVE - Удалить контакт;\n" +
                "LIST - Показать список контактов;\n" +
                "EXIT - Выход.");
    }
}