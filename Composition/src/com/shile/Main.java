package com.shile;

public class Main {

	// Create a single room of a house using composition.
	// Think about the things that should be included in the room.
	// Maybe physical parts of the house but furniture as well
	// Add at least one method to access an object via a getter and
	// then that objects public method as you saw in the previous video
	// then add at least one method to hide the object e.g. not using a getter
	// but to access the object used in composition within the main class
	// like you saw in this video.

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(20, 20, 5);
	    Case theCase = new Case("220B", "dell", "240", dimensions);

	    Monitor theMonitor = new Monitor("27inch Beast", "Acer", 27, new Resolution(2540,1440));
	    MotherBoard theMotherBoard = new MotherBoard("BJ-200", "Asus", 4,6,"v2.44");

	    PC thePC = new PC(theCase, theMonitor, theMotherBoard);
	    thePC.powerUp();

	    Wall wall1 = new Wall("West");
	    Wall wall2 = new Wall("East");
	    Wall wall3 = new Wall("South");
	    Wall wall4 = new Wall("North");

	    Ceiling ceiling = new Ceiling(12,55);

	    Bed bed = new Bed("Morden", 4,3,2,1);
	    Lamp lamp = new Lamp("classic", false, 75);

	    Bedroom bedroom = new Bedroom("shile", wall1, wall2, wall3, wall4, ceiling, bed, lamp);

	    bedroom.makeBed();

	    bedroom.getLamp().turnOn();

    }
}
