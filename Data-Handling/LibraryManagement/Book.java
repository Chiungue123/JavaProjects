package LibraryManagement;

public class Book {
    // Attributes
    private String name;
    private String author;
    private Boolean isAvailable;

    // Parameterized Constructor
    Book (String name, String author) {
        this.name = name;
        this.author = author;
        this.isAvailable = true;
    }

    // Getters
    public boolean getIsAvailable() {
        return this.isAvailable;
    }
    
    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    // Setters
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author; 
    }
}