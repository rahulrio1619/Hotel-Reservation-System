package entity;

import java.time.LocalDate;

public class Booking {

    private int bookingId;
    private int customerId;
    private int roomId;

    private LocalDate checkIn;
    private LocalDate checkOut;

    private double totalPrice;

    public Booking(int bookingId,
                   int customerId,
                   int roomId,
                   LocalDate checkIn,
                   LocalDate checkOut,
                   double totalPrice) {

        this.bookingId = bookingId;
        this.customerId = customerId;
        this.roomId = roomId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = totalPrice;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getRoomId() {
        return roomId;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", customerId=" + customerId +
                ", roomId=" + roomId +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
