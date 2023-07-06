package LibraryManagement;

public class Person {
    // Attributes
    private int id;
    private String name;
    private int age;

    // Parameterized Constructor
    Person (int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return age;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name; 
    }

    public void setAge(int age) {
        this.age = age;
    }
}