package edu.ucalgary.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FamilyRelationTest {
    private FamilyRelation relation;
    private DisasterVictim personOne;
    private DisasterVictim personTwo;

    @BeforeEach
    public void setUp() {
        personOne = new DisasterVictim("John", "2022-01-01");
        personTwo = new DisasterVictim("Jane", "2022-01-01");
        relation = new FamilyRelation(personOne, "sibling", personTwo);
    }

    @Test
    public void testGetPersonOne() {
        assertEquals(personOne, relation.getPersonOne());
    }

    @Test
    public void testSetPersonOne() {
        DisasterVictim newPerson = new DisasterVictim("Joe", "2022-01-01");
        relation.setPersonOne(newPerson);
        assertEquals(newPerson, relation.getPersonOne());
    }

    @Test
    public void testGetRelationshipTo() {
        assertEquals("sibling", relation.getRelationshipTo());
    }

    @Test
    public void testSetRelationshipTo() {
        relation.setRelationshipTo("parent");
        assertEquals("parent", relation.getRelationshipTo());
    }

    @Test
    public void testGetPersonTwo() {
        assertEquals(personTwo, relation.getPersonTwo());
    }

    @Test
    public void testSetPersonTwo() {
        DisasterVictim newPerson = new DisasterVictim("Jill", "2022-01-01");
        relation.setPersonTwo(newPerson);
        assertEquals(newPerson, relation.getPersonTwo());
    }
}