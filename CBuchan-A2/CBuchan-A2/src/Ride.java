import java.util.ArrayList;

/*
 * Ride Class
 */

class Ride implements RideInterface{
    String rideName;
    boolean rideStatus;
    Employee operatorID;
    private ArrayList<Visitor> waitingLine = new ArrayList<>();
    private ArrayList<Visitor> rideHistory = new ArrayList<>();

     // Default constructor
    public Ride() {
        rideName = "Unknown";
        rideStatus = false;
        operatorID = null;
    }

    // Initializer constructor
    public Ride(String rideName, boolean rideStatus, Employee operatorID) {
        this.rideName = rideName;
        this.rideStatus = rideStatus;
        this.operatorID = operatorID;
    }

    // Getter
    public String getRide() {
        return "Ride Name: " + rideName + ", Status: " + rideStatus + ", Operator: " + operatorID;
    }

    // Setter
    public void setRide(String rideName, boolean rideStatus, Employee operatorID) {
        this.rideName = rideName;
        this.rideStatus = rideStatus;
        this.operatorID = operatorID;
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingLine.add(visitor);
            System.out.println(visitor.name + " added to the waiting queue.");
        } else {
            System.out.println("Error: No visitor is found.");
        }
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (visitor != null) {
            waitingLine.remove(visitor);
            System.out.println("\n" + visitor.name + " removed from the waiting queue.");
        } else {
            System.out.println("Error: No visitor is found.");
        }
    }

    @Override
    public void printQueue() {
        int index = 0;
        System.out.println("\nVisitors waiting (" + waitingLine.size() + "):");

        for (Visitor visitor : waitingLine) {
            index += 1;
            System.out.println(index + ". " + visitor.name);
        }
    }

    @Override    
    public void runOneCycle() {
        int rides = 0;

        if (rides > 1) {
            System.out.println("\nNumber of rides exceeded.");
        } else {
            while (rides <= 0) {
                if (waitingLine.size() > 0) {
                    Visitor firstVisitor = waitingLine.get(0);
                    System.out.println("\nRides running.");
                    System.out.println(firstVisitor.name + " is currently riding " + rideName + ".");
                    addVisitorToHistory(firstVisitor);
                    rides++;
                } else {
                    System.out.println("\nError: no visitors in queue.");
                }
            }
            System.out.println("\nRide has completed.");
            System.out.println("Number of ride cycles completed: " + rides);
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println(visitor.name + " added to ride history.");
    }

    @Override
    public void checkVisitorFromHistory(Visitor visitor) {
        System.out.println("\nRide history: ");
        
        if (rideHistory.contains(visitor)) {
            System.out.println(visitor.name + "found in ride history.");
        } else {
            System.out.println(visitor.name + " not found in ride history.");
        }
    }

    @Override
    public void numberOfVisitors() {
        int visitors = rideHistory.size();

        if (visitors != 0) {
            System.out.println("\nNumber of park visitors: " + visitors);
        }
        else {
            System.out.println("\nError: no visitors found.");
        }
    }

    @Override
    public void printRideHistory() {
        for (Visitor visitor : rideHistory) {
            System.out.println("\n" + visitor.name + " took a ride on " + rideName + ".");
        }
    }
}