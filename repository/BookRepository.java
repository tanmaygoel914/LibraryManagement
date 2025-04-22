package repository;

import entity.Book;
import java.util.*;

public class BookRepository {
    private Map<String, Book> books = new HashMap<>();

    public BookRepository() {
        addBook(new Book("1", "Java"));
        addBook(new Book("2", "CPP"));
        addBook(new Book("3", "Flutter"));
    }

    public boolean addBook(Book book) {
        if (books.containsKey(book.getId())) return false;
        books.put(book.getId(), book);
        return true;
    }

    public Book getBookById(String id) {
        return books.get(id);
    }

    public Collection<Book> getAllBooks() {
        return books.values();
    }
}
