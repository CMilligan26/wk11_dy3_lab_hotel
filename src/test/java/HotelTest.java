import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelTest {
    Hotel hotel;
    Guest guest;
    Room bedroom;
    Room diningRoom;

    @Before
    public void before(){
        hotel = new Hotel();
        guest = new Guest();
        bedroom = new Room("Bedroom", 1, "Single" );
        diningRoom = new Room("Dining Room", 20);
        hotel.addRoom(bedroom);
        hotel.addRoom(diningRoom);
    }

    @Test
    public void getNumberOfGuests(){
        assertEquals(0, hotel.getNumberOfGuests());
    }

    @Test
    public void getNumberOfRooms(){
        assertEquals(2, hotel.getNumberOfRooms());
    }

    @Test
    public void canAddRoom(){
        assertEquals(2, hotel.getNumberOfRooms());
    }

    @Test
    public void canCheckGuestIntoBedroom(){
        hotel.checkInGuestToBedroom(guest);
        assertEquals(1, hotel.getNumberOfGuests());
    }

    @Test
    public void canCheckGuestIntoOtherRoom(){
        hotel.checkInGuestToOtherRoom(diningRoom, guest);
        assertEquals(1, hotel.getNumberOfGuests());
    }

    @Test
    public void cannotCheckGuestIntoBedroom(){
        for (int i = 0; i < bedroom.getCapacity()+1; i++) {
            hotel.checkInGuestToBedroom(guest);
        }
        assertEquals(1, hotel.getNumberOfGuests());
    }

    @Test
    public void cannotCheckGuestIntoOtherRoom(){
        for (int i = 0; i < diningRoom.getCapacity()+1; i++) {
            hotel.checkInGuestToOtherRoom(diningRoom,guest);
        }
        assertEquals(20, hotel.getNumberOfGuests());
    }

    @Test
    public void canCheckOutGuestFromBedroom(){
        hotel.checkInGuestToBedroom(guest);
        assertEquals(1, hotel.getNumberOfGuests());
        hotel.checkOutGuest(guest);
        assertEquals(0, hotel.getNumberOfGuests());
    }

    @Test
    public void canCheckOutGuestFromOtherRoom(){
        hotel.checkInGuestToOtherRoom(diningRoom, guest);
        assertEquals(1, hotel.getNumberOfGuests());
        hotel.checkOutGuest(guest);
        assertEquals(0, hotel.getNumberOfGuests());
    }

    @Test
    public void getNumberOfEmptyBedrooms(){
        assertEquals(1, hotel.getNumberOfEmptyRooms());
    }

}
