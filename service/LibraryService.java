package service;

import model.Book;
import model.User;
import repository.BookRepository;

public class LibraryService {
    private final BookRepository bookRepo;
    private final UserService userService;

    public LibraryService(BookRepository bookRepo, UserService userService) {
        this.bookRepo = bookRepo;
        this.userService = userService;
    }

    public void addBook(Book book) {
        bookRepo.addBook(book);
    }

    public boolean issueBook(int bookId, int userId) {
        Book book = bookRepo.getBook(bookId);
        User user = userService.getUser(userId);

        if (book != null && user != null && !book.isIssued()) {
            book.setIssued(true);
            return true;
        }
        return false;
    }

    public boolean returnBook(int bookId) {
        Book book = bookRepo.getBook(bookId);
        if (book != null && book.isIssued()) {
            book.setIssued(false);
            return true;
        }
        return false;
    }

    public void displayBooks() {
        for (Book book : bookRepo.getAllBooks()) {
            System.out.println(book.getId() + ": " + book.getTitle() + " by " + book.getAuthor() +
                    (book.isIssued() ? " [Issued]" : ""));
        }
    }
}
