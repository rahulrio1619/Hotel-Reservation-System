package service;

import entity.Hotel;
import util.DataStore;

import java.util.Scanner;

public class HotelService {

    Scanner sc = util.DataStore.sc;

    public void addHotel() {

        System.out.print("Enter Hotel Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Location: ");
        String location = sc.nextLine();

        Hotel hotel = new Hotel(
                DataStore.hotelIdCounter++,
                name,
                location
        );

        DataStore.hotels.add(hotel);

        System.out.println("Hotel Added Successfully");
    }

    public void viewHotels() {

        for (Hotel h : DataStore.hotels) {
            System.out.println(h);
        }
    }
}
