package edu.ucalgary.oop;

import org.junit.*;
import static org.junit.Assert.*;

public class InquirerTest {

    /*
     * Define the values which will be used for tests
     */
    private int expectedId = 1;
    private String expectedPhoneNumber = "+1-123-456-7890";
    private String expectedMessage = "looking for my family members";
    private Inquirer inquirer = new Inquirer("Joseph", "Bouillon", expectedId, expectedPhoneNumber, expectedMessage);

    /*
     * testObjectCreation -> means testing Inquirer constructor:
     * - What we need: To verify that an "Inquirer" object is successfully created.
     * - Current result: The inquirer constructor is not null and contains: name "Joseph Bouillon", the services phone number
     * "+1-123-456-7890", and the provided info is "looking for my family members".
     * - Expected Result: The test checks that the Inquirer object is not null,
     * confirming successful object creation.
     */
    @Test
    public void testObjectCreation() {
        assertNotNull(inquirer);
    }

    /*
     * testGetId:
     * - What we need: To ensure the "getId()" method correctly returns the actual
     * inquirer's id.
     * - Current result: 1.
     * - Expected result: "inquirer.getId()" should return 1.
     */
    @Test
    public void testGetId() {
        assertEquals("getId should return the correct id", expectedId, inquirer.getId());
    }

    /*
     * testSetId():
     * - What we need: To ensure the "setId()" method correctly updates the inquirer's
     * id.
     * - Current result: 1.
     * - Expected result: "inquirer.getId()" should return 2.
     */
    @Test
    public void testSetId() {
        int newExpectedId = 2;
        inquirer.setId(newExpectedId);
        assertEquals("setId should update the id", newExpectedId, inquirer.getId());
    }

    /*
     * testGetFirstName:
     * - What we need: To ensure the "getFirstName()" method correctly returns the
     * actual inquirer's first name.
     * - Current result: "Joseph".
     * - Expected result: "inquirer.getFirstName()" should return "Joseph".
     */
    @Test
    public void testGetFirstName() {
        assertEquals("getFirstName() should return inquirer's first name", expectedFirstName, inquirer.getFirstName());
    }

    /*
     * testGetLastName:
     * - What we need: To confirm that the "getLastName()" method accurately returns
     * inquirer's last name.
     * - Current result:"Bouillon".
     * - Expected result: "inquirer.getLastName()" should return "Bouillon".
     */
    @Test
    public void testGetLastName() {
        assertEquals("getLastName() should return inquirer's last name", expectedLastName, inquirer.getLastName());
    }

    /*
     * testGetServicesPhoneNum**:
     * - What we need: To confirm that "getServicesPhoneNum()" method correctly
     * returns the services phone number.
     * - Current result: "+1-123-456-7890".
     * - Expected result: "inquirer.getServicesPhoneNum()" should return
     * "+1-123-456-7890".
     */
    @Test
    public void testGetServicesPhoneNum() {

        assertEquals("getServicesPhoneNum() should return the correct Services Number", expectedPhoneNumber,
                inquirer.getServicesPhoneNum());
    }

    /*
     * testGetInfo:
     * - What we need: To confirm that "getInfo()" method retrieves the correct
     * information string.
     * - Current result: "looking for my family members".
     * - Expected result: "inquirer.getInfo()" should return the string
     * "looking for my family members".
     */
    @Test
    public void testGetInfo() {
        assertEquals("getInfo() should return the inquirer message", expectedMessage, inquirer.getInfo());
    }


    /*
    * testAddInteraction:
    * - What we need: To ensure the "addInteraction()" method correctly adds an interaction to the interaction log.
    * - Current result: After calling "addInteraction('Interaction 1')", the interaction log should contain 'Interaction 1'.
    * - Expected result: "inquirer.getInteractionLog()" should return a list containing 'Interaction 1'.
    */
    @Test
    public void testAddInteraction() {
        String interaction = "Interaction 1";
        inquirer.addInteraction(interaction);
        assertTrue("addInteraction should add the interaction to the interaction log", inquirer.getInteractionLog().contains(interaction));
    }

    /*
    * testGetInteractionLog:
    * - What we need: To ensure the "getInteractionLog()" method correctly returns the interaction log.
    * - Current result: After calling "addInteraction('Interaction 1')", the interaction log should contain 'Interaction 1'.
    * - Expected result: "inquirer.getInteractionLog()" should return a list containing 'Interaction 1'.
    */
    @Test
    public void testGetInteractionLog() {
        String interaction = "Interaction 1";
        inquirer.addInteraction(interaction);
        assertTrue("getInteractionLog should return the interaction log", inquirer.getInteractionLog().contains(interaction));
    }
}
