package edu.ucalgary.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SupplyTest {
    private Supply supply;

    @BeforeEach
    public void setUp() {
        supply = new Supply("Water", 10);
    }

    @Test
    public void testGetType() {
        assertEquals("Water", supply.getType());
    }

    @Test
    public void testSetType() {
        supply.setType("Food");
        assertEquals("Food", supply.getType());
    }

    @Test
    public void testGetQuantity() {
        assertEquals(10, supply.getQuantity());
    }

    @Test
    public void testSetQuantity() {
        supply.setQuantity(20);
        assertEquals(20, supply.getQuantity());
    }
}