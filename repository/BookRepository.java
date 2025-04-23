package repository;

import entity.Book;
import java.util.*;

public class BookRepository {
    private Map<String, Book> books = new HashMap<>();

    public BookRepository() {
        addBook(new Book("1", "Java"));
        addBook(new Book("2", "CPP"));
        addBook(new Book("3", "Flutter"));
        addBook(new Book("4", "HTML"));
        addBook(new Book("5", "CSS"));
        addBook(new Book("6", "JavaScript"));
        addBook(new Book("7", "Ruby"));
        addBook(new Book("8", "Perl"));
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
