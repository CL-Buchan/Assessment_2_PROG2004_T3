import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/*
 * Ride Class
 */

class Ride implements RideInterface{
    String rideName;
    boolean rideStatus;
    Employee operatorID;
    int maxRider;
    int numOfCycles;
    private ArrayList<Visitor> waitingLine = new ArrayList<>();
    private LinkedList<Visitor> rideHistory = new LinkedList<>();

     // Default constructor
    public Ride() {
        rideName = "Unknown";
        rideStatus = false;
        operatorID = null;
        maxRider = 0;
        numOfCycles = 0;
    }

    // Initializer constructor
    public Ride(String rideName, boolean rideStatus, Employee operatorID) {
        this.rideName = rideName;
        this.rideStatus = rideStatus;
        this.operatorID = operatorID;
        this.maxRider = 3;
        this.numOfCycles = 0;
    }

    // Getter
    public String getRide() {
        return "Ride Name: " + rideName + ", Status: " + rideStatus + ", Operator: " + operatorID;
    }

    // Setter
    public void setRide(String rideName, boolean rideStatus, Employee operatorID, int maxRider, int numOfCycles) {
        this.rideName = rideName;
        this.rideStatus = rideStatus;
        this.operatorID = operatorID;
        this.maxRider = maxRider;
        this.numOfCycles = numOfCycles;
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingLine.add(visitor);
            System.out.println("\n" + visitor.getName() + " added to the waiting queue. (" + waitingLine.size() + ") in queue.");
        } else {
            System.out.println("\nError: No visitor is found.");
        }
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (visitor != null) {
            waitingLine.remove(visitor);
            System.out.println("\n" + visitor.getName() + " removed from the waiting queue.");
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
            System.out.println(index + ". " + visitor.getName());
        }
    }

    @Override    
    public void runOneCycle() {
        // Checks if operatorID is null
        if (operatorID == null) {
            System.out.println("Error: no operator assigned to " + rideName);
            return;
        }

        // Checks is waitingLine arrayList is empty
        if (waitingLine.isEmpty()) {
            System.out.println("\nNo visitors in queue.");
            return;
        }

        // Checks if maxRider is greater than 1
        if (maxRider < 1) {
            System.out.println("\nError: minimum amount of riders not met.");
            return;
        }

        int ridersInCycle = Math.min(maxRider, waitingLine.size()); // Gets the min number. Help from: https://www.w3schools.com/java/ref_math_min.asp

        System.out.println("\nRides is currently running:");

        // Iterates the minimum value times (in this case 3)
        for (int i = 0; i < ridersInCycle; i++) {
            Visitor visitor = waitingLine.remove(0);
            System.out.println("\n" + visitor.getName() + " is currently riding " + rideName + ".");

            visitor.setRidesTaken(visitor.getRidesTaken() + 1);
            addVisitorToHistory(visitor);
        }
        numOfCycles++; // Increments numOfCycles integer
        System.out.println("\nRide has completed. Number of cycles completed: " + numOfCycles);
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        // Checks if visitor is not in rideHistory before adding visitor
        if (!rideHistory.contains(visitor)) {
            rideHistory.add(visitor);
            System.out.println(visitor.getName() + " has been added to ride history.");
        } else {
            System.out.println("\nError: " + visitor.getName() + " is already in ride history.");
        }
    }

    @Override
    public void checkVisitorFromHistory(Visitor visitor) {
        System.out.println("\nRide history: ");
        
        if (rideHistory.contains(visitor)) {
            System.out.println(visitor.getName() + "found in ride history.");
        } else {
            System.out.println(visitor.getName() + " not found in ride history.");
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
        System.out.println("\nRide history: ");

        if (rideHistory.isEmpty()) {
            System.out.println("\nError: No visitors found in history.");
            return;
        }

        for (Visitor visitor : rideHistory) {
            System.out.println(visitor.getVisitorID() + " : " + visitor.getName() + " : " + visitor.getRidesTaken() + " rides taken.");
        }
    }

    // Sort method for visitors
    public void sortVisitors() {
        // Checks if rideHistory is empty
        if (rideHistory.isEmpty()) {
            System.out.println("\nNo visitors in history to sort.");
            return;
        }

        // Accesses Collections sort method
        Collections.sort(rideHistory, new CompareVisitors());
        
        System.out.println("\nSorted ride history by rides taken:");
        
        // Iterates through ride history using advanced for loop 
        for (Visitor v : rideHistory) {
            System.out.println("Visitor ID: " + v.getVisitorID() + " , Name: " + v.getName() + ", Rides taken: " + v.getRidesTaken());
        }
    }
}