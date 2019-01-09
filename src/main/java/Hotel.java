import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {
    private ArrayList<Guest> guests;
    private ArrayList<Room> rooms;
    private HashMap<Room, Integer> roomCapacities;

    public Hotel(){
        this.guests = new ArrayList<Guest>();
        this.rooms = new ArrayList<Room>();
        this.roomCapacities = new HashMap<Room, Integer>();
    }


    public int getNumberOfGuests() {
        return this.guests.size();
    }

    public int getNumberOfRooms() {
        return this.rooms.size();
    }

    public void addRoom(Room roomToAdd) {
        this.rooms.add(roomToAdd);
        this.updateRoomCapacities();
    }

    public void checkInGuest(Guest guestToCheckIn) {
        this.updateRoomCapacities();
        this.guests.add(guestToCheckIn);
        this.updateRoomCapacities();
    }

    public void checkOutGuest() {
        this.guests.remove(0);
        this.updateRoomCapacities();
    }

    private void updateRoomCapacities(){
        HashMap<Room, Integer> tempHash = new HashMap<Room, Integer>();
        for (int i = 0; i < this.rooms.size() ; i++) {
            int roomCapacity = this.rooms.get(i).getRemainingCapacity();
            tempHash.put(this.rooms.get(i), roomCapacity);
        }
        this.roomCapacities = tempHash;
    }

    private Room findFirstAvailableRoom(){
        Room availableRoom = null;
        for (int i = 0; i < this.rooms.size(); i++) {
            if (this.roomCapacities.get(this.rooms.get(i)) > 0) {
                availableRoom = this.rooms.get(i);
                break;
            }
        }
        return availableRoom;
    }



}
