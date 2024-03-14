package edu.ucalgary.oop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @After
    public void tearDown() {
        victim = null;
    }

    /*
     * testObjectCreation:
     * - What we need: To verify that a "DisasterVictim" object is successfully
     * created.
     * - Expected Result: The test checks that the DisasterVictim object is not
     * null, confirming successful object creation.
     */
    @Test
    public void testObjectCreation() {
        assertNotNull("DisasterVictim object should not be null", victim);
    }

    /*
     * testConstructor:
     * - What we need: To verify that the "DisasterVictim" object's constructor
     * correctly sets the first name and entry date.
     * - Expected Result: The test checks that the DisasterVictim object's first
     * name and entry date match the expected values, confirming that the
     * constructor works correctly.
     */
    @Test
    public void testConstructor() {
        assertEquals("Constructor should set the first name correctly", expectedFirstName, victim.getFirstName());
        assertEquals("Constructor should set the entry date correctly", EXPECTED_ENTRY_DATE, victim.getEntryDate());
    }

    /*
     * testConstructorWithValidEntryDate:
     * - What we need: To verify that a "DisasterVictim" object is successfully
     * created with a valid entry date.
     * - Expected Result: The test checks that the DisasterVictim object is not null
     * and the entry date is set correctly, confirming successful object creation
     * with a valid entry date.
     */

    @Test
    public void testConstructorWithValidEntryDate() {
        String validEntryDate = "2024-01-18";
        DisasterVictim victim = new DisasterVictim("Freda", validEntryDate);
        assertNotNull("Constructor should successfully create an instance with a valid entry date", victim);
        assertEquals("Constructor should set the entry date correctly", validEntryDate, victim.getEntryDate());
    }

    /*
     * testConstructorWithInvalidEntryDateFormat:
     * - What we need: To verify that a "DisasterVictim" object is not created with
     * an invalid entry date format.
     * - Expected Result: The test checks that the constructor throws an
     * IllegalArgumentException when an invalid entry date format is provided,
     * confirming that the object is not created.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidEntryDateFormat() {
        String invalidEntryDate = "18/01/2024";
        new DisasterVictim("Freda", invalidEntryDate);
    }

    /*
     * testSetDateOfBirth:
     * - What we need: To verify that the "setDateOfBirth" method correctly updates
     * the date of birth in the "DisasterVictim" object.
     * - Expected Result: The test checks that the updated date of birth in the
     * "DisasterVictim" object matches the provided date, confirming successful
     * update of date of birth.
     */
    @Test
    public void testSetDateOfBirth() {
        LocalDate newDateOfBirth = LocalDate.of(2022, 5, 21);
        victim.setDateOfBirth(newDateOfBirth);
        assertEquals("setDateOfBirth should correctly update the date of birth", newDateOfBirth,
                victim.getDateOfBirth());
    }

    /*
     * testGetDateOfBirth:
     * - What we need: To verify that the "getDateOfBirth" method correctly retrieves
     * the date of birth in the "DisasterVictim" object.
     * - Expected Result: The test checks that the "getDateOfBirth" method returns the
     * correct date of birth, confirming successful retrieval of date of birth.
     */
    @Test
    public void testGetDateOfBirth() {
        LocalDate newDateOfBirth = LocalDate.of(2022, 5, 21);
        victim.setDateOfBirth(newDateOfBirth);
        assertEquals("getDateOfBirth should return the correct date of birth", newDateOfBirth, victim.getDateOfBirth());
    }

    /*
     * testSetDateOfBirthWithInvalidFormat:
     * - What we need: To verify that the "setDateOfBirth" method does not update
     * the date of birth in the "DisasterVictim" object with an invalid date format.
     * - Expected Result: The test checks that the "setDateOfBirth" method throws an
     * IllegalArgumentException when an invalid date format is provided, confirming
     * that the date of birth is not updated.
     */
    @Test(expected = DateTimeException.class)
    public void testSetDateOfBirthWithInvalidFormat() {
        LocalDate invalidDate = LocalDate.of(2010, 5, 32); // This date does not exist so it should throw an exception
        victim.setDateOfBirth(invalidDate);
    }

    /*
     * testAge => means testing DisasterVictim's setAge and getAge methods:
     * - What we need: To verify that the "setAge" method correctly sets the age in
     * the "DisasterVictim" object and "getAge" method returns the updated age.
     * - Expected Result: The test checks that the updated age in the
     * "DisasterVictim" object matches the provided age, confirming successful
     * setting and retrieval of age.
     */
    @Test
    public void testSetAndGetAge() {
        victim.setAge(32);
        assertEquals(32, victim.getAge());
    }

    /*
     * testAgeFromBirthdate => means testing DisasterVictim's getAge method when age
     * is unknown:
     * - What we need: To verify that the "getAge" method correctly calculates the
     * age from the birthdate when the age is unknown.
     * - Expected Result: The test checks that the calculated age from the birthdate
     * matches the expected age, confirming successful calculation of age from
     * birthdate.
     */
    @Test
    public void testGetEffectiveAge() {
        // Suppose the victim's date of birth is known, then we use the date of birth to calculate the age
        victim.setAge(null);
        victim.setDateOfBirth(LocalDate.of(1990, 5, 21));
        LocalDate currentDate = LocalDate.now();
        int expectedAge = currentDate.getYear() - victim.getDateOfBirth().getYear();
        assertEquals(
                "when the age is unknown, getEffectiveAge should return the age by calculating it from the year of birth",
                expectedAge, victim.getEffectiveAge());

        // Suppose the victim's date of birth is unknown, then we use the age given by them

        victim.setDateOfBirth(null);
        victim.setAge(10);
        assertEquals("when the date of birth is unknown, getEffectiveAge should return the age given by the victim", 10,
                victim.getEffectiveAge());

    }

    /*
     * testGetComments:
     * - What we need: To verify that the "getComments" method correctly retrieves
     * the initial comments in the "DisasterVictim" object.
     * - Expected Result: The test checks that the "getComments" method returns the
     * initial correct comments, confirming successful retrieval of comments.
     */
    @Test
    public void testGetComments() {
        victim.setComments(expectedComments);
        assertEquals("getComments should return the initial correct comments", expectedComments, victim.getComments());
    }

    /*
     * testSetComments:
     * - What we need: To verify that the "setComments" method correctly updates the
     * comments in the "DisasterVictim" object.
     * - Expected Result: The test checks that the updated comments in the
     * "DisasterVictim" object match the comments returned by getComments() method, confirming successful
     * update of comments.
     */
    @Test
    public void testSetComments() {
        victim.setComments(expectedComments);
        String newComments = "Has a minor injury on the left arm";
        victim.setComments(newComments);
        assertEquals("setComments should update the comments correctly", newComments, victim.getComments());
    }



    /*
     * testSetAndGetFirstName:
     * - What we need: To verify that the "setFirstName" method correctly updates
     * the first name in the "DisasterVictim" object and the "getFirstName" method
     * correctly retrieves the updated first name.
     * - Expected Result: The test checks that the updated first name in the
     * "DisasterVictim" object matches the provided name, confirming successful
     * update and retrieval of first name.
     */
    @Test
    public void testSetAndGetFirstName() {
        String newFirstName = "Alice";
        victim.setFirstName(newFirstName);
        assertEquals("setFirstName should update and getFirstName should return the new first name", newFirstName,
                victim.getFirstName());
    }

    /*
     * testSetAndGetLastName:
     * - What we need: To verify that the "setLastName" method correctly updates the
     * last name in the "DisasterVictim" object and the "getLastName" method
     * correctly retrieves the updated last name.
     * - Expected Result: The test checks that the updated last name in the
     * "DisasterVictim" object matches the provided name, confirming successful
     * update and retrieval of last name.
     */
    @Test
    public void testSetAndGetLastName() {
        String newLastName = "Smith";
        victim.setLastName(newLastName);
        assertEquals("setLastName should update and getLastName should return the new last name", newLastName,
                victim.getLastName());
    }


    /*
     * testGetAssignedSocialID => means testing DisasterVictim's getAssignedSocialID
     * method:
     * - What we need: To verify that the "getAssignedSocialID" method correctly
     * retrieves the initial social ID in the "DisasterVictim" object.
     * - Expected Result: The test checks that the "getAssignedSocialID" method
     * returns the initial correct social ID, confirming successful retrieval of
     * social ID.
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
     * - What we need: To verify that the "getEntryDate" method correctly retrieves
     * the initial entry date in the "DisasterVictim" object.
     * - Expected Result: The test checks that the "getEntryDate" method returns the
     * initial correct entry date, confirming successful retrieval of entry date.
     */
    @Test
    public void testGetEntryDate() {
        assertEquals("getEntryDate should return the expected entry date", EXPECTED_ENTRY_DATE, victim.getEntryDate());
    }

    /*
     * testSetAndGetGender => means testing DisasterVictim's setGender and getGender
     * methods:
     * - What we need: To verify that the "setGender" method correctly updates the
     * gender in the "DisasterVictim" object and "getGender" method returns the
     * updated gender.
     * - Expected Result: The test checks that the updated gender in the
     * "DisasterVictim" object matches the provided gender, confirming successful
     * update and retrieval of gender.
     */
    @Test
    public void testSetAndGetGender() {
        String newGender = "male";
        victim.setGender(newGender);
        assertEquals("setGender should update and getGender should return the new gender", newGender,
                victim.getGender());
    }


    /*
     * testGetGenderOptions => means testing DisasterVictim's getGenderOptions
     * method:
     * - What we need: To verify that the "getGenderOptions" method returns a
     * non-empty list after loading from file.
     * - Expected Result: The test checks that the "getGenderOptions" method returns
     * a non-empty list after loading from file, confirming successful loading of
     * gender options.
     */ 
     
    @Test
    public void testGetGenderOptions() {
        victim.loadGenderOptionsFromFile("GenderOptions.txt");
        List<String> genderOptions = victim.getGenderOptions();
        assertTrue("getGenderOptions should return a non-empty list after loading from file", genderOptions != null && !genderOptions.isEmpty());
    }


    /*
     * testLoadGenderOptionsFromFile => means testing DisasterVictim's
     * loadGenderOptionsFromFile method:
     * - What we need: To verify that the "loadGenderOptionsFromFile" method
     * populates GenderOptions with non-empty list after loading from file.
     * - Expected Result: The test checks that the "loadGenderOptionsFromFile"
     * method populates GenderOptions with non-empty list after loading from file,
     * confirming successful population of GenderOptions.
     */


    @Test
    public void testLoadGenderOptionsFromFile() {
        victim.loadGenderOptionsFromFile("GenderOptions.txt");
        List<String> genderOptions = victim.getGenderOptions();
        assertTrue("loadGenderOptionsFromFile should populate genderOptions", genderOptions != null && !genderOptions.isEmpty());
    }

    /*
     * testAddFamilyConnection => means testing DisasterVictim's
     * setFamilyConnections and getFamilyConnections methods:
     * - What we need: To verify that the "setFamilyConnections" method correctly
     * updates the family connections in the "DisasterVictim" object and
     * "getFamilyConnections" method returns the updated family connections.
     * - Expected Result: The test checks that the updated family connections in the
     * "DisasterVictim" object matches the provided family relation, confirming
     * successful update and retrieval of family connections.
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
     * testSetPersonalBelongings => means testing DisasterVictim's
     * setPersonalBelongings and getPersonalBelongings methods:
     * - What we need: To verify that the "setPersonalBelongings" method correctly
     * sets the personal belongings in the "DisasterVictim" object and
     * "getPersonalBelongings" method returns the updated personal belongings.
     * - Expected Result: The test checks that the updated personal belongings in
     * the "DisasterVictim" object matches the provided supplies, confirming
     * successful setting and retrieval of personal belongings.
     */
    @Test
    public void testSetPersonalBelongings() {
        Supply one = new Supply("Tent", 1);
        Supply two = new Supply("Jug", 3);
        Supply[] newSupplies = { one, two };
        boolean correct = true;

        victim.setPersonalBelongings(newSupplies);
        Supply[] actualSupplies = victim.getPersonalBelongings();

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
     * testGetPersonalBelongings => means testing DisasterVictim's
     * getPersonalBelongings method:
     * - What we need: To verify that the "getPersonalBelongings" method correctly
     * retrieves the initial personal belongings in the "DisasterVictim" object.
     * - Expected Result: The test checks that the "getPersonalBelongings" method
     * returns the initial correct personal belongings, confirming successful
     * retrieval of personal belongings.
     */

    @Test
    public void testGetPersonalBelongings() {
        victim.setPersonalBelongings(suppliesToSet);
        assertEquals("getPersonalBelongings should return the expected personal belongings", suppliesToSet,
                victim.getPersonalBelongings());
    }
    

    /*
     * testAddPersonalBelonging => means testing DisasterVictim's
     * addPersonalBelonging and getPersonalBelongings methods:
     * - What we need: To verify that the "addPersonalBelonging" method correctly
     * adds a new supply to the personal belongings of the "DisasterVictim" object
     * and "getPersonalBelongings" method returns the updated personal belongings.
     * - Expected Result: The test checks that the updated personal belongings in
     * the "DisasterVictim" object includes the new supply, confirming successful
     * addition of a new supply to personal belongings.
     */

    @Test
    public void testAddPersonalBelonging() {
        Supply newSupply = new Supply("Emergency Kit", 1);
        victim.addPersonalBelonging(newSupply);
        ArrayList<Supply> testSupplies = victim.getPersonalBelongings();
        assertTrue("addPersonalBelonging should add the supply to personal belongings", testSupplies.contains(newSupply));
    }


        /*
     * testRemovePersonalBelonging => means testing DisasterVictim's
     * removePersonalBelonging and getPersonalBelongings methods:
     * - What we need: To verify that the "removePersonalBelonging" method correctly
     * removes a specified supply from the personal belongings of the
     * "DisasterVictim" object and "getPersonalBelongings" method returns the
     * updated personal belongings.
     * - Expected Result: The test checks that the updated personal belongings in
     * the "DisasterVictim" object does not include the removed supply, confirming
     * successful removal of a supply from personal belongings.
     */

    @Test
    public void testRemovePersonalBelonging() {
        Supply supplyToRemove = suppliesToSet.get(0);
        victim.addPersonalBelonging(supplyToRemove);
        victim.removePersonalBelonging(supplyToRemove);

        ArrayList<Supply> testSupplies = victim.getPersonalBelongings();
        assertFalse("removePersonalBelonging should remove the supply from personal belongings", testSupplies.contains(supplyToRemove));
    }

    /*
     * testSetAndGetMedicalRecords => means testing DisasterVictim's setMedicalRecords and
     * getMedicalRecords methods:
     * - What we need: To verify that the "setMedicalRecords" method correctly sets
     * the medical records in the "DisasterVictim" object and "getMedicalRecords"
     * method returns the updated medical records.
     * - Expected Result: The test checks that the updated medical records in the
     * "DisasterVictim" object matches the provided medical record, confirming
     * successful setting and retrieval of medical records.
     */


     @Test
     public void testSetAndGetMedicalRecords() {
         Location testLocation = new Location("Shelter Z", "1234 Shelter Ave");
         MedicalRecord testRecord = new MedicalRecord(testLocation, "test for strep", "2024-02-09");
 
         Set<MedicalRecord> newRecords = new HashSet<>();
         newRecords.add(testRecord);
         victim.setMedicalRecords(newRecords);
         Set<MedicalRecord> actualRecords = victim.getMedicalRecords();
 
         assertTrue("setMedicalRecords should correctly update medical records", actualRecords.equals(newRecords));
     }


    /*
    * testAddMedicalRecord => means testing DisasterVictim's addMedicalRecord method:
    * - What we need: To verify that the "addMedicalRecord" method correctly adds a new
    * medical record to the medical records of the "DisasterVictim" object.
    * - Expected Result: The test checks that the updated medical records in the
    * "DisasterVictim" object includes the new medical record, confirming successful
    * addition of a new medical record.
    */
    
     @Test
     public void testAddMedicalRecord() {
         Location testLocation = new Location("Shelter Z", "1234 Shelter Ave");
         MedicalRecord testRecord = new MedicalRecord(testLocation, "test for strep", "2024-02-09");
 
         victim.addMedicalRecord(testRecord);
         Set<MedicalRecord> actualRecords = victim.getMedicalRecords();
 
         assertTrue("addMedicalRecord should add the medical record", actualRecords.contains(testRecord));
     }

    /*
     * testSetAndGetFamilyConnections => means testing DisasterVictim's
     * setFamilyConnections and getFamilyConnections methods:
     * - What we need: To verify that the "setFamilyConnections" method correctly
     * sets the family connections in the "DisasterVictim" object and
     * "getFamilyConnections" method returns the updated family connections.
     * - Expected Result: The test checks that the updated family connections in the
     * "DisasterVictim" object matches the provided family relation, confirming
     * successful setting and retrieval of family connections.
     */

    @Test
    public void testSetAndGetFamilyConnections() {
        FamilyRelation relation = new FamilyRelation();
        List<FamilyRelation> relations = new ArrayList<>();
        relations.add(relation);
        victim.setFamilyConnections(relations);
        assertEquals("setFamilyConnections and getFamilyConnections should correctly update and retrieve family connections", relations, victim.getFamilyConnections());
    }


    /*
     * testAddAndRemoveFamilyConnection => means testing DisasterVictim's
     * addFamilyConnection and removeFamilyConnection methods:
     * - What we need: To verify that the "addFamilyConnection" method correctly
     * adds a new family connection to the "DisasterVictim" object and
     * "removeFamilyConnection" method correctly removes the family connection.
     * - Expected Result: The test checks that the updated family connections in the
     * "DisasterVictim" object includes the new family connection and does not
     * include the removed family connection, confirming successful addition and
     * removal of family connections.
     */

    @Test
    public void testAddAndRemoveFamilyConnection() {
        FamilyRelation relation = new FamilyRelation();
        victim.addFamilyConnection(relation);
        assertTrue("addFamilyConnection should add the family connection", victim.getFamilyConnections().contains(relation));
        victim.removeFamilyConnection(relation);
        assertTrue("removeFamilyConnection should remove the family connection", !victim.getFamilyConnections().contains(relation));
    }

    /*
     * testDietaryRestrictions => means testing DisasterVictim's
     * setDietaryRestrictions and getDietaryRestrictions methods:
     * - What we need: To verify that the "setDietaryRestrictions" method correctly
     * sets the dietary restrictions in the "DisasterVictim" object and
     * "getDietaryRestrictions" method returns the updated dietary restrictions.
     * - Expected Result: The test checks that the updated dietary restrictions in
     * the "DisasterVictim" object matches the provided list of restrictions,
     * confirming successful setting and retrieval of dietary restrictions.
     */

    @Test
    public void testSetAndGetDietaryRestrictions() {
        DietaryRestriction restriction = new DietaryRestriction();
        List<DietaryRestriction> restrictions = new ArrayList<>();
        restrictions.add(restriction);
        victim.setDietaryRestrictions(restrictions);
        assertEquals("setDietaryRestrictions and getDietaryRestrictions should correctly update and retrieve dietary restrictions", restrictions, victim.getDietaryRestrictions());
    }
}

}