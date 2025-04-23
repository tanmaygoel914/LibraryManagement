package controller;

import entity.Book;
import entity.User;
import service.LibraryService;
import service.UserService;

import java.util.*;

public class LibraryController {
    private LibraryService libraryService;
    private UserService userService;

    public LibraryController(LibraryService libraryService, UserService userService) {
        this.libraryService = libraryService;
        this.userService = userService;
    }

    public void librarianMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Librarian Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show All Books");
            System.out.println("6. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String bookId = sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.println(libraryService.addBook(new Book(bookId, title)));
                    break;
                case 2:
                    System.out.print("Enter User ID: ");
                    String userId = sc.nextLine();
                    System.out.print("Enter User Name: ");
                    String userName = sc.nextLine();
                    System.out.println(libraryService.addUser(new User(userId, userName)));
                    break;
                case 3:
                    System.out.print("Enter Book ID: ");
                    String issueBookId = sc.nextLine();
                    System.out.print("Enter User ID: ");
                    String issueUserId = sc.nextLine();
                    System.out.println(libraryService.issueBook(issueBookId, issueUserId));
                    break;
                case 4:
                    System.out.print("Enter Book ID: ");
                    String returnBookId = sc.nextLine();
                    System.out.println(libraryService.returnBook(returnBookId));
                    break;
                case 5:
                    printList( userService.viewAllBooks());
                    break;
                default:
                    return;
            }
        }
    }

    public void userMenu(String userId) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- User Menu ---");
            System.out.println("1. View My Issued Books");
            System.out.println("2. View All Books");
            System.out.println("3. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    printList(userService.getIssuedBooks(userId));
                    break;
                case 2:
                    printList( userService.viewAllBooks());
                    break;
                default:
                    return;
            }
        }
    }

    public static void printList(Collection<Book> items) {
        for (Book item : items) {
            System.out.println(item);
        }
    }

    public static void printList(List<Book> items) {
        for (Book item : items) {
            System.out.println(item);
        }
    }


}

