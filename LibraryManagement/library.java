package LibraryManagement;

import java.util.List;
import LibraryManagement.Book;

public class Library {
    // Attributes
    private List<Book> books;

    // Parameterized Constructor
    Library (List<Book> books) {
        this.books = books;
    }

    // Getters
    public List<Book> getBooks() {
        return this.books;
    }

    // Setters
    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
