public class Room {
    private String type;
    private int roomNumber;
    private String size;
    private int capacity;

    public Room(String typeOfRoom, int capacity){
        this.type = typeOfRoom;
    }

    public Room(String typeOfRoom, int roomNumber, String sizeOfRoom){
        this.type = typeOfRoom;
        this.roomNumber = roomNumber;
        this.size = sizeOfRoom;
        this.getBedroomCapacity(sizeOfRoom);
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
}
