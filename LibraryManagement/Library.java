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
    public boolean canborrow() {
        //canBorrow = false;
        if (this.patrons.size() > 0 && this.books.size() > 0) {
            for (Book book : this.books) {
                if (book.getIsAvailable()) {
                    return true;
                }
            }
        } else {
            return false;
        }
        return false;
    }

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
    public List<Book> getBooks() {
        return this.books;
    }

    public List<Patron> getPatrons() {
        return this.patrons;
    }

    public void displayBooks() {
        if (books.size() > 0){
            System.out.println("List of books:");
            for (Book book : this.books) {
                System.out.printf("%-20s | %-20s | status: %s\n", book.getName(), book.getAuthor(), book.getIsAvailable() ? "Available" : "Borrowed");
            }
            System.out.println("====================================================================================================");
        }
        else{
            System.out.println("No books found.");
        }
    }

    public void displayPatrons(){
        if (patrons.size() > 0){
            System.out.println("List of patrons:");
            for (Patron patron : this.patrons) {
                System.out.printf("Name: %-9s | ID: %-5s | Age: %s\n", patron.getName(), patron.getId(), patron.getAge());
                patron.displayBorrowedBooks();
                System.out.println();
            }
            System.out.println("====================================================================================================");
        }
        else {
            System.out.println("No patrons found.");
        }
    }

    public Book findBookByName(String bookName) {
        for (Book book : books) {
            if (book.getName().equals(bookName)) {
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
    public void borrowBook(Scanner scanner, Patron patron){
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
        }
    }

    public void returnBook(Scanner scanner) {
        // Get the name of the book and the id of the patron
        System.out.println("Enter the name of the book to return: ");
        String name = scanner.nextLine();
        System.out.println("Enter the id of the patron: ");
        int patronId = scanner.nextInt();
        scanner.nextLine();

        // Find the book and the patron
        Book book = findBookByName(name);
        Patron patron = findPatronById(patronId);

        // If the book is found and is not available and the patron is found, return the book
        if (book != null && !book.getIsAvailable() && patron != null) {
            book.setIsAvailable(true);
            patron.getBorrowedBooks().remove(book);
            System.out.println("Book returned.");
        } else {
            System.out.println("No borrowed book found with name: " + name + " or no patron found with id: " + patronId);
        }
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setPatrons(List<Patron> patrons) {
        this.patrons = patrons;
    }
}