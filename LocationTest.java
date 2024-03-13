package edu.ucalgary.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class LocationTest {
    private Location location;

    @BeforeEach
    public void setUp() {
        location = new Location("Shelter", "123 Street");
    }

    @Test
    public void testGetName() {
        assertEquals("Shelter", location.getName());
    }

    @Test
    public void testSetName() {
        location.setName("New Shelter");
        assertEquals("New Shelter", location.getName());
    }

    @Test
    public void testGetAddress() {
        assertEquals("123 Street", location.getAddress());
    }

    @Test
    public void testSetAddress() {
        location.setAddress("456 Avenue");
        assertEquals("456 Avenue", location.getAddress());
    }

    @Test
    public void testGetOccupants() {
        assertTrue(location.getOccupants().isEmpty());
    }

    @Test
    public void testSetOccupants() {
        ArrayList<DisasterVictim> occupants = new ArrayList<>();
        occupants.add(new DisasterVictim("John", "2022-01-01"));
        location.setOccupants(occupants);
        assertEquals(1, location.getOccupants().size());
        assertEquals("John", location.getOccupants().get(0).getName());
    }

    @Test
    public void testAddOccupant() {
        DisasterVictim victim = new DisasterVictim("John", "2022-01-01");
        location.addOccupant(victim);
        assertEquals(1, location.getOccupants().size());
        assertEquals(victim, location.getOccupants().get(0));
    }

    @Test
    public void testRemoveOccupant() {
        DisasterVictim victim = new DisasterVictim("John", "2022-01-01");
        location.addOccupant(victim);
        location.removeOccupant(victim);
        assertTrue(location.getOccupants().isEmpty());
    }

    @Test
    public void testGetSupplies() {
        assertTrue(location.getSupplies().isEmpty());
    }

    @Test
    public void testSetSupplies() {
        ArrayList<Supply> supplies = new ArrayList<>();
        supplies.add(new Supply("Water", 1));
        location.setSupplies(supplies);
        assertEquals(1, location.getSupplies().size());
        assertEquals("Water", location.getSupplies().get(0).getName());
    }

    @Test
    public void testAddSupply() {
        Supply supply = new Supply("Water", 1);
        location.addSupply(supply);
        assertEquals(1, location.getSupplies().size());
        assertEquals(supply, location.getSupplies().get(0));
    }

    @Test
    public void testRemoveSupply() {
        Supply supply = new Supply("Water", 1);
        location.addSupply(supply);
        location.removeSupply(supply);
        assertTrue(location.getSupplies().isEmpty());
    }
}