package LibraryManagement;

public class Patron extends Person {
    // Parameterized Constructor
    Patron(int id, String name, int age) {
        super(id, name, age); // Calling the constructor of the parent class
    }

    // Methods
    public void borrowBook(Book b) {
        if (b.getIsAvailable()) {
            b.setIsAvailable(false);
        } else {
            System.out.println("Book is not available.");
        }
    }

    public void returnBook(Book b) {
        if (!b.getIsAvailable()) {
            b.setIsAvailable(true);
        } else {
            System.out.println("Book is already available.");
        }
    }
}
