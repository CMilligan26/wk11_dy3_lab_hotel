import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {
    private Guest guest;
    private Room room;

    @Before
    public void before(){
        guest = new Guest();
        room = new Room("Laundry Room", 2);
    }

    @Test
    public void hasRoomKey(){
        guest.addRoom(room);
        assertEquals(room, guest.getRoom());
    }
}
