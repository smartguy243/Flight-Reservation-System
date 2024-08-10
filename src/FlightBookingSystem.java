    /*
      @author: SmartGuy
      @description: The program manages flight bookings, allowing users
                    to add, modify and cancel reservations.
    */

import java.util.ArrayList;
import java.util.Scanner;

class Booking {
    String name, origin, destination, seat, date;

    Booking(String name, String origin, String destination, String seat, String date) {
        this.name = name;
        this.origin = origin;
        this.destination = destination;
        this.seat = seat;
        this.date = date;

    }
}

public class FlightBookingSystem {
    static ArrayList<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userChoice;

        do {
            System.out.println("------------------------------------------------------");
            System.out.println("Welcome to our flight Booking system !");
            System.out.println("Please, select an option !");
            System.out.println(); // Add a blank line for better readability
            System.out.println("1. Add a booking.");
            System.out.println("2. Modify a booking.");
            System.out.println("3. Cancel a booking.");
            System.out.println("4. Show bookings.");
            System.out.println("5. Quit");
            System.out.println("------------------------------------------------------");
            System.out.println();

            userChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline

            switch (userChoice) {
                case 1:
                    addBooking(scanner);
                    break;
                case 2:
                    modifyBooking(scanner);
                    break;
                case 3:
                    cancelBooking(scanner);
                    break;
                case 4:
                    showBookings();
                    break;
                case 5:
                    System.out.println("Thank you for choosing us ! See you next time...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (userChoice != 5);

        scanner.close();
    }

    // Make a booking
    static void addBooking(Scanner scanner) {
        System.out.print("Enter your name : ");
        String name = scanner.nextLine();
        System.out.print("Enter your departure point (City) : ");
        String origin = scanner.nextLine();
        System.out.print("Enter the destination (City) : ");
        String destination = scanner.nextLine();
        System.out.print("Choose a seat (ex: 9C, 31A, 24B,... : ");
        String seat = scanner.nextLine();
        System.out.print("Enter the date of departure (ex: 09/03/2024) : ");
        String date = scanner.nextLine();

        Booking Booking = new Booking(name, origin, destination, seat, date);

        bookings.add(Booking);
        System.out.println();
        System.out.println(name + " , your new booking has been successfully added !");
    }

    // Update a booking
    static void modifyBooking(Scanner scanner) {
        System.out.print("Enter the id number of the booking to be updated (1 to " + bookings.size() + "): ");
        int id = scanner.nextInt() - 1;

        if (id >= 0 && id < bookings.size()) {
            System.out.print("Enter a new name for your booking : ");
            String newName = scanner.nextLine();
            System.out.print("Specify a departure point : ");
            String newOrigin = scanner.nextLine();
            System.out.print("Enter a destination : ");
            String newDestination = scanner.nextLine();
            System.out.print("Choose a new seat (ex: 9C, 31A, 24B,... : ");
            String newSeat = scanner.nextLine();
            System.out.print("Enter a new date of departure (ex: 09/03/2024) : ");
            String newDate = scanner.nextLine();

            Booking UpdatedBooking = new Booking(newName, newOrigin, newDestination, newSeat, newDate);
            bookings.set(id, UpdatedBooking);
            System.out.println(newName + " , your booking has been successfully updated !");
        } else {
            System.out.println("Invalid id booking number. Please provide a valid one !");
        }
    }

    // Cancelling a booking
    static void cancelBooking(Scanner scanner) {
        System.out.print("Enter the id number of the booking to be cancelled (1 to " + bookings.size() + ") : ");
        int id = scanner.nextInt() - 1;
        scanner.nextLine();

        if (bookings.isEmpty()) {
            System.out.println("No current reservations. Please make a booking !");
            System.out.println(); // Add a blank line for better readability
        }
         else if (id >= 0 && id < bookings.size()) {
            bookings.remove(id); // Booking deletion
            System.out.println("Cancelled booking.");
        } else {
            System.out.println("Invalid id booking number. Please provide a valid one !");
        }
    }

    // Show the bookings
    static void showBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No current reservations. Please make a booking !");
            System.out.println();
        } else {
            System.out.println("Current bookings :");
            for (int i = 0; i < bookings.size(); i++) {
                Booking Booking = bookings.get(i);
                System.out.println((i + 1) + "." + "Passenger : " + Booking.name + "\n" +
                                    "  From : " + Booking.origin + "\n" +
                                    "  To   : " + Booking.destination + "\n" +
                                    "  Seat : " + Booking.seat + "\n" +
                                    "  On   : " + Booking.date);
            }
        }
    }
}