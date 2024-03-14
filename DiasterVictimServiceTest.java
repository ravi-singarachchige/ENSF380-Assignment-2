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

    /*
     * testObjectCreation => means testing DisasterVictimService object creation:
     * - What we need: To verify that a "DisasterVictimService" object is successfully created.
     * - Current result: The DisasterVictimService object is created.
     * - Expected Result: The test checks that the DisasterVictimService object is not null, confirming successful object creation.
     */
    @Test
    public void testObjectCreation() {
        assertNotNull("DisasterVictimService object should not be null", disasterVictimService);
    }

    /*
     * enterVictimToDatabase => means testing entering a DisasterVictim to the database:
     * - What we need: To verify that a "DisasterVictim" object is successfully added to the database.
     * - Current result: The DisasterVictim object is added to the database.
     * - Expected Result: The test checks that the DisasterVictim object is in the database, confirming successful addition to the database.
     */
    @Test
    public void enterVictimToDatabase() {
        disasterVictimService.enterVictimToDatabase(disasterVictim);
        assertEquals("DisasterVictim should be added to the database", disasterVictim, disasterVictimService.getVictimFromDatabase("Jane Alex"));
    }

    /*
     * getVictimFromDatabase => means testing retrieving a DisasterVictim from the database:
     * - What we need: To verify that a "DisasterVictim" object is successfully retrieved from the database.
     * - Current result: The DisasterVictim object is retrieved from the database.
     * - Expected Result: The test checks that the retrieved DisasterVictim object matches the one that was added, confirming successful retrieval from the database.
     */
    @Test
    public void getVictimFromDatabase() {
        disasterVictimService.enterVictimToDatabase(disasterVictim);
        assertEquals("DisasterVictim should be added to the database", disasterVictim, disasterVictimService.getVictimFromDatabase("Jane Alex"));
    }

    /*
     * removeVictimFromDatabase => means testing removing a DisasterVictim from the database:
     * - What we need: To verify that a "DisasterVictim" object is successfully removed from the database.
     * - Current result: The DisasterVictim object is removed from the database.
     * - Expected Result: The test checks that the DisasterVictim object is no longer in the database, confirming successful removal from the database.
     */
    @Test
    public void removeVictimFromDatabase() {
        disasterVictimService.enterVictimToDatabase(disasterVictim);
        disasterVictimService.removeVictimFromDatabase("Jane Alex");
        assertNull("DisasterVictim should be removed from the database", disasterVictimService.getVictimFromDatabase("Jane Alex"));
    }
}