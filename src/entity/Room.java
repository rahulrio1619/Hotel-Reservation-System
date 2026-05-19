package entity;

public class Room {

    private int roomId;
    private int hotelId;
    private String roomType;
    private double price;

    public Room(int roomId,
                int hotelId,
                String roomType,
                double price) {

        this.roomId = roomId;
        this.hotelId = hotelId;
        this.roomType = roomType;
        this.price = price;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", hotelId=" + hotelId +
                ", roomType='" + roomType + '\'' +
                ", price=" + price +
                '}';
    }
}
