package LibraryManagement;

import java.util.ArrayList;
import java.util.List;
import LibraryManagement.Book; 

public class Librarian extends Person{
    // Attributes
    private List<Book> books;

    Librarian(int id, String name, int age) {
        super(id, name, age); // Calling the constructor of the parent class
        this.books = new ArrayList<Book>(); // Initializing the books list
    }

    public void addBook(Book b) {
        books.add(b);
    }

    public void removeBook(Book b) {
        books.remove(b);
    }
}