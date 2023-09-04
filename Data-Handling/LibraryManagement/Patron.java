package LibraryManagement;

import java.util.ArrayList;
import java.util.List;

public class Patron extends Person {
    // Attributes
    private List<Book> borrowedBooks;

    // Parameterized Constructor
    Patron(int id, String name, int age) {
        super(id, name, age); // Calling the constructor of the parent class
        this.borrowedBooks = new ArrayList<Book>(); // Initializing the books list
    }

    // Getters
    public List<Book> getBorrowedBooks() {
        return this.borrowedBooks;
    }

    public void displayBorrowedBooks() {
        if (this.borrowedBooks.size() > 0) {
            System.out.printf("Books borrowed by %s:\n", getName());
            for (Book book : this.borrowedBooks) {
                System.out.printf("Book: %-20s | Author: %s\n", book.getName(), book.getAuthor());
            }
        }
        else {
            System.out.println("Borrowed Books: None.");
        }
    }
}