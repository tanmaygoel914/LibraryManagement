package controller;

import entity.Book;
import entity.User;
import service.LibraryService;
import service.UserService;

public class LibraryController {
    private final LibraryService libraryService;
    private final UserService userService;

    public LibraryController(LibraryService libraryService, UserService userService) {
        this.libraryService = libraryService;
        this.userService = userService;
    }

    public void addBook(int id, String title, String author) {
        libraryService.addBook(new Book(id, title, author));
    }

    public void addUser(int id, String name) {
        userService.addUser(new User(id, name));
    }

    public boolean issueBook(int bookId, int userId) {
        return libraryService.issueBook(bookId, userId);
    }

    public boolean returnBook(int bookId) {
        return libraryService.returnBook(bookId);
    }

    public void showBooks() {
        libraryService.displayBooks();
    }
}