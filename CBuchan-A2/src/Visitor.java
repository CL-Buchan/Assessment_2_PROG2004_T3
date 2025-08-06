/*
 * Visitor Class
 */

class Visitor extends Person {
    private int visitorID;
    public int ridesTaken;

    // Default constructor
    public Visitor() {
        super();
    }

    // Initializer constructor
    public Visitor(String name, String email, double height, int visitorID) {
        super(name, email, height);
        this.visitorID = visitorID;
    }

    // Getter
    public String getName() {
        return name;
    }

    // Getter
    public int getVisitorID() {
        return visitorID;
    }

    // Getter
    public int getRidesTaken() {
        return ridesTaken;
    }

    // Setter
    public void setRidesTaken(int ridesTaken) {
        this.ridesTaken = ridesTaken;
    }

    // Sets variables to CSV formatted string
    public String toCSV() {
        return name + "," + email + "," + height + "," + visitorID;
    }

    // Overridden toString
    @Override
    public String toString() {
        return "Name: " + name + ", Visitor ID: " + visitorID + ", Rides taken: " + ridesTaken;
    }
}