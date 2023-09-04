package LibraryManagement;

import java.util.Scanner;

public class Main {
    public static void printMenu() {
        System.out.println("Welcome to the library management system.");
        System.out.println("1: View books");
        System.out.println("2: Add book");
        System.out.println("3: Borrow book");
        System.out.println("4: Return book");
        System.out.println("5: Add patron");
        System.out.println("6: Remove patron");
        System.out.println("7: Exit");
    }

    public static void exit() {
        System.out.println("Are you sure you want to exit? (y/n)");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if (choice.equals("y")) {
            clearScreen();
            System.exit(0);
        }
        scanner.close();
    }

    public static void clearScreen() {
        try {
            Thread.sleep(2000);  // Pause for 5000 milliseconds (5 seconds)
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
   
    public static void main(String[] args) {
        // Instantiation
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Library library = new Library();
        Librarian librarian = new Librarian(1, "John", 30);
        Patron patron = new Patron(1, "Jane", 25);
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (true) {
            printMenu();
            String choice = scanner.nextLine(); // Takes input from the user
            
            if (choice.equals("1")) {
                library.displayBooks();
                clearScreen(); 

            } else if (choice.equals("2")) {
                librarian.addBook(scanner, library.getBooks());
                clearScreen();

            } else if (choice.equals("3")) {
                // Code to borrow book
                boolean canBorrow = library.canborrow();
                if (canBorrow){
                    library.displayBooks();
                    library.displayPatrons();
                    System.out.println("Enter the ID of the patron: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    patron = library.findPatronById(id);
                    if (patron != null) {  // Checking if a patron with the ID exists
                        library.borrowBook(scanner, patron);
                    } else {
                        System.out.println("No patron found with ID: " + id);
                    }
                }
                else {
                    System.out.println("You have either no available books or no patrons, please add some.");
                }  
                clearScreen();

            } else if (choice.equals("4")) {
                // Code to return book
                if (library.getPatrons() == null){
                    System.out.println("You have no patrons, please add some.");
                }
                else {
                    library.displayPatrons();
                    library.returnBook(scanner);
                    clearScreen();
                }
                
                
            } else if (choice.equals("5")) {
                // Code to add patron
                System.out.println("Enter patron's name: ");
                String name = scanner.next();
                System.out.println("Enter patron's age: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                Patron newPatron = library.createPatron(name, age);
                if(newPatron != null){
                    library.addPatron(newPatron);
                    System.out.println("Patron added.");
                }
                clearScreen();

            } else if (choice.equals("6")) {
                // Code to remove patron
                library.displayPatrons();
                System.out.println("Enter the ID of the patron to remove: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                boolean wasRemoved = library.removePatron(id);
                if (wasRemoved) {
                    System.out.println("Patron removed successfully.");
                } else {
                    System.out.println("No patron found with ID: " + id);
                }
                clearScreen();

            } else if (choice.equals("7")) {
                // Code to exits
                exit = true;
                break;
            } else {
                System.out.println("Invalid choice: " + choice + ". Please enter a number between 1 and 7.");
                clearScreen();
            }
        }
        scanner.close();
        if (exit) {
            exit();
        }
    }  
}