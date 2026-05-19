# Distributed Hotel Reservation System

## Business Context
A hotel chain needs a system to manage room availability, bookings, cancellations, and pricing across multiple locations.

## Design Objective

Create a system to:
•	Manage hotels and rooms 
•	Book/cancel rooms 
•	Handle dynamic pricing based on occupancy 
•	Prevent double booking 
•	Generate occupancy reports 

## Main Flows
•	Hotel/Room management 
•	Customer booking 
•	Room allocation engine 
•	Cancellation handling 
•	Pricing updates 

## Business Rules
•	A room cannot be booked by multiple customers for same date range 
•	Price increases when occupancy > threshold 
•	Refund rules apply on cancellation timing 

## Constraints
•	Date range validation is mandatory 
•	Booking must be atomic (no partial booking) 
•	Room type must match request 

## Storage
•	In-memory + calendar-based availability map 
## SQL Use Case
Find hotels with highest occupancy rate and revenue per room type.
## Final Output
<img width="960" height="540" alt="FullStackAssessmentFinalSQLOutput" src="https://github.com/user-attachments/assets/4230c23b-c505-4895-aa97-1707a0dc5f19" />

