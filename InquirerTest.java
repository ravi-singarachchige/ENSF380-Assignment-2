package edu.ucalgary.oop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InquirerTest {
    private Inquirer inquirer;

    @BeforeEach
    public void setUp() {
        inquirer = new Inquirer("John", "Doe", "1234567890", "Information");
    }

    @Test
    public void testGetFirstName() {
        assertEquals("John", inquirer.getFirstName());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Doe", inquirer.getLastName());
    }

    @Test
    public void testGetServicesPhoneNum() {
        assertEquals("1234567890", inquirer.getServicesPhoneNum());
    }

    @Test
    public void testGetInfo() {
        assertEquals("Information", inquirer.getInfo());
    }
}