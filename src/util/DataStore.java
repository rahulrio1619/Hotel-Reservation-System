package util;

import entity.*;

import java.util.ArrayList;
import java.util.List;

public class DataStore {

    public static List<Hotel> hotels = new ArrayList<>();
    public static List<Room> rooms = new ArrayList<>();
    public static List<Customer> customers = new ArrayList<>();
    public static List<Booking> bookings = new ArrayList<>();
    public static int hotelIdCounter = 1;
    public static int roomIdCounter = 1;
    public static int customerIdCounter = 1;
    public static int bookingIdCounter = 1;

    public static final java.util.Scanner sc = new java.util.Scanner(System.in);
}
