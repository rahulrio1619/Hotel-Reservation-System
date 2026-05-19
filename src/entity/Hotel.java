package entity;

public class Hotel {

    private int hotelId;
    private String hotelName;
    private String location;

    public Hotel(int hotelId, String hotelName, String location) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.location = location;
    }

    public int getHotelId() {
        return hotelId;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
