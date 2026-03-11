
abstract class Room {
    String type;
    int beds;
    int size;
    double price;

    // Constructor
    Room(String type, int beds, int size, double price) {
        this.type = type;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    // Method to display room details
    public void displayDetails() {
        System.out.println("Room Type : " + type);
        System.out.println("Beds      : " + beds);
        System.out.println("Size (sqft): " + size);
        System.out.println("Price     : $" + price);
    }
}

// Single Room class
class SingleRoom extends Room {

    SingleRoom() {
        super("Single Room", 1, 200, 100.0);
    }
}

// Double Room class
class DoubleRoom extends Room {

    DoubleRoom() {
        super("Double Room", 2, 350, 180.0);
    }
}

// Suite Room class
class SuiteRoom extends Room {

    SuiteRoom() {
        super("Suite Room", 3, 500, 300.0);
    }
}

/**
 * Application entry point for Use Case 2
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("      Book My Stay Application");
        System.out.println("   Hotel Booking System v2.1");
        System.out.println("====================================\n");

        // Create room objects (Polymorphism)
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability variables
        int singleAvailability = 5;
        int doubleAvailability = 3;
        int suiteAvailability = 2;

        // Display room details and availability
        System.out.println("Single Room Details:");
        single.displayDetails();
        System.out.println("Available Rooms: " + singleAvailability);
        System.out.println();

        System.out.println("Double Room Details:");
        doubleRoom.displayDetails();
        System.out.println("Available Rooms: " + doubleAvailability);
        System.out.println();

        System.out.println("Suite Room Details:");
        suite.displayDetails();
        System.out.println("Available Rooms: " + suiteAvailability);
        System.out.println();

        System.out.println("Application finished successfully.");
    }

}