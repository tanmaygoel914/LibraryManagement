package ui;

import controller.LibraryController;

import java.util.Scanner;

public class MainUI {
    private final LibraryController controller;

    public MainUI(LibraryController controller) {
        this.controller = controller;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show Books");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    controller.addBook(id, title, author);
                }
                case 2 -> {
                    System.out.print("User ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    controller.addUser(id, name);
                }
                case 3 -> {
                    System.out.print("Book ID: ");
                    int bookId = scanner.nextInt();
                    System.out.print("User ID: ");
                    int userId = scanner.nextInt();
                    if (controller.issueBook(bookId, userId))
                        System.out.println("Book issued successfully.");
                    else
                        System.out.println("Issue failed.");
                }
                case 4 -> {
                    System.out.print("Book ID: ");
                    int bookId = scanner.nextInt();
                    if (controller.returnBook(bookId))
                        System.out.println("Book returned.");
                    else
                        System.out.println("Return failed.");
                }
                case 5 -> controller.showBooks();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option.");
            }
        } while (choice != 0);
    }
}
