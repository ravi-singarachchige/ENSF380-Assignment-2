package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {
    private Person person;
    private String expectedFirstName = "John";
    private String expectedLastName = "Doe";

    @Before
    public void setUp() {
        person = new Person(expectedFirstName, expectedLastName);
    }

    @After
    public void tearDown() {
        person = null;
    }

    /*
     * testObjectCreation => means testing Person constructor:
     * - What we need: To verify that an "Person" object is successfully created.
     * - Current result: The first name is "John", The last name is "Doe".
     * - Expected Result: The test checks that the Person object is not null,
     * confirming successful object creation.
     */

    @Test
    public void testObjectCreation() {
        assertNotNull("Person object should be created", person);
    }

    /*
     * testGetFirstName:
     * - What we need: To ensure the "getFirstName()" method correctly returns the
     * actual first name.
     * - Current result: "John".
     * - Expected result: "person.getFirstName()" should return "John".
     */

    @Test
    public void testGetFirstName() {
        // Arrange is done in setUp

        // Act
        String actualFirstName = person.getFirstName();

        // Assert
        assertEquals("getFirstName should return the correct first name", expectedFirstName, actualFirstName);
    }

    /*
     * testSetFirstName():
     * - What we need: To ensure the "setFirstName()" method correctly updates the
     * first name.
     * - Current result: "John".
     * - Expected result: "Jane".
     */

    @Test
    public void testSetFirstName() {
        // Arrange
        String newFirstName = "Jane";

        // Act
        person.setFirstName(newFirstName);
        String actualFirstName = person.getFirstName();

        // Assert
        assertEquals("setFirstName should update the first name", newFirstName, actualFirstName);
    }

    /*
     * testGetLastName:
     * - What we need: To ensure the "getLastName()" method correctly returns the
     * actual last name.
     * - Current result: "Doe".
     * - Expected result: "person.getLastName()" should return "Doe".
     */

    @Test
    public void testGetLastName() {
        // Arrange is done in setUp

        // Act
        String actualLastName = person.getLastName();

        // Assert
        assertEquals("getLastName should return the correct last name", expectedLastName, actualLastName);
    }

    /*
     * testSetLastName():
     * - What we need: To ensure the "setLastName()" method correctly updates the
     * last name.
     * - Current result: "Doe".
     * - Expected result: "Smith".
     */

    @Test
    public void testSetLastName() {
        // Arrange
        String newLastName = "Smith";

        // Act
        person.setLastName(newLastName);
        String actualLastName = person.getLastName();

        // Assert
        assertEquals("setLastName should update the last name", newLastName, actualLastName);
    }
}