/*
 * AssignmentTwo Class
 */

// Imported java packages
import java.util.concurrent.*;

public class AssignmentTwo {
    // Declared visitorSystem for class reusability
    private Ride visitorSystem;

    public static void main (String[] args) throws Exception {
        // Assignment object instance
        AssignmentTwo assignment = new AssignmentTwo();

        // Checks how many CPU cores are avaliable for thread use
        int avaliableCores = Runtime.getRuntime().availableProcessors();
        System.out.println("Avaliable CPU cores: " + avaliableCores);
        
        // Assignment parts
        System.out.println("\nPart 3:");
        assignment.partThree();

        System.out.println("\nPart 4A:");
        assignment.partFourA();

        System.out.println("\nPart 4B:");
        assignment.partFourB();

        System.out.println("\nPart 5:");
        assignment.partFive();

        System.out.println("\nPart 6:");
        assignment.partSix();

        System.out.println("\nPart 7:");
        assignment.partSeven();
    }

    public void partThree(){
        // Created class objects instances
        Employee operator = new Employee("Alice", "alice@example.com", 170.5, 101);
        this.visitorSystem = new Ride("The Flash", 30);

        // Set employee to ride
        visitorSystem.setEmployee(operator);
        
        // Visitors
        Visitor visitor1 = new Visitor("Angela", "angela@example.com", 165.0, 102, 0);
        Visitor visitor2 = new Visitor("Bruce", "bruce@example.com", 175.0, 103, 0);
        Visitor visitor3 = new Visitor("James", "james@example.com", 155.0, 104, 0);
        Visitor visitor4 = new Visitor("Ryan", "ryan@example.com", 180.0, 105, 0);
        Visitor visitor5 = new Visitor("Christine", "christine@example.com", 170.0, 106, 0);
        
        // Stores visitors in object array
        Visitor[] visitors = {
            visitor1,
            visitor2,
            visitor3,
            visitor4,
            visitor5
        };

        // Iterates through visitors and adds visitor to queue
        for (Visitor visitor : visitors) {
            visitorSystem.addVisitorToQueue(visitor);
        }

        // Remove a visitor from queue 
        visitorSystem.removeVisitorFromQueue(visitor3);

        // Print visitor queue
        visitorSystem.printQueue();

        // Reset and clear rideHistory
        visitorSystem.clearRideHistory();
    }

    public void partFourA(){
        // Created class objects instances
        Employee operator = new Employee("Mia", "mia@example.com", 159, 102);
        this.visitorSystem = new Ride("Kansas Twister", 22);
        
        // Set employee to ride
        visitorSystem.setEmployee(operator);

        // Visitors
        Visitor visitor1 = new Visitor("Jim", "jim@example.com", 158, 102, 0);
        Visitor visitor2 = new Visitor("Sam", "sam@example.com", 165.0, 103, 0);
        Visitor visitor3 = new Visitor("Tony", "tony@example.com", 182.0, 104, 0);
        Visitor visitor4 = new Visitor("Lauren", "lauren@example.com", 174.0, 105, 0);
        Visitor visitor5 = new Visitor("Xan", "xan@example.com", 170.0, 106, 0);

        // Adds visitors to history
        System.out.println("\nVisitors added to history: ");

        // Stores visitors in object array
        Visitor[] visitors = {
            visitor1,
            visitor2,
            visitor3,
            visitor4,
            visitor5
        };

        // Iterates through visitors and adds to history
        for (Visitor visitor : visitors) {
            visitorSystem.addVisitorToHistory(visitor);
        }

        // Prints number of visitors
        visitorSystem.numberOfVisitors();

        // Prints all visitors
        visitorSystem.printRideHistory();

        // Reset and clear rideHistory
        visitorSystem.clearRideHistory();
    }

    public void partFourB(){
        // Created class objects instances
        Employee operator = new Employee("Ronaldo", "ronaldo@example.com", 175.5, 103);
        this.visitorSystem = new Ride("Spooky Coaster", 0);
        
        // Set employee to ride
        visitorSystem.setEmployee(operator);

        // Visitors
        Visitor visitor1 = new Visitor("Bob", "bob@example.com", 171, 109, 0);
        Visitor visitor2 = new Visitor("Ruby", "ruby@example.com", 152, 107, 0);
        Visitor visitor3 = new Visitor("Rodrick", "rodrick@example.com", 171, 108, 0);
        Visitor visitor4 = new Visitor("Judy", "judy@example.com", 165, 1011, 0);
        Visitor visitor5 = new Visitor("Dave", "dave@example.com", 180, 1010, 0);

        // Stores visitors in object array
        Visitor[] visitors = {
            visitor1,
            visitor2,
            visitor3,
            visitor4,
            visitor5
        };

        // Iterates through visitors and adds visitor to queue
        for (Visitor visitor : visitors) {
            visitorSystem.addVisitorToQueue(visitor);
        }

        // Prints all visitors in queue
        visitorSystem.printQueue();

        // Runs ride cycles
        int runRideCycles = 7;

        // While loop if runRideCycles is greater than 0, decrements everytime till 0 is reached
        while (runRideCycles > 0) { 
            visitorSystem.runOneCycle();
            runRideCycles--;
        }

        // Sorts visitors based on visitorID
        visitorSystem.sortVisitors();

        // Prints stored rideHistory
        visitorSystem.printRideHistory();

        // Reset and clear rideHistory
        visitorSystem.clearRideHistory();
    }

    public void partFive(){
        // Created class objects instances
        Employee operator = new Employee("Bruno", "bruno@example.com", 195, 104);
        this.visitorSystem = new Ride("Superman Escape", 0);

        // Set employee to ride
        visitorSystem.setEmployee(operator);
        
        // Visitors
        Visitor visitor1 = new Visitor("Randal", "randal@example.com", 171, 1012, 0);
        Visitor visitor2 = new Visitor("Ruben", "ruben@example.com", 152, 1014, 0);
        Visitor visitor3 = new Visitor("Derrik", "derrik@example.com", 171, 1013, 0);
        Visitor visitor4 = new Visitor("Jemma", "jemma@example.com", 165, 1016, 0);
        Visitor visitor5 = new Visitor("Christopher", "christopher@example.com", 180, 1015, 0);

        // Stores visitors in object array
        Visitor[] visitors = {
            visitor1,
            visitor2,
            visitor3,
            visitor4,
            visitor5
        };

        // Iterates through visitors and adds visitor to queue
        for (Visitor visitor : visitors) {
            visitorSystem.addVisitorToQueue(visitor);
        }
        
        // Prints visitors in queue
        visitorSystem.printQueue();

        // Runs one cycle
        visitorSystem.runOneCycle();

        // Prints all visitors in queue
        visitorSystem.printQueue();

        // Prints all visitors in collection
        visitorSystem.printRideHistory();

        // Reset and clear rideHistory
        visitorSystem.clearRideHistory();
    }

    public void partSix(){
        // Threads created

        // Created class objects instances
        Employee operator = new Employee("Karly", "karly@example.com", 180, 105);
        this.visitorSystem = new Ride("DC Hyper Coaster", 61.6);

        // Set employee to ride
        visitorSystem.setEmployee(operator);

        // Check ride height
        visitorSystem.checkRideHeight();

        // Visitors
        Visitor visitor1 = new Visitor("Randal", "randal@example.com", 171, 1012, 0);
        Visitor visitor2 = new Visitor("Ruben", "ruben@example.com", 152, 1014, 0);
        Visitor visitor3 = new Visitor("Derrik", "derrik@example.com", 171, 1013, 0);
        Visitor visitor4 = new Visitor("Jemma", "jemma@example.com", 165, 1016, 0);
        Visitor visitor5 = new Visitor("Christopher", "christopher@example.com", 180, 1015, 0);

        // Stores visitors in object array
        Visitor[] visitors = {
            visitor1,
            visitor2,
            visitor3,
            visitor4,
            visitor5
        };

        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Adds visitors to waiting queue
        try {
            // Iterates over stored visitors in visitors object array
            for (Visitor visitor : visitors) {
                executor.submit(() -> visitorSystem.addVisitorToQueue(visitor));
            }
        // Catches error rather than throwing it in terminal
        } catch (Exception e) {
            System.out.println("Error: error occurred -> " + e.getMessage());
        } finally {
            executor.shutdown();

            try {
                // Waits 1 minute until tasks have finished, if tasks have not finished it returns false
                if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                    // Forces shutdown 
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                System.out.println("Error: error occurred -> " + e.getMessage());
                // Forces shutdown 
                executor.shutdownNow();
            }
        }

        // Runs ride cycles (3 visitors max per carriage)
        int runRideCycles = 2;

        while (runRideCycles > 0) { 
            visitorSystem.runOneCycle();
            runRideCycles--;
        }

        // Prints all visitors in collection
        visitorSystem.printRideHistory();

        // Export ride history
        visitorSystem.exportRideHistory();
    }

    public void partSeven(){
        // Created class objects instances
        Employee operator = new Employee("Mandy", "mandy@example.com", 160.5, 106);
        this.visitorSystem = new Ride("Green Lantern Coaster", 33);

        // Set employee to ride
        visitorSystem.setEmployee(operator);

        // Check ride height
        visitorSystem.checkRideHeight();

        // Prints rideHistory prior to file import
        visitorSystem.numberOfVisitors();

        // Imports ride history from CSV file
        visitorSystem.importRideHistory();

        // Prints rideHistory after the file import
        visitorSystem.numberOfVisitors();
    }
}