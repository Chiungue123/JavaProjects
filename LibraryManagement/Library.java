package LibraryManagement;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Library {
    // Attributes
    private List<Book> books;
    private List<Patron> patrons;

    // Constructor
    Library() {
        this.books = new ArrayList<Book>();
        this.patrons = new ArrayList<Patron>();
    }

    // Methods
    public Patron createPatron(String name, int age) {
        // Check for duplicates, increment the ID and create a new Patron
        int id = patrons.size() + 1;
        for (Patron patron : patrons) {
            if (patron.getName().equals(name)) {
                System.out.println("Patron already exists!");
                return null;
            }
        }
        return new Patron(id, name, age);
    }

    public boolean removePatron(int id) {
        Patron patron = findPatronById(id);
        if (patron != null) {
            return patrons.remove(patron); // remove() method returns true if the element was in the list and was removed successfully
        } else {
            return false;
        }
    }
    

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }
    
    public void removePatron(Patron patron) {
        patrons.remove(patron);
    }
    
    
    // Getters
    public void displayBooks() {
        if (this.books.size() != 0) {
            for (Book book : this.books) {
                System.out.println(book.getName() + " by " + book.getAuthor());
            }
        }
        else {
            System.out.println("No books in the library.");
        }
    }

    public void displayPatrons(){
        if (this.patrons.size() != 0) {
            for (Patron patron : this.patrons) {
                System.out.println(patron.getName() + " with ID " + patron.getId());
            }
        }
        else{
            System.out.println("No patrons in the library.");
        }
    }

    public Book findBookByName(String bookName) {
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(bookName) && book.getIsAvailable()) {
                return book;
            }
        }
        return null; // Return null if no matching book is found
    }
    
    public Patron findPatronById(int id) {
        for (Patron patron : patrons) {
            if (patron.getId() == id) {
                return patron;
            }
        }
        return null; // Return null if no matching patron is found
    }

    // Setters
    public void borrowBook(Patron patron){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the book: ");
        String name = scanner.nextLine();
        System.out.println("Enter the author of the book: ");
        String author = scanner.nextLine();

        for (Book book : books) {
            if (book.getName().equals(name) && book.getAuthor().equals(author) && book.getIsAvailable()) {
                patron.getBorrowedBooks().add(book);
                book.setIsAvailable(false);
                System.out.println("Book borrowed.");
                break;
            }
            System.out.println("Borrowed Books: ");
            for (Book borrowed: patron.getBorrowedBooks()){
                System.out.println(borrowed.getName() + " by " + borrowed.getAuthor());
            }
        } 
        scanner.close(); 
    }

    public void returnBook(Library library) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the book to return: ");
        String name = scanner.nextLine();
        Book book = library.findBookByName(name);
        if (book != null && !book.getIsAvailable()) {
            book.setIsAvailable(true);
        } else {
            System.out.println("No book found with name: " + name + " or the book is already available.");
        }
        scanner.close();
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setPatrons(List<Patron> patrons) {
        this.patrons = patrons;
    }
}