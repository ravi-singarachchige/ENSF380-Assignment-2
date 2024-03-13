package edu.ucalgary.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class DisasterVictimTest {
    private DisasterVictim victim;

    @BeforeEach
    public void setUp() {
        victim = new DisasterVictim("John", "2022-01-01");
    }

    @Test
    public void testGenerateSocialID() {
        int id1 = victim.getAssignedSocialID();
        DisasterVictim victim2 = new DisasterVictim("Jane", "2022-01-01");
        int id2 = victim2.getAssignedSocialID();
        assertTrue(id2 > id1);
    }

    @Test
    public void testInvalidDateFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            new DisasterVictim("John", "01-01-2022");
        });
    }

    @Test
    public void testInvalidGender() {
        assertThrows(IllegalArgumentException.class, () -> {
            victim.setGender("invalid");
        });
    }

    @Test
    public void testAddPersonalBelonging() {
        Supply supply = new Supply("Water", 1);
        victim.addPersonalBelonging(supply);
        Supply[] belongings = victim.getPersonalBelongings();
        assertEquals(1, belongings.length);
        assertEquals(supply, belongings[0]);
    }

    @Test
    public void testRemovePersonalBelonging() {
        Supply supply = new Supply("Water", 1);
        victim.addPersonalBelonging(supply);
        victim.removePersonalBelonging(supply);
        Supply[] belongings = victim.getPersonalBelongings();
        assertEquals(0, belongings.length);
    }

    @Test
    public void testAddFamilyConnection() {
        FamilyRelation relation = new FamilyRelation("Jane", "sister");
        victim.addFamilyConnection(relation);
        FamilyRelation[] connections = victim.getFamilyConnections();
        assertEquals(1, connections.length);
        assertEquals(relation, connections[0]);
    }

    @Test
    public void testRemoveFamilyConnection() {
        FamilyRelation relation = new FamilyRelation("Jane", "sister");
        victim.addFamilyConnection(relation);
        victim.removeFamilyConnection(relation);
        FamilyRelation[] connections = victim.getFamilyConnections();
        assertEquals(0, connections.length);
    }

    @Test
    public void testAddMedicalRecord() {
        MedicalRecord record = new MedicalRecord("2022-01-01", "Checkup", "Healthy");
        victim.addMedicalRecord(record);
        MedicalRecord[] records = victim.getMedicalRecords();
        assertEquals(1, records.length);
        assertEquals(record, records[0]);
    }

    @Test
    public void testSetFamilyConnections() {
        FamilyRelation relation1 = new FamilyRelation("Jane", "sister");
        FamilyRelation relation2 = new FamilyRelation("Joe", "brother");
        victim.setFamilyConnections(new ArrayList<>(Arrays.asList(relation1, relation2)));
        FamilyRelation[] connections = victim.getFamilyConnections();
        assertEquals(2, connections.length);
        assertEquals(relation1, connections[0]);
        assertEquals(relation2, connections[1]);
    }

    @Test
    public void testSetMedicalRecords() {
        MedicalRecord record1 = new MedicalRecord("2022-01-01", "Checkup", "Healthy");
        MedicalRecord record2 = new MedicalRecord("2022-02-01", "Follow-up", "Still healthy");
        victim.setMedicalRecords(new ArrayList<>(Arrays.asList(record1, record2)));
        MedicalRecord[] records = victim.getMedicalRecords();
        assertEquals(2, records.length);
        assertEquals(record1, records[0]);
        assertEquals(record2, records[1]);
    }

    @Test
    public void testSetPersonalBelongings() {
        Supply supply1 = new Supply("Water", 1);
        Supply supply2 = new Supply("Food", 2);
        victim.setPersonalBelongings(new Supply[] { supply1, supply2 });
        Supply[] belongings = victim.getPersonalBelongings();
        assertEquals(2, belongings.length);
        assertEquals(supply1, belongings[0]);
        assertEquals(supply2, belongings[1]);
    }
}