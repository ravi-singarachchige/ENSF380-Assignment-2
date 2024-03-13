package edu.ucalgary.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedicalRecordTest {
    private MedicalRecord record;
    private Location location;

    @BeforeEach
    public void setUp() {
        location = new Location("Hospital", "123 Street");
        record = new MedicalRecord(location, "Treatment details", "2022-01-01");
    }

    @Test
    public void testGetLocation() {
        assertEquals(location, record.getLocation());
    }

    @Test
    public void testSetLocation() {
        Location newLocation = new Location("New Hospital", "456 Avenue");
        record.setLocation(newLocation);
        assertEquals(newLocation, record.getLocation());
    }

    @Test
    public void testGetTreatmentDetails() {
        assertEquals("Treatment details", record.getTreatmentDetails());
    }

    @Test
    public void testSetTreatmentDetails() {
        record.setTreatmentDetails("New treatment details");
        assertEquals("New treatment details", record.getTreatmentDetails());
    }

    @Test
    public void testGetDateOfTreatment() {
        assertEquals("2022-01-01", record.getDateOfTreatment());
    }

    @Test
    public void testSetDateOfTreatment() {
        record.setDateOfTreatment("2022-02-02");
        assertEquals("2022-02-02", record.getDateOfTreatment());
    }

    @Test
    public void testSetDateOfTreatmentInvalidFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            record.setDateOfTreatment("01-01-2022");
        });
    }
}