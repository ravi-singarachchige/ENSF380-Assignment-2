package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;

public class FamilyRelationTest {
    private FamilyRelation familyRelation;
    private Set<DisasterVictim> persons;
    private String relationshipTo = "Sibling";


    /*
     * @Before -> means that this method will be run before each test method.
     */
    @Before
    public void setUp() {
        private DisasterVictim personOne = new DisasterVictim("John Dalan", "2024-01-19");
        private DisasterVictim personTwo = new DisasterVictim("Jane Dalan", "2024-02-20");
        persons = new HashSet<>();
        persons.add(personOne);
        persons.add(personTwo);
        familyRelation = new FamilyRelation(personOne, relationshipTo, personTwo);
    }


    /*
     * testObjectCreation:
     * - What we need: To verify that an "FamilyRelation" object is successfully
     * created.
     * - Current result: FamilyRelation is not null.
     * - Expected Result: The test checks that the FamilyRelation object is not
     * null, confirming successful object creation.
     */

    @Test
    public void testObjectCreation() {
        assertNotNull("FamilyRelation object should be created", familyRelation);
    }

    /*
     * testGetPersons:
     * - What we need: To verify that the getPersons method returns the correct
     * persons.
     * - Current result: The getPersons method returns John Dalan and Jane Dalan.
     * - Expected Result: The test checks that the getPersonOne method returns the
     * correct persons, confirming the method is working as expected.
     */
    @Test
    public void testGetPersons() {
        assertEquals("getPersons should return the correct persons", persons, familyRelation.getPersons());
    }

    /*
     * testSetPersons:
     * - What we need: To verify that the setPersons method updates the persons.
     * - Current result: The setPersons method updates the persons to include a new
     * person, John Dalan, Jane Dalan, and John Doe.
     * - Expected Result: The test checks that the setPersons method updates the
     * persons, confirming the method is working as expected.
     */
    @Test
    public void testSetPersons() {
        DisasterVictim personThree = new DisasterVictim("John Doe", "2024-03-21");
        Set<DisasterVictim> newPersons = new HashSet<>();
        newPersons.add(personThree);
        familyRelation.setPersons(newPersons);
        assertEquals("setPersons should update the persons", newPersons, familyRelation.getPersons());
    }

    /*
     * testGetRelationship:
     * - What we need: To verify that the getRelationship method returns the correct
     * relationship.
     * - Current result: The getRelationship method returns "Sibling".
     * - Expected Result: The test checks that the getRelationship method returns the
     * correct relationship, confirming the method is working as expected.
     */
    @Test
    public void testGetRelationship() {
        assertEquals("getRelationship should return the correct relationship", relationshipTo, familyRelation.getRelationship());
    }

    /*
     * testSetRelationship:
     * - What we need: To verify that the setRelationship method updates the
     * relationship.
     * - Current result: The setRelationship method updates the relationship to
     * "Parent".
     * - Expected Result: The test checks that the setRelationship method updates the
     * relationship, confirming the method is working as expected.
     */
    @Test
    public void testSetRelationship() {
        String newRelationship = "Parent";
        familyRelation.setRelationship(newRelationship);
        assertEquals("setRelationship should update the relationship", newRelationship, familyRelation.getRelationship());
    }

    /*
     * testEquals:
     * - What we need: To verify that the equals method returns true for equal
     * FamilyRelation objects.
     * - Current result: The equals method returns true for equal FamilyRelation
     * objects.
     * - Expected Result: The test checks that the equals method returns true for
     * equal FamilyRelation objects, confirming the method is working as expected.
     */
    @Test
    public void testEquals() {
        DisasterVictim personOne = new DisasterVictim("John Dalan", "2024-01-19");
        DisasterVictim personTwo = new DisasterVictim("Jane Dalan", "2024-02-20");
        FamilyRelation sameFamilyRelation = new FamilyRelation(personOne, relationshipTo, personTwo);
        assertTrue("equals should return true for equal FamilyRelation objects", familyRelation.equals(sameFamilyRelation));
    }


    /*
     * testHashCode:
     * - What we need: To verify that the hashCode method returns the same hash code
     * for equal FamilyRelation objects.
     * - Current result: The hashCode method returns the same hash code for equal
     * FamilyRelation objects.
     * - Expected Result: The test checks that the hashCode method returns the same
     * hash code for equal FamilyRelation objects, confirming the method is working as
     * expected.
     */
    @Test
    public void testHashCode() {
        DisasterVictim personOne = new DisasterVictim("John Dalan", "2024-01-19");
        DisasterVictim personTwo = new DisasterVictim("Jane Dalan", "2024-02-20");
        FamilyRelation sameFamilyRelation = new FamilyRelation(personOne, relationshipTo, personTwo);
        assertEquals("hashCode should return the same hash code for equal FamilyRelation objects", familyRelation.hashCode(), sameFamilyRelation.hashCode());
    }
}