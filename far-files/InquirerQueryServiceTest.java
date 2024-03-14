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

    @Test
    public void testObjectCreation() {
        assertNotNull("InquirerQueryService object should not be null", inquirerQueryService);
    }

    @Test
    public void testConstructor() {
        InquirerQueryService iqs = new InquirerQueryService(database);
        assertEquals("Database should be set in constructor", database, iqs.getDatabase());
    }

    @Test
    public void getDatabase() {
        inquirerQueryService.setDatabase(database);
        assertEquals("Database should be returned", database, inquirerQueryService.getDatabase());
    }

    @Test
    public void setDatabase() {
        inquirerQueryService.setDatabase(database);
        assertEquals("Database should be set", database, inquirerQueryService.getDatabase());
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

