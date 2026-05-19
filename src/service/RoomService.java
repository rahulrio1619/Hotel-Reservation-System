package service;

import entity.Room;
import util.DataStore;

import java.util.Scanner;

public class RoomService {

    Scanner sc = util.DataStore.sc;

    public void addRoom() {

        System.out.print("Enter Hotel ID: ");
        int hotelId = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Room Type: ");
        String roomType = sc.nextLine();

        System.out.print("Enter Base Price: ");
        double price = Double.parseDouble(sc.nextLine());

        Room room = new Room(
                DataStore.roomIdCounter++,
                hotelId,
                roomType,
                price
        );

        DataStore.rooms.add(room);

        System.out.println("Room Added Successfully");
    }

    public void viewRooms() {

        for (Room r : DataStore.rooms) {
            System.out.println(r);
        }
    }
}
