
import java.util.HashMap;
import java.util.Map;


class RoomInventory {

    // HashMap storing room type and availability count
    private HashMap<String, Integer> inventory;

    /**
     * Constructor initializes inventory with default values
     */
    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    /**
     * Method to get availability of a specific room type
     */
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    /**
     * Method to update room availability
     */
    public void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    /**
     * Method to display complete inventory
     */
    public void displayInventory() {
        System.out.println("Current Room Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " rooms available");
        }
    }
}



public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("        Book My Stay App");
        System.out.println("   Hotel Booking System v3.1");
        System.out.println("====================================");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display current inventory
        inventory.displayInventory();

        System.out.println("\nChecking availability for Double Room:");
        System.out.println("Available Rooms: " + inventory.getAvailability("Double Room"));

        // Update availability example
        System.out.println("\nUpdating availability for Double Room...");
        inventory.updateAvailability("Double Room", 4);

        // Display updated inventory
        System.out.println("\nUpdated Inventory:");
        inventory.displayInventory();
    }
}