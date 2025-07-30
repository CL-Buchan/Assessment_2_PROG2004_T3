/*
 * Visitor Class
 */

class Visitor extends Person {
    private int visitorID;

    // Default constructor
    public Visitor() {
        super();
        visitorID = 0;
    }

    // Initializer constructor
    public Visitor(String name, String email, double height, int visitorID) {
        super(name, email, height);
        this.visitorID = visitorID;
    }

    // Getter
    public String getVisitor() {
        return "Name: " + name + ", Visitor ID: " + visitorID;
    }

    // Setter
    public void setVisitor(int visitorID) {
        setPerson(name, email, height);
        this.visitorID = visitorID;
    }
}