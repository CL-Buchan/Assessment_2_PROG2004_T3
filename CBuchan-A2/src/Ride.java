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
    private ArrayList<Visitor> waitingLine = new ArrayList<>();
    private LinkedList<Visitor> rideHistory = new LinkedList<>();

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
            System.out.println("\n" + visitor.getName() + " added to the waiting queue.");
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
        int rides = 0;

        if (rides > 1) {
            System.out.println("\nNumber of rides exceeded.");
        } else {
            while (rides <= 0) {
                if (waitingLine.size() > 0) {
                    Visitor firstVisitor = waitingLine.get(0);
                    System.out.println("\nRides running.");
                    System.out.println(firstVisitor.getName() + " is currently riding " + rideName + ".");
                    firstVisitor.setRidesTaken(firstVisitor.getRidesTaken() + 1);
                    addVisitorToHistory(firstVisitor);
                    removeVisitorFromQueue(firstVisitor);
                    rides++;
                } else {
                    System.out.println("\nError: no visitors in queue.");
                    break;
                }
            }
            System.out.println("\nRide has completed.");
            System.out.println("Number of ride cycles completed: " + rides);
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        // Checks if visitor is not in rideHistory before adding visitor
        if (!rideHistory.contains(visitor)) {
            rideHistory.add(visitor);
            System.out.println(visitor.getName() + " added to ride history.");
        } else {
            System.out.println("\nVisitor is already in ride history.");
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

        for (Visitor visitor : rideHistory) {
            if (rideName != null && !rideName.equals("null")) {
                System.out.println("\nNo visitors found in history.");
            } else {
                System.out.println(visitor.getVisitorID() + " : " + visitor.getName() + " : " + visitor.getRidesTaken() + " rides taken.");
            }
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