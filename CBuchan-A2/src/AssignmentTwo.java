 /*
 * AssignmentTwo Class
 */

public class AssignmentTwo {
    public static void main (String[] args) throws Exception {
        // Assignment object instance
        AssignmentTwo assignment = new AssignmentTwo();
        
        // Assignment parts
        System.out.println("Part 3:");
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
        Ride rollerCoaster = new Ride("Roller Coaster", true, operator);
        
        // Visitors
        Visitor visitor1 = new Visitor("Angela", "angela@example.com", 165.0, 102);
        Visitor visitor2 = new Visitor("Bruce", "bruce@example.com", 175.0, 103);
        Visitor visitor3 = new Visitor("James", "james@example.com", 155.0, 104);
        Visitor visitor4 = new Visitor("Ryan", "ryan@example.com", 180.0, 105);
        Visitor visitor5 = new Visitor("Christine", "christine@example.com", 170.0, 106);
        
        // Adds visitors to waiting queue
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        // Remove a visitor from queue
        rollerCoaster.removeVisitorFromQueue(visitor3);

        // Print visitor queue
        rollerCoaster.printQueue();
    }

    public void partFourA(){
        // Created class objects instances
        Ride visitorSystem = new Ride(null, false, null);

        // Visitors
        Visitor visitor1 = new Visitor("Jim", "jim@example.com", 158, 102);
        Visitor visitor2 = new Visitor("Sam", "sam@example.com", 165.0, 103);
        Visitor visitor3 = new Visitor("Tony", "tony@example.com", 182.0, 104);
        Visitor visitor4 = new Visitor("Lauren", "lauren@example.com", 174.0, 105);
        Visitor visitor5 = new Visitor("Xan", "xan@example.com", 170.0, 106);

        // Adds visitors to history
        System.out.println("\nVisitors added to history: ");
        visitorSystem.addVisitorToHistory(visitor1);
        visitorSystem.addVisitorToHistory(visitor2);
        visitorSystem.addVisitorToHistory(visitor3);
        visitorSystem.addVisitorToHistory(visitor4);
        visitorSystem.addVisitorToHistory(visitor5);

        // Prints number of visitors
        visitorSystem.numberOfVisitors();

        // Prints all visitors
        visitorSystem.printRideHistory();
    }

    public void partFourB(){
        // Created class objects instances
        Employee operator = new Employee("Alice", "alice@example.com", 170.5, 102);
        Ride visitorSystem = new Ride("Tornado Coaster", false, operator);
        

        // Visitors
        Visitor visitor1 = new Visitor("Bob", "bob@example.com", 171, 109);
        Visitor visitor2 = new Visitor("Ruby", "ruby@example.com", 152, 107);
        Visitor visitor3 = new Visitor("Rodrick", "rodrick@example.com", 171, 108);
        Visitor visitor4 = new Visitor("Judy", "judy@example.com", 165, 1011);
        Visitor visitor5 = new Visitor("Dave", "dave@example.com", 180, 1010);

        // Adds visitor to queue in random order
        visitorSystem.addVisitorToQueue(visitor3);
        visitorSystem.addVisitorToQueue(visitor1);
        visitorSystem.addVisitorToQueue(visitor5);
        visitorSystem.addVisitorToQueue(visitor4);
        visitorSystem.addVisitorToQueue(visitor2);
        visitorSystem.addVisitorToQueue(visitor3);
        visitorSystem.addVisitorToQueue(visitor5);

        // Prints all visitors in queue
        visitorSystem.printQueue();

        // Runs ride cycles
        int runRideCycles = 7;

        while (runRideCycles > 0) { 
            visitorSystem.runOneCycle();
            runRideCycles--;
        }

        // Sorts visitors based on visitorID
        visitorSystem.sortVisitors();

        // Prints stored rideHistory
        visitorSystem.printRideHistory();
    }

    public void partFive(){
        // Created class objects instances
        Employee operator = new Employee("Bruno", "bruno@example.com", 200, 103);
        Ride visitorSystem = new Ride("Hyper Coaster", false, operator);

        // Visitors
        Visitor visitor1 = new Visitor("Randal", "randal@example.com", 171, 1012);
        Visitor visitor2 = new Visitor("Ruben", "ruben@example.com", 152, 1014);
        Visitor visitor3 = new Visitor("Derrik", "derrik@example.com", 171, 1013);
        Visitor visitor4 = new Visitor("Jemma", "jemma@example.com", 165, 1016);
        Visitor visitor5 = new Visitor("Christopher", "christopher@example.com", 180, 1015);

        // Add visitors to queue
        visitorSystem.addVisitorToQueue(visitor5);
        visitorSystem.addVisitorToQueue(visitor1);
        visitorSystem.addVisitorToQueue(visitor2);
        visitorSystem.addVisitorToQueue(visitor4);
        visitorSystem.addVisitorToQueue(visitor3);
        
        // Prints visitors in queue
        visitorSystem.printQueue();

        // Runs one cycle
        visitorSystem.runOneCycle();

        // Prints all visitors in queue
        visitorSystem.printQueue();

        // Prints all visitors in collection
        visitorSystem.printRideHistory();
    }

    public void partSix(){
    }

    public void partSeven(){
    }
}