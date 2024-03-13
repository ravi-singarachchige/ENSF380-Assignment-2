package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;

public class MedicalRecordTest {

    Location expectedLocation = new Location("ShelterA", "140 8 Ave NW ");
    private String expectedTreatmentDetails = "Broken arm treated";
    private String expectedDateOfTreatment = "2024-01-19";
    private String validDateOfTreatment = "2024-02-04";
    private String inValidDateOfTreatment = "2024/02/04";
    MedicalRecord medicalRecord = new MedicalRecord(expectedLocation, expectedTreatmentDetails,
            expectedDateOfTreatment);

    /*
     * testObjectCreation => means testing MedicalRecord constructor:
     * - What we need: To verify that an "MedicalRecord" object is successfully
     * created.
     * - Current result: The location is "ShelterA", The treatment details is
     * "Broken arm treated", The date of treatment is "2024-01-19".
     * - Expected Result: The test checks that the MedicalRecord object is not null,
     * confirming successful object creation.
     */

    @Test
    public void testObjectCreation() {
        assertNotNull(medicalRecord);
    }

    /*
     * testGetLocation:
     * - What we need: To ensure the "getLocation()" method correctly returns the
     * actual Location.
     * - Current result: "ShelterA".
     * - Expected result: "medicalRecord.getLocation()" should return "ShelterA".
     */

    @Test
    public void testGetLocation() {
        assertEquals("getLocation should return the correct Location", expectedLocation, medicalRecord.getLocation());
    }

    /*
     * testSetLocation():
     * - What we need: To ensure the "setLocation()" method correctly updates the
     * Location.
     * - Current/current result: "Shelter
     * - Expected result: "Shelter B".
     */

    @Test
    public void testSetLocation() {
        Location newExpectedLocation = new Location("Shelter B", "150 8 Ave NW ");
        medicalRecord.setLocation(newExpectedLocation);
        assertEquals("setLocation should update the Location", newExpectedLocation.getName(),
                medicalRecord.getLocation().getName());
    }

    /*
     * testGetTreatmentDetails:
     * - What we need: To ensure the "getTreatmentDetails()" method correctly
     * returns the actual treatment details.
     * - Current result: "Broken arm treated".
     * - Expected result: "medicalRecord.getTreatmentDetails()" should return
     * "Broken arm treated".
     */

    @Test
    public void testGetTreatmentDetails() {
        assertEquals("getTreatmentDetails should return the correct treatment details", expectedTreatmentDetails,
                medicalRecord.getTreatmentDetails());
    }

    /*
     * testSetTreatmentDetails():
     * - What we need: To ensure the "setTreatmentDetails()" method correctly
     * updates the treatment details.
     * - Current/current result: "Broken arm treated".
     * - Expected result: "No surgery required".
     */
    @Test
    public void testSetTreatmentDetails() {
        String newExpectedTreatment = "No surgery required";
        medicalRecord.setTreatmentDetails(newExpectedTreatment);
        assertEquals("setTreatmentDetails should update the treatment details", newExpectedTreatment,
                medicalRecord.getTreatmentDetails());
    }

    /*
     * testGetDateOfTreatment:
     * - What we need: To ensure the "getDateOfTreatment()" method correctly returns
     * the actual date of treatment.
     * - Current result: "2024-01-19".
     * - Expected result: "medicalRecord.getDateOfTreatment()" should return
     * "2024-01-19".
     */
    @Test
    public void testGetDateOfTreatment() {
        assertEquals("getDateOfTreatment should return the correct date of treatment", expectedDateOfTreatment,
                medicalRecord.getDateOfTreatment());
    }

    /*
     * testSetDateOfTreatment():
     * - What we need: To ensure the "setDateOfTreatment()" method correctly updates
     * the date of treatment.
     * - Current result: "2024-01-19".
     * - Expected result: "2024-02-05".
     */
    @Test
    public void testSetDateOfTreatment() {
        String newExpectedDateOfTreatment = "2024-02-05";
        medicalRecord.setDateOfTreatment(newExpectedDateOfTreatment);
        assertEquals("setDateOfTreatment should update date of treatment", newExpectedDateOfTreatment,
                medicalRecord.getDateOfTreatment());
    }

    /*
     * testSetDateOfTreatmentWithValidFormat():
     * - What we need: To ensure the "setDateOfTreatment()" method correctly updates
     * the date of treatment with a valid format.
     * - Current result: "2024-01-19".
     * - Expected result: "2024-02-04".
     */
    @Test
    public void testSetDateOfTreatmentWithValidFormat() {

        medicalRecord.setDateOfTreatment(validDateOfTreatment); // Should not throw an exception
    }

    /*
     * testSetDateOfTreatmentWithInvalidFormat():
     * - What we need: To ensure that "setDateOfTreatment()" method throws an
     * IllegalArgumentException with invalid date format.
     * - Current/current result: "2024-01-19".
     * - Expected result: "IllegalArgumentException".
     */
    @Test
    public void testSetDateOfBirthWithInvalidFormat() {
        boolean correctValue = false;
        String failureReason = "no exception was thrown";

        try {
            medicalRecord.setDateOfTreatment(inValidDateOfTreatment); // Should throw IllegalArgumentException
        } catch (IllegalArgumentException e) {
            correctValue = true;
        } catch (Exception e) {
            failureReason = "the wrong type of exception was thrown";
        }

        String message = "setDateOfTreatment() should throw an IllegalArgumentException with invalid date format '"
                + inValidDateOfTreatment + "' but " + failureReason + ".";
        assertTrue(message, correctValue);
    }

    /*
     * testSetDateOfTreatmentWithNotADate():
     * - What we need: To ensure that "setDateOfTreatment()" method throws an
     * IllegalArgumentException with invalid non-date input.
     * - Current/current result: "2024-01-19".
     * - Expected result: "IllegalArgumentException".
     */
    @Test
    public void testSetDateOfBirthWithNotADate() {
        boolean correctValue = false;
        String failureReason = "no exception was thrown";

        try {
            medicalRecord.setDateOfTreatment(expectedTreatmentDetails); // Should throw IllegalArgumentException
        } catch (IllegalArgumentException e) {
            correctValue = true;
        } catch (Exception e) {
            failureReason = "the wrong type of exception was thrown";
        }

        String message = "setDateOfTreatment() should throw an IllegalArgumentException with invalid non-date input '"
                + inValidDateOfTreatment + "' but " + failureReason + ".";
        assertTrue(message, correctValue);
    }
}
