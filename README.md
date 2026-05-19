# Hotel Reservation System

A lightweight, console-based Java application designed to manage hotel bookings, room availability, and generate reports. This application demonstrates core Object-Oriented Programming (OOP) principles, clean service-oriented architecture, and robust console-based user interaction.

## Features

- **Hotel Management**: Easily register and view hotels.
- **Room Management**: Add rooms to specific hotels and track room details (room number, type, price, and status).
- **Booking Workflow**:
  - Book a room for a specific customer with checking for room availability.
  - Cancel existing bookings.
  - View all active bookings.
- **Reports**: View occupancy rates, revenue statistics, and reservation summaries.

## Project Structure

```text
src/
├── entity/
│   ├── Booking.java
│   ├── Customer.java
│   ├── Hotel.java
│   ├── Room.java
│   └── RoomType.java
├── service/
│   ├── BookingService.java
│   ├── HotelService.java
│   ├── PricingService.java
│   ├── ReportService.java
│   └── RoomService.java
├── util/
│   └── DataStore.java
└── Main.java
```

## How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher.
- A terminal or IDE (like IntelliJ IDEA or Eclipse).

### Compile and Run via Terminal
1. Open your terminal in the project root directory.
2. Compile all java files:
   ```bash
   javac -d bin src/**/*.java src/*.java
   ```
3. Run the application:
   ```bash
   java -cp bin Main
   ```

---
*Created as part of the Hotel Reservation System project.*
