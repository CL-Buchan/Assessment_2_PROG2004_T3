/*
 * AssignmentTwo Class
 */

public class AssignmentTwo {
    public static void main (String[] args) throws Exception {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
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
    }

    public void partFourB(){
    }

    public void partFive(){
    }

    public void partSix(){
    }

    public void partSeven(){
    }
}