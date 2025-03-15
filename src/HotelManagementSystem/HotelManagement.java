package HotelManagementSystem;


class Hotel{
	String name;
	String location;
	int rating;
	
	Hotel(String name,String location,int rating){
		this.name = name;
		this.location = location;
		this.rating = rating;
	}	
	
	void displayHotelDetails() {
		System.out.println("Hotel Name: "+this.name);
		System.out.println("Hotel Location: "+this.location);
		System.out.println("Hotel Rating: "+this.rating);
	}
}

class Room extends Hotel{
	int roomNumber;
	String roomType;
	int price;
	boolean isAvailable;
	
	Room(String name,String location,int rating,int roomNumber,String roomType,int price){
		super(name,location,rating);
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.price = price;
		this.isAvailable = true;
		
	}
	

	public void bookRoom() {
		if(isAvailable) {
			isAvailable = false;	//booking so it is now unavailable 
			System.out.println("Room "+roomNumber+"has been booking");
		}
		else {
			System.out.println("Room is already booked");
		}
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}
	
	void displayRoomDetails() {
		super.displayHotelDetails();
		System.out.println("Room Number: "+this.roomNumber);
		System.out.println("Room Type: "+this.roomType);
		System.out.println("Room Price: "+this.price);
		System.out.println("Room availability: "+(isAvailable ? "Available": "Booked"));
	}
	
}

class Guest{
	String guestName;
	int guestId;
	Room bookedRoom;	//Association guest has one room
	
	Guest(String guestName,int guestId){
		this.guestName = guestName;
		this.guestId = guestId;
		this.bookedRoom = null;
	}
	
	void bookRoom(Room room) {
		if(room.isAvailable()) {
				room.bookRoom();
				this.bookedRoom = room;
				System.out.println(guestName + " has booked Room " + room);
        } else {
            System.out.println("Room is not available for booking.");
        }
		}
	

public void displayGuestDetails() {
    System.out.println("Guest Name: " + guestName);
    System.out.println("Guest ID: " + guestId);
    if (bookedRoom != null) {
        System.out.println("Booked Room Details:");
        bookedRoom.displayRoomDetails();
    } else {
        System.out.println("No room booked yet.");
    }
}
}


public class HotelManagement {
	public static void main(String[] args) {
		Hotel h = new Hotel("Jadhav Hotel","Pune",5);
		h.displayHotelDetails();
		
		Room r = new Room("Grand Palace","Mumbai", 5,100,"VIP",10000);
		r.displayRoomDetails();
		
		Guest g = new Guest("Vrushali",222);
		g.bookRoom(r);
		
		g.displayGuestDetails();
        r.displayRoomDetails(); 
	}
}