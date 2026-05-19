package service;

import entity.Booking;
import entity.Room;
import util.DataStore;

public class ReportService {

    public void showReports() {

        System.out.println("\n Occupancy Report :-");

        for (Room r : DataStore.rooms) {

            int bookingCount = 0;
            double revenue = 0;

            for (Booking b : DataStore.bookings) {

                if (b.getRoomId() == r.getRoomId()) {

                    bookingCount++;
                    revenue += b.getTotalPrice();
                }
            }

            System.out.println(
                    "Room ID: " + r.getRoomId() +
                    " | Type: " + r.getRoomType() +
                    " | Occupancy: " + bookingCount +
                    " | Revenue: " + revenue
            );
        }

        System.out.println("\n SQL query result :- ");
        System.out.printf("%-10s | %-12s | %-30s | %-10s\n", "Hotel ID", "Room Type", "Occupancy (Booking Count)", "Revenue");
        System.out.println("-------------------------------------------------------------------------");

        // Grouping logic: Key = hotelId + "_" + roomType
        java.util.Map<String, HotelRoomTypeStats> statsMap = new java.util.HashMap<>();

        for (Booking b : DataStore.bookings) {
            Room room = null;
            for (Room r : DataStore.rooms) {
                if (r.getRoomId() == b.getRoomId()) {
                    room = r;
                    break;
                }
            }

            if (room != null) {
                String key = room.getHotelId() + "_" + room.getRoomType();
                HotelRoomTypeStats stats = statsMap.get(key);
                if (stats == null) {
                    stats = new HotelRoomTypeStats(room.getHotelId(), room.getRoomType());
                    statsMap.put(key, stats);
                }
                stats.bookingCount++;
                stats.totalRevenue += b.getTotalPrice();
            }
        }

        java.util.List<HotelRoomTypeStats> statsList = new java.util.ArrayList<>(statsMap.values());
        statsList.sort((s1, s2) -> Integer.compare(s2.bookingCount, s1.bookingCount)); // Sort DESC by bookingCount

        if (statsList.isEmpty()) {
            System.out.println("No booking data available.");
        } else {
            for (HotelRoomTypeStats stats : statsList) {
                System.out.printf("%-10d | %-12s | %-30d | $%-10.2f\n",
                        stats.hotelId, stats.roomType, stats.bookingCount, stats.totalRevenue);
            }
        }

    }

    private static class HotelRoomTypeStats {
        int hotelId;
        String roomType;
        int bookingCount;
        double totalRevenue;

        HotelRoomTypeStats(int hotelId, String roomType) {
            this.hotelId = hotelId;
            this.roomType = roomType;
            this.bookingCount = 0;
            this.totalRevenue = 0.0;
        }
    }
}
