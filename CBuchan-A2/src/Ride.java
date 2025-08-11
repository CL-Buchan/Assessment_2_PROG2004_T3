/*
 * Ride Class
 */

// Imported java packages
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.locks.*;

class Ride implements RideInterface {
    String rideName;
    boolean rideStatus;
    double rideHeight;
    Employee operatorID;
    int maxRider = 3;
    int numOfCycles;
    private final ArrayList<Visitor> waitingLine = new ArrayList<>();
    private static final LinkedList<Visitor> rideHistory = new LinkedList<>();

    // Lock instance for locking during thread
    private final Lock lock = new ReentrantLock();

     // Default constructor
    public Ride() {
        rideName = "Unknown";
        rideStatus = false;
        rideHeight = 0;
        operatorID = null;
        maxRider = 0;
        numOfCycles = 0;
    }

    // Constructor
    public Ride(String rideName, double rideHeight) {
        this.rideName = rideName;
        this.rideHeight = rideHeight;
    }

    // Getter
    public String getRide() {
        return "Ride Name: " + rideName;
    }

    // Getter
    public String getRideStatus() {
        return "Ride open: " + rideStatus;
    }

    // Getter
    public String getRideHeight() {
        return "Ride height for " + rideName + " is " + rideHeight;
    }

    // Getter
    public String getOperator() {
        return "Operator ID: " + operatorID;
    }

    // Getter
    public String getMaxRider() {
        return "Max number of riders: " + maxRider;
    }

    // Getter
    public String getNumOfCycles() {
        return "Number of ride cycles: " + numOfCycles;
    }

    // Setter
    public void setEmployee(Employee employeeID) {
        this.operatorID = employeeID;
    }

    // Setter
    public void setRideStatus(Employee operator) {
        // Calls lock for thread-safe access to rideStatus change
        lock.lock();
        try {
            // Checks if the operator ID equals the operator ID given
            if (this.operatorID.equals(operator)) {
                this.rideStatus = true;
                return;
            }

            this.rideStatus = false;
            System.out.println(rideName + " is closed.");
        } catch (Exception e) {
            System.out.println("Error: error occured -> " + e.getMessage());
        } finally {
            lock.unlock(); // Unlocks lock
        }
    }

    // Checks if ride is open
    public void checkRideHeight() {
        if (rideHeight != 0) {
            System.out.println("Ride height for " + rideName + " is " + rideHeight + " meters.");
            System.out.println(rideName + " is open.");
            return;
        }
        
        this.rideStatus = false;
        System.out.println(rideName + " is closed.");
    }

    // Overrides method from RideInterface
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        // Locks for thread-safe for add method accessing waitingLine 
        lock.lock();
        try {
            if (visitor != null) {
                waitingLine.add(visitor);
                System.out.println("\n" + visitor.getName() + " has been added to the waiting queue. (" + waitingLine.size() + ") in queue.");
            } else {
                System.out.println("\nError: No visitor is found.");
            }
        // Catches exception rather than throwing an error
        } catch (Exception e) {
            System.out.println("Error: error occured -> " + e.getMessage());
        } finally {
            // Unlocks lock
            lock.unlock();
        }
    }

    // Overrides method from RideInterface
    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        // Calls lock for thread-safe modification to waitingLine
        lock.lock();
        try {
            if (visitor != null) {
                waitingLine.remove(visitor);
                System.out.println("\n" + visitor.getName() + " removed from the waiting queue.");
            } else {
                System.out.println("Error: No visitor is found.");
            }
        } catch (Exception e) {
            System.out.println("Error: error occured -> " + e.getMessage());
        } finally {
            // Unlocks lock
            lock.unlock();
        }
    }

    // Overrides method from RideInterface
    @Override
    public void printQueue() {
        int index = 0;
        System.out.println("\nVisitors waiting (" + waitingLine.size() + "):");

        for (Visitor visitor : waitingLine) {
            index += 1;
            System.out.println(index + ". " + visitor.getName());
        }
    }

    // Overrides method from RideInterface
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

        // Uses Math module to get the minimum between the two parameters
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

    // Overrides method from RideInterface
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        // Locks for thread-safe modification to rideHistory
        lock.lock();
        try {
            // Checks if visitor is not in rideHistory before adding visitor
            if (!rideHistory.contains(visitor)) {
                rideHistory.add(visitor);
                System.out.println(visitor.getName() + " has been added to ride history.");
            } else {
                System.out.println("\nError: " + visitor.getName() + " is already in ride history.");
            }
        } catch (Exception e) {
            System.out.println("Error: error occured -> " + e.getMessage());
        } finally {
            // Unlocks lock
            lock.unlock();
        }
    }

    // Clears ride history
    @Override
    public void clearRideHistory() {
        // Locks for thread-safe modification to rideHistory
        lock.lock();
        try {
            // Clears whole history using .clear() method
            Ride.rideHistory.clear(); 
            System.out.println("Ride history has been cleared!");
        // Handles exception
        } catch (Exception e) {
            System.out.println("Error: exception occurred -> " + e.getMessage());
        } finally {
            // Unlocks lock
            lock.unlock();
        }
    }

    // Overrides method from RideInterface
    @Override
    public void checkVisitorFromHistory(Visitor visitor) {
        System.out.println("\nRide history: ");
        
        if (rideHistory.contains(visitor)) {
            System.out.println(visitor.getName() + "found in ride history.");
        } else {
            System.out.println(visitor.getName() + " not found in ride history.");
        }
    }

    // Overrides method from RideInterface
    @Override
    public void numberOfVisitors() {
        int visitors = rideHistory.size();

        if (visitors != 0) {
            System.out.println("\nNumber of park visitors in history: " + visitors);
        }
        else {
            System.out.println("\nError: no visitors found.");
        }
    }

    // Overrides method from RideInterface
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

        // Calls lock for thread-safe for sort method accessing rideHistory
        lock.lock();

        try {
            // Accesses Collections sort method
            Collections.sort(rideHistory, new CompareVisitors());
        
            System.out.println("\nSorted ride history by rides taken:");
        
            // Iterates through ride history using advanced for loop 
            for (Visitor v : rideHistory) {
                System.out.println("Visitor ID: " + v.getVisitorID() + " , Name: " + v.getName() + ", Rides taken: " + v.getRidesTaken());
            }
        } catch (Exception e) {
            System.out.println("Error: error occured -> " + e.getMessage());
        } finally {
            // Unlocks lock
            lock.unlock();
        }
    }

    // Exports visitors from rideHistory LinkedList
    public void exportRideHistory() {
        // Lock called for changes to file and file write functions
        lock.lock();
        try {
            // New instance folder being created for CSV folder in CBUCHAN-A2 folder
            File folder = new File("csv");
            
            // Checks if folder does not currently exist
            if (!folder.exists()) {
                // Makes new directory/folder if folder not found
                folder.mkdir();
            }

            // New instance file
            File file = new File(folder, "RideHistory.csv");
            
            if (file.createNewFile()) {
                System.out.println("\nFile created called: " + file.getName());
            } else {
                System.out.println("\n" + file.getName() + " already exists.");
            }

            // BufferedWriter wrapping FileWriter used to handle all parsed characters more efficiently within a try-with-statement
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
                bufferedWriter.write("Visitor Name,Email,Height,Visitor ID,Rides Taken\n");
                for (Visitor visitor : rideHistory) {
                    String writtenLine = visitor.toCSV() + "\n";
                    bufferedWriter.write(writtenLine);
                }
                // Closed BufferedWriter to stop resource leaks
                // Catches Input Output exception printing the error
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("IOException error: " + e.getMessage());
        } finally {
            // Unlocks lock
            lock.unlock();
        }
    }

    // Imports ride history from CSV file
    public void importRideHistory() {
        int lineIndex = 1;

        lock.lock();
        try {
            File file = new File("csv/RideHistory.csv");
        
            if (!file.exists()) {
                System.out.println("\nError: file path does not exist");
                return;
            }

            // Checks if the file exists 
            if (file.exists()) {
                System.out.println("\n" + file + " exists.");
            }

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
           
                // Skips the headings line
                bufferedReader.readLine();

                System.out.println("\nImported lines from csv file:");
                String rideHistoryLine = bufferedReader.readLine();

                // Clears anything from ride history to prep for import
                rideHistory.clear();
            
                // Checks if bufferedReader has not reached the end of the file (if so it would return null)
                while (rideHistoryLine != null) { 
                    // Splits where a comma is located on line
                    String[] lines = rideHistoryLine.split(",");

                    // Checks if the columns (lines.length) has 5 columns
                    if (lines.length >= 5) {
                        String name = lines[0];
                        String email = lines[1];
                        double height = Double.parseDouble(lines[2]);
                        int visitorID = Integer.parseInt(lines[3]);
                        int ridesTaken = Integer.parseInt(lines[4]);

                        // Create a Visitor object using these values
                        Visitor visitor = new Visitor(name, email, height, visitorID, ridesTaken);

                        // Adds visitor to queue and rideHistory list
                        rideHistory.add(visitor);
                        addVisitorToQueue(visitor);
                    } else {
                        System.out.println("Error: Skipped line " + rideHistoryLine);
                    }
                    System.out.println("Visitor " + lineIndex + ": " + rideHistoryLine);
                    lineIndex++; // Increments index per line
                    rideHistoryLine = bufferedReader.readLine();
                }

                // Closed BufferedReader to stop resource leaks
                bufferedReader.close();
       
            // Catches Input Output exception printing the error
            } catch (Exception e) {
                System.out.println("\nError: " + e.getMessage());
            } 
        } finally {       
            // Unlocks lock
            lock.unlock();
        }
    }
}