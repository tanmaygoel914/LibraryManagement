package repository;

import entity.Book;
import java.util.*;

public class BookRepository {
    private final Map<Integer, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public Book getBook(int id) {
        return books.get(id);
    }

    public Collection<Book> getAllBooks() {
        return books.values();
    }

    public void removeBook(int id) {
        books.remove(id);
    }
}
