package service;

import entity.Book;
import entity.User;
import repository.BookRepository;
import repository.UserRepository;

import java.util.*;

public class LibraryService {
    private BookRepository bookRepo;
    private UserRepository userRepo;

    public LibraryService(BookRepository bookRepo, UserRepository userRepo) {
        this.bookRepo = bookRepo;
        this.userRepo = userRepo;
    }

    public String addBook(Book book) {
        if (!bookRepo.addBook(book)) {
            return "Book ID already exists.";
        }
        return "Book added successfully.";
    }

    public String addUser(User user) {
        if (!userRepo.addUser(user)) {
            return "User ID already exists.";
        }
        return "User added successfully.";
    }

    public String issueBook(String bookId, String userId) {
        Book book = bookRepo.getBookById(bookId);
        if (book == null) return "Book not found.";

        if (!userRepo.userExists(userId)) return "User not found.";

        if (book.isIssued()) return "Book already issued.";

        book.issueTo(userId);
        return "Book issued to user " + userId;
    }

    public String returnBook(String bookId) {
        Book book = bookRepo.getBookById(bookId);
        if (book == null) return "Book not found.";
        if (!book.isIssued()) return "Book was not issued.";

        book.returnBook();
        return "Book returned successfully.";
    }

    public Collection<Book> viewAllBooks() {
        return bookRepo.getAllBooks();
    }
}
