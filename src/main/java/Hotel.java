import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {
    private ArrayList<Guest> guests;
    private ArrayList<Room> otherRooms;
    private ArrayList<Room> bedrooms;
    private ArrayList<Room> emptyBedrooms;

    public Hotel(){
        this.guests = new ArrayList<Guest>();
        this.otherRooms = new ArrayList<Room>();
        this.bedrooms = new ArrayList<Room>();
        this.emptyBedrooms = new ArrayList<Room>();
    }


    public int getNumberOfGuests() {
        return this.guests.size();
    }

    public int getNumberOfRooms() {
        return this.otherRooms.size() + this.bedrooms.size();
    }

    public void addRoom(Room roomToAdd) {
        if(roomToAdd.getType() != "Bedroom") {
            this.otherRooms.add(roomToAdd);
        }
        else {
            this.bedrooms.add(roomToAdd);
        }
        this.updateEmptyBedrooms();
    }

    public void checkInGuestToBedroom(Guest guestToCheckIn) {
        this.updateEmptyBedrooms();
        if (this.emptyBedrooms.size() > 0) {
            Room availableRoom = this.getEmptyRoom();
            availableRoom.checkInGuest(guestToCheckIn);
            guestToCheckIn.addRoom(availableRoom);
            this.guests.add(guestToCheckIn);
            this.updateEmptyBedrooms();
        }
    }

    public void checkOutGuest(Guest guestToCheckOut) {
        this.guests.remove(this.guests.indexOf(guestToCheckOut));
        guestToCheckOut.getRoom().checkOutGuest();
        this.updateEmptyBedrooms();
    }

    private void updateEmptyBedrooms(){
        ArrayList<Room> tempRoomArrayList = new ArrayList<Room>();
        for (int i = 0; i < this.bedrooms.size() ; i++) {
            if(this.bedrooms.get(i).getNumberOfGuests() == 0) {
                tempRoomArrayList.add(this.bedrooms.get(i));
            }
        }
        this.emptyBedrooms = tempRoomArrayList;
    }

    private Room getEmptyRoom(){
        return this.emptyBedrooms.get(0);
    }

    public int getNumberOfEmptyRooms() {
        return this.emptyBedrooms.size();
    }

    public void checkInGuestToOtherRoom(Room otherRoom, Guest guestToCheckIn) {
        if (otherRoom.getRemainingCapacity() > 0) {
            otherRoom.checkInGuest(guestToCheckIn);
            guestToCheckIn.addRoom(otherRoom);
            this.guests.add(guestToCheckIn);
        }
    }
}
