package LibraryManagement;

import java.util.List; 
import java.util.Scanner;

public class Librarian extends Person{

    Librarian(int id, String name, int age) {
        super(id, name, age); // Calling the constructor of the parent class
    }

    public void addBook(Scanner scanner, List<Book> books) {
        boolean exists = false;
        System.out.println("Enter the name of the book: ");
        String name = scanner.nextLine();
        System.out.println("Enter the author of the book: ");
        String author = scanner.nextLine();
        if (name.length() != 0 && author.length() != 0) {
            for (Book book : books) {
                if (book.getName().equals(name) && book.getAuthor().equals(author)) {
                    System.out.println("Book already exists.");
                    exists = true;
                }
            }
            if (!exists){
                Book book = new Book(name, author);
                books.add(book);
                System.out.println("Book added.");
            }
        } else {
            System.out.println("Invalid input.");
        }
    }

    public void removeBook(Scanner scanner, List<Book> books) {
        System.out.println("Enter the name of the book: ");
        String name = scanner.nextLine();
        System.out.println("Enter the author of the book: ");
        String author = scanner.nextLine();
        if (name.length() != 0 && author.length() != 0) {
            for (Book book : books) {
                if (book.getName().equals(name) && book.getAuthor().equals(author)) {
                    books.remove(book);
                    System.out.println("Book removed.");
                    break;
                }
            }
        } else {
            System.out.println("Invalid input.");
        }
        scanner.close();
    }
}