package edu.ucalgary.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReliefServiceTest {
    private ReliefService service;
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private Location lastKnownLocation;

    @BeforeEach
    public void setUp() {
        inquirer = new Inquirer("John", "Doe", "1234567890", "Information");
        missingPerson = new DisasterVictim("Jane", "2022-01-01");
        lastKnownLocation = new Location("Shelter", "123 Street");
        service = new ReliefService(inquirer, missingPerson, "2022-01-01", "Info provided", lastKnownLocation);
    }

    @Test
    public void testGetInquirer() {
        assertEquals(inquirer, service.getInquirer());
    }

    @Test
    public void testSetInquirer() {
        Inquirer newInquirer = new Inquirer("Joe", "Smith", "0987654321", "New information");
        service.setInquirer(newInquirer);
        assertEquals(newInquirer, service.getInquirer());
    }

    @Test
    public void testGetMissingPerson() {
        assertEquals(missingPerson, service.getMissingPerson());
    }

    @Test
    public void testSetMissingPerson() {
        DisasterVictim newMissingPerson = new DisasterVictim("Jill", "2022-02-02");
        service.setMissingPerson(newMissingPerson);
        assertEquals(newMissingPerson, service.getMissingPerson());
    }

    @Test
    public void testGetDateOfInquiry() {
        assertEquals("2022-01-01", service.getDateOfInquiry());
    }

    @Test
    public void testSetDateOfInquiry() {
        service.setDateOfInquiry("2022-02-02");
        assertEquals("2022-02-02", service.getDateOfInquiry());
    }

    @Test
    public void testSetDateOfInquiryInvalidFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.setDateOfInquiry("01-01-2022");
        });
    }

    @Test
    public void testGetInfoProvided() {
        assertEquals("Info provided", service.getInfoProvided());
    }

    @Test
    public void testSetInfoProvided() {
        service.setInfoProvided("New info provided");
        assertEquals("New info provided", service.getInfoProvided());
    }

    @Test
    public void testGetLastKnownLocation() {
        assertEquals(lastKnownLocation, service.getLastKnownLocation());
    }

    @Test
    public void testSetLastKnownLocation() {
        Location newLastKnownLocation = new Location("New Shelter", "456 Avenue");
        service.setLastKnownLocation(newLastKnownLocation);
        assertEquals(newLastKnownLocation, service.getLastKnownLocation());
    }

    @Test
    public void testGetLogDetails() {
        String expectedLogDetails = "Inquirer: John, Missing Person: Jane, Date of Inquiry: 2022-01-01, Info Provided: Info provided, Last Known Location: Shelter";
        assertEquals(expectedLogDetails, service.getLogDetails());
    }
}