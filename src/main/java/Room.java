import java.util.ArrayList;

public class Room {
    private String type;
    private int roomNumber;
    private String size;
    private int capacity;
    private ArrayList<Guest> guests;

    public Room(String typeOfRoom, int capacity){
        this.type = typeOfRoom;
        this.capacity = capacity;
        this.guests = new ArrayList<Guest>();
    }

    public Room(String typeOfRoom, int roomNumber, String sizeOfRoom){
        this.type = typeOfRoom;
        this.roomNumber = roomNumber;
        this.size = sizeOfRoom;
        this.getBedroomCapacity(sizeOfRoom);
        this.guests = new ArrayList<Guest>();
    }

    public String getType() {
        return this.type;
    }

    public int getRoomNumber() {
        return this.roomNumber;
    }

    public String getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    private void getBedroomCapacity(String sizeOfRoom){
        if (sizeOfRoom == "Single") {
            this.capacity = 1;
        }
        else {
            this.capacity = 2;
        }
    }

    public int getNumberOfGuests() {
        return this.guests.size();
    }

    public void checkInGuest(Guest guest) {
            this.guests.add(guest);
    }

    public int getRemainingCapacity() {
        return this.capacity - this.getNumberOfGuests();
    }


    public void checkOutGuest() {
        if (this.getNumberOfGuests() > 0){
            this.guests.remove(0);
        }
    }
}
