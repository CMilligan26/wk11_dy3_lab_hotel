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
    public void canCheckGuestIn(){
        hotel.checkInGuest(guest);
        assertEquals(1, hotel.getNumberOfGuests());
    }

    @Test
    public void canCheckOutGuest(){
        hotel.checkInGuest(guest);
        assertEquals(1, hotel.getNumberOfGuests());
        hotel.checkOutGuest();
        assertEquals(0, hotel.getNumberOfGuests());
    }

}
