package service;

import comparator.IDComparator;
import comparator.PriceComparator;
import comparator.TitleComparator;
import entity.Book;
import entity.User;
import repository.BookRepository;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    public String removeBook(String id) {
        if(!bookRepo.bookExists(id)) return "Book doesn't exists.";
       bookRepo.removeBook(bookRepo.getBookById(id));
        return "Book removed successfully.";
    }
    public String removeUser(String id) {
        if(!userRepo.userExists(id)) return "User doesn't exists.";
        userRepo.removeUser(userRepo.getUserById(id));
        return "User removed successfully.";
    }


    public String addUser(User user) {
        if (!userRepo.addUser(user)) {
            return "User ID already exists.";
        }
        return "User added successfully.";
    }

    public String editUser(String userId,String name) {
        User user = userRepo.getUserById(userId);
        if (user == null) return "User not found.";
        if (userRepo.editUser(user,name)) {
            return "User update successfully.";
        }
        return "User update failed.";
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
    public Collection<User> viewAllUsers() {
        return userRepo.getAllBooks();
    }
    public boolean isUserExist(String id){
        User user = userRepo.getUserById(id);
        return user != null;
    }
    public Collection<Book> compareBooks(String type){
        List<Book> newBooks=new ArrayList<>(bookRepo.getAllBooks());
        return switch (type) {
            case "Price" -> {
                newBooks.sort(new PriceComparator());
                yield newBooks;
            }
            case "ID" -> {
                newBooks.sort(new IDComparator());
                yield newBooks;
            }
            case "Title" -> {
                newBooks.sort(new TitleComparator());
                yield newBooks;
            }
            default -> new ArrayList<>();
        };
    }
}
