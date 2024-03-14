package edu.ucalgary.oop;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

public class InquirerQueryServiceTest {
    private InquirerQueryService inquirerQueryService;
    private DisasterVictim disasterVictim;
    private ReliefService reliefService;
    private Database database;
    
    @Before
    public void setUp() {
        inquirerQueryService = new InquirerQueryService();
        disasterVictim = new DisasterVictim("Jane Alex", "2024-01-25");
        reliefService = new ReliefService();
        database = new Database();
    }

    @After
    public void tearDown() {
        inquirerQueryService = null;
    }

    /*
     * testObjectCreation => means testing InquirerQueryService object creation:
     * - What we need: To verify that an "InquirerQueryService" object is successfully created.
     * - Current result: The InquirerQueryService object is created.
     * - Expected Result: The test checks that the InquirerQueryService object is not null, confirming successful object creation.
     */
    @Test
    public void testObjectCreation() {
        assertNotNull("InquirerQueryService object should not be null", inquirerQueryService);
    }

    /*
     * testConstructor => means testing InquirerQueryService constructor with a database:
     * - What we need: To verify that an "InquirerQueryService" object is successfully created with a database.
     * - Current result: The InquirerQueryService object is created with the provided database.
     * - Expected Result: The test checks that the InquirerQueryService object's database matches the one provided in the constructor, confirming successful object creation with a database.
     */
    @Test
    public void testConstructor() {
        InquirerQueryService iqs = new InquirerQueryService(database);
        assertEquals("Database should be set in constructor", database, iqs.getDatabase());
    }

    /*
     * getDatabase => means testing the getDatabase method of the InquirerQueryService class:
     * - What we need: To verify that the "getDatabase" method returns the correct database.
     * - Current result: The getDatabase method returns the database that was set.
     * - Expected Result: The test checks that the returned database matches the one that was set, confirming that the getDatabase method works correctly.
     */
    @Test
    public void getDatabase() {
        inquirerQueryService.setDatabase(database);
        assertEquals("Database should be returned", database, inquirerQueryService.getDatabase());
    }

    /*
     * setDatabase => means testing the setDatabase method of the InquirerQueryService class:
     * - What we need: To verify that the "setDatabase" method correctly sets the database.
     * - Current result: The setDatabase method sets the database.
     * - Expected Result: The test checks that the database retrieved by getDatabase matches the one that was set, confirming that the setDatabase method works correctly.
     */
    @Test
    public void setDatabase() {
        inquirerQueryService.setDatabase(database);
        assertEquals("Database should be set", database, inquirerQueryService.getDatabase());
    }

    /*
     * logInquirerQuery => means testing the logInquirerQuery method of the InquirerQueryService class:
     * - What we need: To verify that the "logInquirerQuery" method correctly logs the inquirer query.
     * - Current result: The logInquirerQuery method logs the inquirer query.
     * - Expected Result: The test checks that the logged inquirer query retrieved by getInquirerQuery matches the one that was logged, confirming that the logInquirerQuery method works correctly.
     */
@Test
public void logInquirerQuery() {
    inquirerQueryService.logInquirerQuery(reliefService);
    assertEquals("Inquirer Query should be logged", reliefService, inquirerQueryService.getInquirerQuery().get(disasterVictim));
}
    @Test
    public void logInquirerQuery() {
        inquirerQueryService.logInquirerQuery(reliefService);
        assertEquals("Inquirer Query should be logged", reliefService, inquirerQueryService.getInquirerQuery().get(disasterVictim));
    }
    
    @Test
    public void removeInquirerQuery() {
        inquirerQueryService.logInquirerQuery(reliefService);
        inquirerQueryService.removeInquirerQuery(reliefService);
        assertNull("Inquirer Query should be removed", inquirerQueryService.getInquirerQuery());
    }

    @Test
    public void getInquirerQuery() {
        inquirerQueryService.logInquirerQuery(reliefService);
        assertEquals("Inquirer Query should be returned", reliefService, inquirerQueryService.getInquirerQuery(reliefService));
    }


    @Test
    public void searchVictims() {
        inquirerQueryService.searchVictims(disasterVictim);
        assertEquals("DisasterVictim should be searched", disasterVictim, inquirerQueryService.searchVictims(disasterVictim));
    }
}

