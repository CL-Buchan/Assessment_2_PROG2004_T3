/*
 * Person Class
 */

public abstract class Person {
    protected String name;
    protected String email;
    protected double height;
    
    // Default constructor
    public Person() {
        name = "Unknown";
        email = "Unknown";
        height = 0;
    }

    // Initializer constructor
    public Person(String name, String email, double height) {
        this.name = name;
        this.email = email;
        this.height = height;
    }

    // Getter
    public String getPerson() {
        return "Name: " + name + ", Email: " + email + ", Height:" + height;
    }

    // Setter
    public void setPerson(String name, String email, double height) {
        this.name = name;
        this.email = email;
        this.height = height;
    }
}