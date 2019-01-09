import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomTest {
    Room room;
    Room diningRoom;
    Guest guest;

    @Before
    public void before(){
        room = new Room("Bedroom",1, "Single");
        diningRoom = new Room("Dining Room",20);
        guest = new Guest();
    }

    @Test
    public void hasType(){
        assertEquals("Bedroom", room.getType());
    }

    @Test
    public void canHaveRoomNumber(){
        assertEquals(1, room.getRoomNumber());
    }

    @Test
    public void canHaveSize(){
        assertEquals("Single", room.getSize());
    }

    @Test
    public void bedroomHasCapacity(){
        assertEquals(1, room.getCapacity());
    }

    @Test
    public void otherRoomHasCapacity(){
        assertEquals(20, diningRoom.getCapacity());
    }

    @Test
    public void canGetNumberOfGuests(){
        assertEquals(0, room.getNumberOfGuests());
    }

    @Test
    public void canCheckInGuestToRoom(){
        room.checkInGuest(guest);
        assertEquals(1, room.getNumberOfGuests());
    }

    @Test
    public void canCheckRemainingCapacityInBedroom(){
        room.checkInGuest(guest);
        assertEquals(0, room.getRemainingCapacity());
    }

    @Test
    public void canCheckRemainingCapacityInOtherRoom(){
        diningRoom.checkInGuest(guest);
        assertEquals(19, diningRoom.getRemainingCapacity());
    }

    @Test
    public void canCheckOutGuest(){
        room.checkInGuest(guest);
        assertEquals(1, room.getNumberOfGuests());
        room.checkOutGuest();
        assertEquals(0, room.getNumberOfGuests());
    }

    @Test
    public void cannotCheckOutGuestIfNoGuests(){
        room.checkInGuest(guest);
        room.checkOutGuest();
        assertEquals(0, room.getNumberOfGuests());
        room.checkOutGuest();
        assertEquals(0, room.getNumberOfGuests());
    }


}
