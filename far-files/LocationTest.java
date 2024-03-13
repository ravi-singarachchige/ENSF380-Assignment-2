package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class LocationTest {
    private Location location;
    private DisasterVictim victim;
    private Supply supply;

    @Before
    public void setUp() {
        // Initializing test objects before each test method
        location = new Location("Shelter A", "1234 Shelter Ave");
        victim = new DisasterVictim("John Doe", "2024-01-01");
        supply = new Supply("Water Bottle", 10);
    }

    // Helper method to check if a supply is in the list
    private boolean containsSupply(ArrayList<Supply> supplies, Supply supplyToCheck) {
        return supplies.contains(supplyToCheck);
    }

    /*
     * testObjectCreation:
     * - What we need: To verify that an "Location" object is successfully created.
     * - Current result: Location name is "Shelter A", address is
     * "1234 Shelter Ave".
     * - Expected Result: The test checks that the Location object is not null, sets
     * the name and address
     * to Shelter A and 1234 Shelter Ave respectively.
     */

    @Test
    public void testConstructor() {
        assertNotNull("Constructor should create a non-null Location object", location);
        assertEquals("Constructor should set the name correctly", "Shelter A", location.getName());
        assertEquals("Constructor should set the address correctly", "1234 Shelter Ave", location.getAddress());
    }

    /*
     * testGetName:
     * - What we need: To ensure the "getName()" method correctly returns the actual
     * Location name.
     * - Current result: "Shelter A".
     * - Expected result: "location.getName()" should return "Shelter A".
     */
    @Test
    public void testGetName() {
        assertEquals("getName should return the correct name", "Shelter A", location.getName());
    }

    /*
     * testSetName():
     * - What we need: To ensure the "setName()" method correctly updates the
     * Location name.
     * - Current result: "Shelter A".
     * - Expected result: "Shelter B".
     */

    @Test
    public void testSetName() {
        String newName = "Shelter B";
        location.setName(newName);
        assertEquals("setName should update the name of the location", newName, location.getName());
    }

    /*
     * testGetAddress():
     * - What we need: To ensure the "getAddress()" method correctly returns the
     * actual Location address.
     * - Current result: "1234 Shelter Ave".
     * - Expected result: "location.getAddress()" should return "1234 Shelter Ave".
     */
    @Test
    public void testGetAddress() {
        assertEquals("getAddress should return the correct address", "1234 Shelter Ave", location.getAddress());
    }

    /*
     * testSetAddress():
     * - What we need: To ensure the "setAddress()" method correctly updates the
     * Location address.
     * - Current result: "1234 Shelter Ave".
     * - Expected result: "4321 Shelter Blvd".
     */
    @Test
    public void testSetAddress() {
        String newAddress = "4321 Shelter Blvd";
        location.setAddress(newAddress);
        assertEquals("setAddress should update the address of the location", newAddress, location.getAddress());
    }

    /*
     * testAddOccupant():
     * - What we need: To ensure the "addOccupant()" method correctly adds a
     * disaster victim to the occupants list.
     * - Current result: The victim is not in the occupants list.
     * - Expected result: The victim should be in the occupants list.
     */
    @Test
    public void testAddOccupant() {
        location.addOccupant(victim);
        assertTrue("addOccupant should add a disaster victim to the occupants list",
                location.getOccupants().contains(victim));
    }

    /*
     * testRemoveOccupant():
     * - What we need: To ensure the "removeOccupant()" method correctly removes a
     * disaster victim from the occupants list.
     * - Current result: The victim is in the occupants list.
     * - Expected result: The victim should not be in the occupants list.
     */
    @Test
    public void testRemoveOccupant() {
        location.addOccupant(victim); // Ensure the victim is added first
        location.removeOccupant(victim);
        assertFalse("removeOccupant should remove the disaster victim from the occupants list",
                location.getOccupants().contains(victim));
    }

    /*
     * testSetAndGetOccupants():
     * - What we need: To ensure the "setOccupants()" method correctly replaces the
     * occupants list with a new list.
     * - Current result: The occupants list does not contain the new occupants list.
     * - Expected result: The occupants list should contain the new occupants list.
     */
    @Test
    public void testSetAndGetOccupants() {
        ArrayList<DisasterVictim> newOccupants = new ArrayList<>();
        newOccupants.add(victim);
        location.setOccupants(newOccupants);
        assertTrue("setOccupants should replace the occupants list with the new list",
                location.getOccupants().containsAll(newOccupants));
    }

    /*
     * testAddSupply():
     * - What we need: To ensure the "addSupply()" method correctly adds a supply to
     * the supplies list.
     * - Current result: The supply is not in the supplies list.
     * - Expected result: The supply should be in the supplies list.
     */
    @Test
    public void testAddSupply() {
        location.addSupply(supply);
        assertTrue("addSupply should add a supply to the supplies list",
                containsSupply(location.getSupplies(), supply));
    }

    /*
     * testRemoveSupply():
     * - What we need: To ensure the "removeSupply()" method correctly removes a
     * supply from the supplies list.
     * - Current result: The supply is in the supplies list.
     * - Expected result: The supply should not be in the supplies list.
     */
    @Test
    public void testRemoveSupply() {
        location.addSupply(supply); // Ensure the supply is added first
        location.removeSupply(supply);
        assertFalse("removeSupply should remove the supply from the supplies list",
                containsSupply(location.getSupplies(), supply));
    }

    /*
     * testSetAndGetSupplies():
     * - What we need: To ensure the "setSupplies()" method correctly replaces the
     * supplies list with a new list and
     * "getSupplies()" correctly returns the supplies list.
     * - Current result: The supplies list does not contain the new supplies list.
     * - Expected result: The supplies list should contain the new supplies list.
     */
    @Test
    public void testSetAndGetSupplies() {
        ArrayList<Supply> newSupplies = new ArrayList<>();
        newSupplies.add(supply);
        location.setSupplies(newSupplies);
        assertTrue("setSupplies should replace the supplies list with the new list",
                containsSupply(location.getSupplies(), supply));
    }
}
