package edu.ucalgary.oop;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

public class DiasterVictimServiceTest {
    private DisasterVictimService disasterVictimService;
    private DisasterVictim disasterVictim;
    
    @Before
    public void setUp() {
        disasterVictim = new DisasterVictim("Jane Alex", "2024-01-25");
        disasterVictimService = new DisasterVictimService();
    }

    @After
    public void tearDown() {
        disasterVictimService = null;
    }

    @Test
    public void testObjectCreation() {
        assertNotNull("DisasterVictimService object should not be null", disasterVictimService);
    }

    
    @Test
    public void enterVictimToDatabase() {
        disasterVictimService.enterVictimToDatabase(disasterVictim);
        assertEquals("DisasterVictim should be added to the database", disasterVictim, disasterVictimService.getVictimFromDatabase("Jane Alex"));
    }

    @Test
    public void getVictimFromDatabase() {
        disasterVictimService.enterVictimToDatabase(disasterVictim);
        assertEquals("DisasterVictim should be added to the database", disasterVictim, disasterVictimService.getVictimFromDatabase("Jane Alex"));
    }

    @Test
    public void removeVictimFromDatabase() {
        disasterVictimService.enterVictimToDatabase(disasterVictim);
        disasterVictimService.removeVictimFromDatabase("Jane Alex");
        assertNull("DisasterVictim should be removed from the database", disasterVictimService.getVictimFromDatabase("Jane Alex"));
    }
}
