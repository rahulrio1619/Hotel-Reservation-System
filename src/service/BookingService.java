package service;

import entity.*;
import util.DataStore;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class BookingService {

    Scanner sc = util.DataStore.sc;

    PricingService pricingService = new PricingService();

    public void bookRoom() {

        System.out.print("Enter Customer Name: ");
        String customerName = sc.nextLine();

        Customer customer = new Customer(
                DataStore.customerIdCounter++,
                customerName
        );
        DataStore.customers.add(customer);
        System.out.print("Enter Room ID: ");
        int roomId = Integer.parseInt(sc.nextLine());
        Room selectedRoom = null;

        for (Room r : DataStore.rooms) {

            if (r.getRoomId() == roomId) {
                selectedRoom = r;
                break;
            }
        }

        if (selectedRoom == null) {

            System.out.println("Room Not Found");
            return;
        }

        System.out.print("Check In Date (YYYY-MM-DD): ");
        LocalDate checkIn = LocalDate.parse(sc.nextLine());

        System.out.print("Check Out Date (YYYY-MM-DD): ");
        LocalDate checkOut = LocalDate.parse(sc.nextLine());

        if (checkOut.isBefore(checkIn)) {

            System.out.println("Invalid Date Range");
            return;
        }

        // DOUBLE BOOKING CHECK

        for (Booking b : DataStore.bookings) {

            if (b.getRoomId() == roomId) {

                boolean overlap =
                        !(checkOut.isBefore(b.getCheckIn()) ||
                          checkIn.isAfter(b.getCheckOut()));

                if (overlap) {

                    System.out.println("Room Already Booked");
                    return;
                }
            }
        }

        long days =
                ChronoUnit.DAYS.between(checkIn, checkOut);

        double roomPrice =
                pricingService.calculatePrice(selectedRoom);

        double totalPrice = days * roomPrice;

        Booking booking = new Booking(
                DataStore.bookingIdCounter++,
                customer.getCustomerId(),
                roomId,
                checkIn,
                checkOut,
                totalPrice
        );

        DataStore.bookings.add(booking);

        System.out.println("Booking Successful");
        System.out.println("Total Price: " + totalPrice);
    }

    public void cancelBooking() {

        System.out.print("Enter Booking ID: ");
        int bookingId = Integer.parseInt(sc.nextLine());

        Booking bookingToRemove = null;

        for (Booking b : DataStore.bookings) {

            if (b.getBookingId() == bookingId) {

                bookingToRemove = b;

                long days =
                        ChronoUnit.DAYS.between(
                                LocalDate.now(),
                                b.getCheckIn()
                        );

                if (days >= 2) {

                    System.out.println("80% Refund Applicable");
                } else {

                    System.out.println("No Refund");
                }

                break;
            }
        }

        if (bookingToRemove != null) {

            DataStore.bookings.remove(bookingToRemove);

            System.out.println("Booking Cancelled");
        } else {

            System.out.println("Booking Not Found");
        }
    }

    public void viewBookings() {

        for (Booking b : DataStore.bookings) {
            System.out.println(b);
        }
    }
}
