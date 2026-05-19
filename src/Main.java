import service.*;

import java.util.Scanner;

public class Main {

    static Scanner sc = util.DataStore.sc;

    static HotelService hotelService = new HotelService();
    static RoomService roomService = new RoomService();
    static BookingService bookingService = new BookingService();
    static ReportService reportService = new ReportService();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nHOTEL RESERVATION SYSTEM :-");
            System.out.println("1. Add Hotel");
            System.out.println("2. View Hotels");
            System.out.println("3. Add Room");
            System.out.println("4. View Rooms");
            System.out.println("5. Book Room");
            System.out.println("6. Cancel Booking");
            System.out.println("7. View Bookings");
            System.out.println("8. Reports");
            System.out.println("0. Exit");
            System.out.print("Enter Choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    hotelService.addHotel();
                    break;

                case 2:
                    hotelService.viewHotels();
                    break;

                case 3:
                    roomService.addRoom();
                    break;

                case 4:
                    roomService.viewRooms();
                    break;

                case 5:
                    bookingService.bookRoom();
                    break;

                case 6:
                    bookingService.cancelBooking();
                    break;

                case 7:
                    bookingService.viewBookings();
                    break;

                case 8:
                    reportService.showReports();
                    break;

                case 0:
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
