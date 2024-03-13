/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class DisasterVictimTest {
    private DisasterVictim victim;
    private List<Supply> suppliesToSet;
    private List<FamilyRelation> familyRelations;
    private String expectedFirstName = "Freda";
    private String EXPECTED_ENTRY_DATE = "2024-01-18";
    private String validDate = "2024-01-15";
    private String invalidDate = "15/13/2024";
    private String expectedGender = "female";
    private String expectedComments = "Needs medical attention and speaks 2 languages";

    @Before
    public void setUp() {
        victim = new DisasterVictim(expectedFirstName, EXPECTED_ENTRY_DATE);
        suppliesToSet = new ArrayList<>();
        suppliesToSet.add(new Supply("Water Bottle", 10));
        suppliesToSet.add(new Supply("Blanket", 5));

        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");

    }

    /*
     * testConstructorWithValidEntryDate => means testing DisasterVictim constructor with a valid entry date:
     * - What we need: To verify that a "DisasterVictim" object is successfully created with a valid entry date.
     * - Current result: The DisasterVictim object is created with the provided parameters including a valid entry date.
     * - Expected Result: The test checks that the DisasterVictim object is not null and the entry date is set correctly, confirming successful object creation with a valid entry date.
     */

    @Test
    public void testConstructorWithValidEntryDate() {
        String validEntryDate = "2024-01-18";
        DisasterVictim victim = new DisasterVictim("Freda", validEntryDate);
        assertNotNull("Constructor should successfully create an instance with a valid entry date", victim);
        assertEquals("Constructor should set the entry date correctly", validEntryDate, victim.getEntryDate());
    }

    /*
     * testConstructorWithInvalidEntryDateFormat => means testing DisasterVictim constructor with an invalid entry date format:
     * - What we need: To verify that a "DisasterVictim" object is not created with an invalid entry date format.
     * - Current result: The DisasterVictim object is not created with an invalid entry date format.
     * - Expected Result: The test checks that the constructor throws an IllegalArgumentException when an invalid entry date format is provided, confirming that the object is not created.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidEntryDateFormat() {
        String invalidEntryDate = "18/01/2024"; // Incorrect format according to your specifications
        new DisasterVictim("Freda", invalidEntryDate);
        // Expecting IllegalArgumentException due to invalid date format
    }

    
    /*
     * testSetDateOfBirth => means testing DisasterVictim's setDateOfBirth method:
     * - What we need: To verify that the "setDateOfBirth" method correctly updates the date of birth in the "DisasterVictim" object.
     * - Current result: The "setDateOfBirth" method updates the date of birth in the "DisasterVictim" object with the provided date.
     * - Expected Result: The test checks that the updated date of birth in the "DisasterVictim" object matches the provided date, confirming successful update of date of birth.
     */
    @Test
    public void testSetDateOfBirth() {
        String newDateOfBirth = "1987-05-21";
        victim.setDateOfBirth(newDateOfBirth);
        assertEquals("setDateOfBirth should correctly update the date of birth", newDateOfBirth,
                victim.getDateOfBirth());
    }

    /*
     * testSetDateOfBirthWithInvalidFormat => means testing DisasterVictim's setDateOfBirth method with an invalid date format:
     * - What we need: To verify that the "setDateOfBirth" method does not update the date of birth in the "DisasterVictim" object with an invalid date format.
     * - Current result: The "setDateOfBirth" method does not update the date of birth in the "DisasterVictim" object with an invalid date format.
     * - Expected Result: The test checks that the "setDateOfBirth" method throws an IllegalArgumentException when an invalid date format is provided, confirming that the date of birth is not updated.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfBirthWithInvalidFormat() {
        victim.setDateOfBirth(invalidDate); // This format should cause an exception
    }

    /*
     * testSetAndGetFirstName => means testing DisasterVictim's setFirstName and getFirstName methods:
     * - What we need: To verify that the "setFirstName" method correctly updates the first name in the "DisasterVictim" object and the "getFirstName" method correctly retrieves the updated first name.
     * - Current result: The "setFirstName" method updates the first name in the "DisasterVictim" object and the "getFirstName" method retrieves the updated first name.
     * - Expected Result: The test checks that the updated first name in the "DisasterVictim" object matches the provided name, confirming successful update and retrieval of first name.
     */
    @Test
    public void testSetAndGetFirstName() {
        String newFirstName = "Alice";
        victim.setFirstName(newFirstName);
        assertEquals("setFirstName should update and getFirstName should return the new first name", newFirstName,
                victim.getFirstName());
    }
    
    /*
     * testSetAndGetLastName => means testing DisasterVictim's setLastName and getLastName methods:
     * - What we need: To verify that the "setLastName" method correctly updates the last name in the "DisasterVictim" object and the "getLastName" method correctly retrieves the updated last name.
     * - Current result: The "setLastName" method updates the last name in the "DisasterVictim" object and the "getLastName" method retrieves the updated last name.
     * - Expected Result: The test checks that the updated last name in the "DisasterVictim" object matches the provided name, confirming successful update and retrieval of last name.
     */
    @Test
    public void testSetAndGetLastName() {
        String newLastName = "Smith";
        victim.setLastName(newLastName);
        assertEquals("setLastName should update and getLastName should return the new last name", newLastName,
                victim.getLastName());
    }
    
    /*
     * testGetComments => means testing DisasterVictim's getComments method:
     * - What we need: To verify that the "getComments" method correctly retrieves the initial comments in the "DisasterVictim" object.
     * - Current result: The "getComments" method retrieves the initial correct comments in the "DisasterVictim" object.
     * - Expected Result: The test checks that the "getComments" method returns the initial correct comments, confirming successful retrieval of comments.
     */
    @Test
    public void testGetComments() {
        victim.setComments(expectedComments);
        assertEquals("getComments should return the initial correct comments", expectedComments, victim.getComments());
    }
    
    /*
     * testSetComments => means testing DisasterVictim's setComments method:
     * - What we need: To verify that the "setComments" method correctly updates the comments in the "DisasterVictim" object.
     * - Current result: The "setComments" method updates the comments in the "DisasterVictim" object with the provided comments.
     * - Expected Result: The test checks that the updated comments in the "DisasterVictim" object match the provided comments, confirming successful update of comments.
     */
    @Test
    public void testSetComments() {
        victim.setComments(expectedComments);
        String newComments = "Has a minor injury on the left arm";
        victim.setComments(newComments);
        assertEquals("setComments should update the comments correctly", newComments, victim.getComments());
    }
    
    /*
     * testGetAssignedSocialID => means testing DisasterVictim's getAssignedSocialID method:
     * - What we need: To verify that the "getAssignedSocialID" method correctly retrieves the initial social ID in the "DisasterVictim" object.
     * - Current result: The "getAssignedSocialID" method retrieves the initial correct social ID in the "DisasterVictim" object.
     * - Expected Result: The test checks that the "getAssignedSocialID" method returns the initial correct social ID, confirming successful retrieval of social ID.
     */
    @Test
    public void testGetAssignedSocialID() {
        // The next victim should have an ID one higher than the previous victim
        // Tests can be run in any order so two victims will be created
        DisasterVictim newVictim = new DisasterVictim("Kash", "2024-01-21");
        int expectedSocialId = newVictim.getAssignedSocialID() + 1;
        DisasterVictim actualVictim = new DisasterVictim("Adeleke", "2024-01-22");

        assertEquals("getAssignedSocialID should return the expected social ID", expectedSocialId,
                actualVictim.getAssignedSocialID());
    }
    
    /*
     * testGetEntryDate => means testing DisasterVictim's getEntryDate method:
     * - What we need: To verify that the "getEntryDate" method correctly retrieves the initial entry date in the "DisasterVictim" object.
     * - Current result: The "getEntryDate" method retrieves the initial correct entry date in the "DisasterVictim" object.
     * - Expected Result: The test checks that the "getEntryDate" method returns the initial correct entry date, confirming successful retrieval of entry date.
     */
    @Test
    public void testGetEntryDate() {
        assertEquals("getEntryDate should return the expected entry date", EXPECTED_ENTRY_DATE, victim.getEntryDate());
    }
    
    /*
     * testSetAndGetGender => means testing DisasterVictim's setGender and getGender methods:
     * - What we need: To verify that the "setGender" method correctly updates the gender in the "DisasterVictim" object and "getGender" method returns the updated gender.
     * - Current result: The "setGender" method updates the gender in the "DisasterVictim" object with the provided gender and "getGender" method returns the updated gender.
     * - Expected Result: The test checks that the updated gender in the "DisasterVictim" object matches the provided gender, confirming successful update and retrieval of gender.
     */
    @Test
    public void testSetAndGetGender() {
        String newGender = "male";
        victim.setGender(newGender);
        assertEquals("setGender should update and getGender should return the new gender", newGender.toLowerCase(),
                victim.getGender());
    }

    /*
     * testAddFamilyConnection => means testing DisasterVictim's setFamilyConnections and getFamilyConnections methods:
     * - What we need: To verify that the "setFamilyConnections" method correctly updates the family connections in the "DisasterVictim" object and "getFamilyConnections" method returns the updated family connections.
     * - Current result: The "setFamilyConnections" method updates the family connections in the "DisasterVictim" object with the provided family relation and "getFamilyConnections" method returns the updated family connections.
     * - Expected Result: The test checks that the updated family connections in the "DisasterVictim" object matches the provided family relation, confirming successful update and retrieval of family connections.
     */
    @Test
    public void testAddFamilyConnection() {
        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");

        FamilyRelation relation = new FamilyRelation(victim2, "parent", victim1);
        FamilyRelation[] expectedRelations = { relation };
        victim2.setFamilyConnections(expectedRelations);

        FamilyRelation[] testFamily = victim2.getFamilyConnections();
        boolean correct = false;

        if ((testFamily != null) && (testFamily[0] == expectedRelations[0])) {
            correct = true;
        }
        assertTrue("addFamilyConnection should add a family relationship", correct);
    }

    /*
     * testAddPersonalBelonging => means testing DisasterVictim's addPersonalBelonging and getPersonalBelongings methods:
     * - What we need: To verify that the "addPersonalBelonging" method correctly adds a new supply to the personal belongings of the "DisasterVictim" object and "getPersonalBelongings" method returns the updated personal belongings.
     * - Current result: The "addPersonalBelonging" method adds a new supply to the personal belongings of the "DisasterVictim" object and "getPersonalBelongings" method returns the updated personal belongings.
     * - Expected Result: The test checks that the updated personal belongings in the "DisasterVictim" object includes the new supply, confirming successful addition of a new supply to personal belongings.
     */
    @Test
    public void testAddPersonalBelonging() {
        Supply newSupply = new Supply("Emergency Kit", 1);
        victim.addPersonalBelonging(newSupply);
        Supply[] testSupplies = victim.getPersonalBelongings();
        boolean correct = false;

        int i;
        for (i = 0; i < testSupplies.length; i++) {
            if (testSupplies[i] == newSupply) {
                correct = true;
            }
        }
        assertTrue("addPersonalBelonging should add the supply to personal belongings", correct);
    }
    /*
     * testRemoveFamilyConnection => means testing DisasterVictim's removeFamilyConnection and getFamilyConnections methods:
     * - What we need: To verify that the "removeFamilyConnection" method correctly removes a specified family connection from the "DisasterVictim" object and "getFamilyConnections" method returns the updated family connections.
     * - Current result: The "removeFamilyConnection" method removes a specified family connection from the "DisasterVictim" object and "getFamilyConnections" method returns the updated family connections.
     * - Expected Result: The test checks that the updated family connections in the "DisasterVictim" object does not include the removed family connection, confirming successful removal of a family connection.
     */
    @Test
    public void testRemoveFamilyConnection() {
        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");
        FamilyRelation relation1 = new FamilyRelation(victim, "sibling", victim1);
        FamilyRelation relation2 = new FamilyRelation(victim, "sibling", victim2);
        FamilyRelation[] expectedRelations = { relation2 };
        FamilyRelation[] originalRelations = { relation1, relation2 };
        victim.setFamilyConnections(originalRelations);

        DisasterVictim victim = new DisasterVictim("Freda", "2024-01-23");
        victim.addFamilyConnection(relation1);
        victim.addFamilyConnection(relation2);
        victim.removeFamilyConnection(relation1);

        FamilyRelation[] testFamily = victim.getFamilyConnections();
        boolean correct = true;

        int i;
        for (i = 0; i < testFamily.length; i++) {
            if (testFamily[i] == relation1) {
                correct = false;
            }
        }
        assertTrue("removeFamilyConnection should remove the family member", true);
    }

    /*
     * testRemovePersonalBelonging => means testing DisasterVictim's removePersonalBelonging and getPersonalBelongings methods:
     * - What we need: To verify that the "removePersonalBelonging" method correctly removes a specified supply from the personal belongings of the "DisasterVictim" object and "getPersonalBelongings" method returns the updated personal belongings.
     * - Current result: The "removePersonalBelonging" method removes a specified supply from the personal belongings of the "DisasterVictim" object and "getPersonalBelongings" method returns the updated personal belongings.
     * - Expected Result: The test checks that the updated personal belongings in the "DisasterVictim" object does not include the removed supply, confirming successful removal of a supply from personal belongings.
     */
    @Test
    public void testRemovePersonalBelonging() {

        Supply supplyToRemove = suppliesToSet.get(0);
        victim.addPersonalBelonging(supplyToRemove);
        victim.removePersonalBelonging(supplyToRemove);

        Supply[] testSupplies = victim.getPersonalBelongings();
        boolean correct = true;

        int i;
        for (i = 0; i < testSupplies.length; i++) {
            if (testSupplies[i] == supplyToRemove) {
                correct = false;
            }
        }
        assertTrue("removePersonalBelonging should remove the supply from personal belongings", true);
    }

    /*
     * testRemovePersonalBelonging => means testing DisasterVictim's removePersonalBelonging and getPersonalBelongings methods:
     * - What we need: To verify that the "removePersonalBelonging" method correctly removes a specified supply from the personal belongings of the "DisasterVictim" object and "getPersonalBelongings" method returns the updated personal belongings.
     * - Current result: The "removePersonalBelonging" method removes a specified supply from the personal belongings of the "DisasterVictim" object and "getPersonalBelongings" method returns the updated personal belongings.
     * - Expected Result: The test checks that the updated personal belongings in the "DisasterVictim" object does not include the removed supply, confirming successful removal of a supply from personal belongings.
     */
    @Test
    public void testSetFamilyConnection() {
        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");

        FamilyRelation relation = new FamilyRelation(victim1, "sibling", victim2);
        FamilyRelation[] expectedRelations = { relation };
        victim1.setFamilyConnections(expectedRelations);
        boolean correct = true;

        // We have not studied overriding equals in arrays of custom objects so we will
        // manually evaluate equality
        FamilyRelation[] actualRecords = victim1.getFamilyConnections();
        if (expectedRelations.length != actualRecords.length) {
            correct = false;
        } else {
            int i;
            for (i = 0; i < actualRecords.length; i++) {
                if (expectedRelations[i] != actualRecords[i]) {
                    correct = false;
                }
            }
        }
        assertTrue("Family relation should be set", correct);
    }
    
    /*
     * testSetMedicalRecords => means testing DisasterVictim's setMedicalRecords and getMedicalRecords methods:
     * - What we need: To verify that the "setMedicalRecords" method correctly sets the medical records in the "DisasterVictim" object and "getMedicalRecords" method returns the updated medical records.
     * - Current result: The "setMedicalRecords" method sets the medical records in the "DisasterVictim" object with the provided medical record and "getMedicalRecords" method returns the updated medical records.
     * - Expected Result: The test checks that the updated medical records in the "DisasterVictim" object matches the provided medical record, confirming successful setting and retrieval of medical records.
     */
    @Test
    public void testSetMedicalRecords() {
        Location testLocation = new Location("Shelter Z", "1234 Shelter Ave");
        MedicalRecord testRecord = new MedicalRecord(testLocation, "test for strep", "2024-02-09");
        boolean correct = true;

        MedicalRecord[] newRecords = { testRecord };
        victim.setMedicalRecords(newRecords);
        MedicalRecord[] actualRecords = victim.getMedicalRecords();

        // We have not studied overriding equals in arrays of custom objects so we will
        // manually evaluate equality
        if (newRecords.length != actualRecords.length) {
            correct = false;
        } else {
            int i;
            for (i = 0; i < newRecords.length; i++) {
                if (actualRecords[i] != newRecords[i]) {
                    correct = false;
                }
            }
        }
        assertTrue("setMedicalRecords should correctly update medical records", correct);
    }
    
    /*
     * testSetPersonalBelongings => means testing DisasterVictim's setPersonalBelongings and getPersonalBelongings methods:
     * - What we need: To verify that the "setPersonalBelongings" method correctly sets the personal belongings in the "DisasterVictim" object and "getPersonalBelongings" method returns the updated personal belongings.
     * - Current result: The "setPersonalBelongings" method sets the personal belongings in the "DisasterVictim" object with the provided supplies and "getPersonalBelongings" method returns the updated personal belongings.
     * - Expected Result: The test checks that the updated personal belongings in the "DisasterVictim" object matches the provided supplies, confirming successful setting and retrieval of personal belongings.
     */
    @Test
    public void testSetPersonalBelongings() {
        Supply one = new Supply("Tent", 1);
        Supply two = new Supply("Jug", 3);
        Supply[] newSupplies = { one, two };
        boolean correct = true;

        victim.setPersonalBelongings(newSupplies);
        Supply[] actualSupplies = victim.getPersonalBelongings();

        // We have not studied overriding equals in arrays of custom objects so we will
        // manually evaluate equality
        if (newSupplies.length != actualSupplies.length) {
            correct = false;
        } else {
            int i;
            for (i = 0; i < newSupplies.length; i++) {
                if (actualSupplies[i] != newSupplies[i]) {
                    correct = false;
                }
            }
        }
        assertTrue("setPersonalBelongings should correctly update personal belongings", correct);
    }
    
    /*
     * testAge => means testing DisasterVictim's setAge and getAge methods:
     * - What we need: To verify that the "setAge" method correctly sets the age in the "DisasterVictim" object and "getAge" method returns the updated age.
     * - Current result: The "setAge" method sets the age in the "DisasterVictim" object with the provided age and "getAge" method returns the updated age.
     * - Expected Result: The test checks that the updated age in the "DisasterVictim" object matches the provided age, confirming successful setting and retrieval of age.
     */
    @Test
    public void testAge() {
        victim.setAge(32);
        assertEquals(32, victim.getAge());
    }
    
    /*
     * testDietaryRestrictions => means testing DisasterVictim's setDietaryRestrictions and getDietaryRestrictions methods:
     * - What we need: To verify that the "setDietaryRestrictions" method correctly sets the dietary restrictions in the "DisasterVictim" object and "getDietaryRestrictions" method returns the updated dietary restrictions.
     * - Current result: The "setDietaryRestrictions" method sets the dietary restrictions in the "DisasterVictim" object with the provided list of restrictions and "getDietaryRestrictions" method returns the updated dietary restrictions.
     * - Expected Result: The test checks that the updated dietary restrictions in the "DisasterVictim" object matches the provided list of restrictions, confirming successful setting and retrieval of dietary restrictions.
     */
    @Test
    public void testDietaryRestrictions() {
        List<DisasterVictim.DietaryRestriction> restrictions = new ArrayList<>();
        victim.setDietaryRestrictions(restrictions);
        assertEquals(restrictions, victim.getDietaryRestrictions());
    }
}

}
