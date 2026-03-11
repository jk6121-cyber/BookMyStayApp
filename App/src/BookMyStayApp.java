import java.util.HashMap;
import java.util.Map;

/**
 * Book My Stay App
 * Use Case 4: Room Search & Availability Check
 *
 * Demonstrates read-only access to room inventory and displays
 * available room types with their details.
 *
 * @author Jyostna
 * @version 4.0
 */


/* ----------- Room Domain Model ----------- */

abstract class Room {

    String type;
    int beds;
    double price;

    Room(String type, int beds, double price) {
        this.type = type;
        this.beds = beds;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Room Type : " + type);
        System.out.println("Beds      : " + beds);
        System.out.println("Price     : $" + price);
    }
}


class SingleRoom extends Room {
    SingleRoom() {
        super("Single Room", 1, 100);
    }
}

class DoubleRoom extends Room {
    DoubleRoom() {
        super("Double Room", 2, 180);
    }
}

class SuiteRoom extends Room {
    SuiteRoom() {
        super("Suite Room", 3, 300);
    }
}


/* ----------- Inventory Class ----------- */

class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {

        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 0);   // unavailable
        inventory.put("Suite Room", 2);
    }

    // Read-only access
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public HashMap<String, Integer> getInventory() {
        return inventory;
    }
}


/* ----------- Search Service ----------- */

class RoomSearchService {

    public static void searchAvailableRooms(RoomInventory inventory) {

        System.out.println("\nAvailable Rooms:\n");

        for (Map.Entry<String, Integer> entry : inventory.getInventory().entrySet()) {

            String roomType = entry.getKey();
            int available = entry.getValue();

            // Validation: show only rooms with availability > 0
            if (available > 0) {

                Room room = null;

                if (roomType.equals("Single Room"))
                    room = new SingleRoom();
                else if (roomType.equals("Double Room"))
                    room = new DoubleRoom();
                else if (roomType.equals("Suite Room"))
                    room = new SuiteRoom();

                if (room != null) {
                    room.displayDetails();
                    System.out.println("Available Rooms: " + available);
                    System.out.println("---------------------------");
                }
            }
        }
    }
}


/* ----------- Main Application ----------- */

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("        Book My Stay App");
        System.out.println("     Hotel Booking v4.0");
        System.out.println("=================================");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Guest searches for rooms
        RoomSearchService.searchAvailableRooms(inventory);

        System.out.println("\nSearch completed. Inventory remains unchanged.");
    }
}