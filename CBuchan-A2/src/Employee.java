/*
 * Employee Class
 */

class Employee extends Person {
    private int ID;

    // Default constructor
    public Employee() {
        super();
        ID = 0;
    }

    // Initializer constructor
    public Employee(String name, String email, double height, int ID) {
        super(name, email, height);
        this.ID = ID;
    }

    // Getter
    public String getEmployee() {
        return "Name: " + name + ", Employee ID: " + ID;
    }

    // Setter
    public void setEmployee(int ID) {
        setPerson(name, email, height);
        this.ID = ID;
    }
}