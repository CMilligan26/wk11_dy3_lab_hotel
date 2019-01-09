import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomTest {
    Room room;
    Guest guest;

    @Before
    public void before(){
        room = new Room("Bedroom",1, "Single");
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
    public void hasCapacity(){
        assertEquals(1, room.getCapacity());
    }

    @Test
    

}
