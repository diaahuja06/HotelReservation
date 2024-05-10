import java.util.ArrayList;
import java.util.Scanner;

class Room {
    private String roomNumber;
    private String roomType;
    private double roomPrice;
    private boolean isAvailable;

    // Constructor, getters, and setters
}

class Reservation {
    private String guestName;
    private Room room;
    private int numNights;

    // Constructor, getters, and setters
}

public class HotelReservationSystem {
    private static ArrayList<Room> rooms = new ArrayList<>();
    private static ArrayList<Reservation> reservations = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeRooms();

        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            handleChoice(choice);
        } while (choice != 4);
    }

    private static void initializeRooms() {
        rooms.add(new Room("101", "Standard", 99.99, true));
        rooms.add(new Room("102", "Deluxe", 149.99, true));
        rooms.add(new Room("201", "Suite", 199.99, true));
    }

    private static void displayMenu() {
        System.out.println("Hotel Reservation System");
        System.out.println("1. Search for available rooms");
        System.out.println("2. Make a reservation");
        System.out.println("3. View reservations");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                searchAvailableRooms();
                break;
            case 2:
                makeReservation();
                break;
            case 3:
                viewReservations();
                break;
            case 4:
                System.out.println("Thank you for using the Hotel Reservation System!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void searchAvailableRooms() {
        System.out.println("Available rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room.getRoomNumber() + " - " + room.getRoomType() + " - $" + room.getRoomPrice());
            }
        }
    }

    private static void makeReservation() {
        System.out.print("Enter guest name: ");
        String guestName = scanner.nextLine();

        System.out.println("Available rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room.getRoomNumber() + " - " + room.getRoomType() + " - $" + room.getRoomPrice());
            }
        }

        System.out.print("Enter room number: ");
        String roomNumber = scanner.nextLine();
        Room selectedRoom = null;
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber)) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom != null) {
            System.out.print("Enter number of nights: ");
            int numNights = scanner.nextInt();
            scanner.nextLine();
            Reservation reservation = new Reservation();
            reservation.setGuestName(guestName);
            reservation.setRoom(selectedRoom);
            reservation.setNumNights(numNights);
            reservations.add(reservation);
            System.out.println("Reservation made successfully!");
        } else {
            System.out.println("Invalid room number.");
        }
    }

    private static void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            System.out.println("Reservations:");
            for (Reservation reservation : reservations) {
                System.out.println("Guest Name: " + reservation.getGuestName());
                System.out.println("Room Number: " + reservation.getRoom().getRoomNumber());
                System.out.println("Room Type: " + reservation.getRoom().getRoomType());
                System.out.println("Number of Nights: " + reservation.getNumNights());
                System.out.println();
            }
        }
    }
}