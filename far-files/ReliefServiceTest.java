/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024
Licensed under GPL v3
See LICENSE.txt for more information.
*/
package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReliefServiceTest {
    private ReliefService reliefService;
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private Location lastKnownLocation;
    private String validDate = "2024-02-10";
    private String invalidDate = "2024/02/10";
    private String expectedInfoProvided = "Looking for family member";
    private String expectedLogDetails = "Inquirer: John, Missing Person: Jane Alex, Date of Inquiry: 2024-02-10, Info Provided: Looking for family member, Last Known Location: University of Calgary";

    @Before
    public void setUp() {
        // Assuming Inquirer, DisasterVictim, and Location have constructors as implied
        inquirer = new Inquirer("John", "Alex", "1", "1234567890", "Looking for family member");
        missingPerson = new DisasterVictim("Jane Alex", "2024-01-25");
        lastKnownLocation = new Location("University of Calgary", "2500 University Dr NW");
        reliefService = new ReliefService(inquirer, missingPerson, validDate, expectedInfoProvided, lastKnownLocation);
    }

    /*
     * testObjectCreation:
     * - What we need: To verify that an "ReliefService" object is successfully
     * created.
     * - Current result: ReliefService object is not null.
     * - Expected Result: The test checks that the ReliefService object is not null,
     * confirming successful object creation.
     */

    @Test
    public void testObjectCreation() {
        assertNotNull("ReliefService object should not be null", reliefService);
    }

    /*
     * testGetInquirer:
     * - What we need: To ensure the "getInquirer()" method correctly returns the
     * actual inquirer.
     * - Current result: inquirer
     * - Expected result: "reliefService.getInquirer()" should return inquirer.
     */
    @Test
    public void testGetInquirer() {
        assertEquals("Inquirer should match the one set in setup", inquirer, reliefService.getInquirer());
    }

    /*
     * testGetMissingPerson:
     * - What we need: To ensure the "getMissingPerson()" method correctly returns the
     * actual missing person.
     * - Current result: missingPerson
     * - Expected result: "reliefService.getMissingPerson()" should return missingPerson.
     */
    @Test
    public void testGetMissingPerson() {
        assertEquals("Missing person should match the one set in setup", missingPerson,
                reliefService.getMissingPerson());
    }

    /*
        * testGetDateOfInquiry:
        * - What we need: To ensure the "getDateOfInquiry()" method correctly returns the
        * actual date of inquiry.
        * - Current result: validDate
        * - Expected result: "reliefService.getDateOfInquiry()" should return validDate.
        */
    @Test
    public void testGetDateOfInquiry() {
        assertEquals("Date of inquiry should match the one set in setup", validDate, reliefService.getDateOfInquiry());
    }

    /*
     * testGetInfoProvided:
     * - What we need: To ensure the "getInfoProvided()" method correctly returns the
     * actual info provided.
     * - Current result: expectedInfoProvided
     * - Expected result: "reliefService.getInfoProvided()" should return expectedInfoProvided.
     */
    @Test
    public void testGetInfoProvided() {
        assertEquals("Info provided should match the one set in setup", expectedInfoProvided,
                reliefService.getInfoProvided());
    }

    /*
     * testGetLastKnownLocation:
     * - What we need: To ensure the "getLastKnownLocation()" method correctly returns
     * the actual last known location.
     * - Current result: lastKnownLocation
     * - Expected result: "reliefService.getLastKnownLocation()" should return
     * lastKnownLocation.
     */
    @Test
    public void testGetLastKnownLocation() {
        assertEquals("Last known location should match the one set in setup", lastKnownLocation,
                reliefService.getLastKnownLocation());
    }

    /*
     * testSetDateOfInquiryWithValidDate():
     * - What we need: To ensure the "setDateOfInquiry()" method correctly updates the
     * inquirer's date of inquiry.
     * - Current result: "2024-02-10"
     * - Expected result: "reliefService.getDateOfInquiry()" should return "2024-02-10".
     */

    @Test
    public void testSetDateOfInquiryWithValidDate() {
        reliefService.setDateOfInquiry(validDate);
        assertEquals("Setting a valid date should update the date of inquiry", validDate,
                reliefService.getDateOfInquiry());
    }

    /*
     * testSetDateOfInquiryWithInvalidDate():
     * - What we need: To ensure the "setDateOfInquiry()" method correctly updates the
     * inquirer's date of inquiry.
     * - Current result: "2024/02/10"
     * - Expected result: IllegalArgumentException should be thrown due to invalid date
     * format.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfInquiryWithInvalidDate() {
        reliefService.setDateOfInquiry(invalidDate); // This should throw IllegalArgumentException due to invalid format
    }

    /*
     * testGetLogDetails():
     * - What we need: To ensure the "getLogDetails()" method correctly returns the
     * actual log details.
     * - Current result: "Inquirer: John, Missing Person: Jane Alex, Date of Inquiry:
     * 2024-02-10, Info Provided: Looking for family member, Last Known Location:
     * University of Calgary"
     * - Expected result: "reliefService.getLogDetails()" should be equal to
     * "Inquirer: John, Missing Person: Jane Alex, Date of Inquiry: 2024-02-10, Info
     * Provided: Looking for family member, Last Known Location: University of
     * Calgary".
     */ 
    @Test
    public void testGetLogDetails() {
        assertEquals("Log details should match the expected format", expectedLogDetails, reliefService.getLogDetails());
    }
}
