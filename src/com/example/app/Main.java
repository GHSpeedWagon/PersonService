package com.example.app;

import com.example.model.Person;
import com.example.service.PersonService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersonService personService = new PersonService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1 - Add person");
            System.out.println("2 - Remove person");
            System.out.println("3 - Find person by ID");
            System.out.println("4 - List all people");
            System.out.println("5 - Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    personService.addPerson(new Person(id, name, age));
                    System.out.println("Person added successfully!");
                }
                case 2 -> {
                    System.out.print("Enter ID to remove: ");
                    int id = scanner.nextInt();
                    boolean removed = personService.removePerson(id);
                    if (removed) {
                        System.out.println("Person removed successfully!");
                    } else {
                        System.out.println("Person not found.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter ID to find: ");
                    int id = scanner.nextInt();
                    personService.findPersonById(id)
                            .ifPresentOrElse(
                                    System.out::println,
                                    () -> System.out.println("Person not found.")
                            );
                }
                case 4 -> {
                    System.out.println("All people:");
                    personService.getAllPeople().forEach(System.out::println);
                }
                case 5 -> running = false;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }

        System.out.println("Goodbye!");
    }
}