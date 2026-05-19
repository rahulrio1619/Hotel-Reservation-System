package service;

import entity.Booking;
import entity.Room;
import util.DataStore;

public class PricingService {

    public double calculatePrice(Room room) {

        int bookedCount = 0;

        for (Booking b : DataStore.bookings) {

            if (b.getRoomId() == room.getRoomId()) {
                bookedCount++;
            }
        }

        double occupancyRate =
                (double) bookedCount / DataStore.rooms.size();

        if (occupancyRate > 0.5) {

            return room.getPrice() * 1.2;
        }

        return room.getPrice();
    }
}
