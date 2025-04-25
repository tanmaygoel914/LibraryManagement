package repository;

import entity.Book;
import java.util.*;

public class BookRepository {
    private Map<String, Book> books = new HashMap<>();

    public BookRepository() {
        addBook(new Book("1", "Java",100));
        addBook(new Book("2", "CPP",99));
        addBook(new Book("3", "Flutter",101));
        addBook(new Book("4", "HTML",105));
        addBook(new Book("5", "CSS",80));
        addBook(new Book("6", "JavaScript",10));
        addBook(new Book("7", "Ruby",5));
        addBook(new Book("8", "Perl",3));
    }

    public boolean addBook(Book book) {
        if (books.containsKey(book.getId())) return false;
        books.put(book.getId(), book);
        return true;
    }

    public boolean removeBook(Book book)  {
        if (!books.containsKey(book.getId())) return false;
        books.remove(book.getId(), book);
        return true;
    }
    public boolean bookExists(String id) {
        return books.containsKey(id);
    }

    public Book getBookById(String id) {
        return books.get(id);
    }

    public Collection<Book> getAllBooks() {
        return books.values();
    }
}
