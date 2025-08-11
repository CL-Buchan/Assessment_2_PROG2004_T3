/*
 * Ride Interface
 */

public interface RideInterface {

    // Interface methods without body as they are overridden in inherited class (body removed from prev commits)
    void addVisitorToQueue(Visitor visitor);

    void removeVisitorFromQueue(Visitor visitor);

    void printQueue();

    void runOneCycle();

    void addVisitorToHistory(Visitor visitor);

    void clearRideHistory();

    void checkVisitorFromHistory(Visitor visitor);

    void numberOfVisitors();

    void printRideHistory();
}