package edu.ucalgary.oop;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;


public class DisasterVictim {
    private static int counter = 0;

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Integer age;
    private String comments;
    private final int ASSIGNED_SOCIAL_ID;
    private Set<MedicalRecord> medicalRecords = new HashSet<>();
    private List<FamilyRelation> familyConnections = new ArrayList<>();
    private List<Supply> personalBelongings = new ArrayList<>();
    private final String ENTRY_DATE;
    private String gender;
    private List<String> genderOptions = new ArrayList<>();
    private List<DietaryRestriction> dietaryRestrictions = new ArrayList<>();


    public DisasterVictim(String firstName, String ENTRY_DATE) {
        this.firstName = firstName;
        if (!isValidDateFormat(ENTRY_DATE)) {
            throw new IllegalArgumentException("Invalid date format for entry date. Expected format: YYYY-MM-DD");
        }
        this.ENTRY_DATE = ENTRY_DATE;
        this.ASSIGNED_SOCIAL_ID = generateSocialID();
        
    }

    private static int generateSocialID() {
        counter++;
        return counter;
    }

    private static boolean isValidDateFormat(String date) {
        String dateFormatPattern = "^\\d{4}-\\d{2}-\\d{2}$";
        return date.matches(dateFormatPattern);
    }

  
    // Getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        String dateAsString = dateOfBirth.toString();
        if (!isValidDateFormat(dateAsString)) {
            throw new IllegalArgumentException("Invalid date format for date of birth. Expected format: YYYY-MM-DD");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public int getAssignedSocialID() {
        return ASSIGNED_SOCIAL_ID;
    }

    public List<FamilyRelation> getFamilyConnections() {
        return familyConnections;
    }

    public Set<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public List<Supply> getPersonalBelongings() {
        return this.personalBelongings;
    }

    // The add and remove methods remain correct.
    
    // Correct the setters to accept Lists instead of arrays
    public void setFamilyConnections(List<FamilyRelation> connections) {
        this.familyConnections = connections;
    }

    public void setMedicalRecords(Set<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public void setPersonalBelongings(List<Supply> belongings) {
        this.personalBelongings = belongings;
    }


    // Add a Supply to personalBelonging
    public void addPersonalBelonging(Supply supply) {
        if (this.personalBelongings == null) {
            this.personalBelongings = new ArrayList<>();
        }
        this.personalBelongings.add(supply);
    }
    // Remove a Supply from personalBelongings, we assume it only appears once
    public void removePersonalBelonging(Supply unwantedSupply) {
        personalBelongings.remove(unwantedSupply);
    }


    public void removeFamilyConnection(FamilyRelation exRelation) {
        familyConnections.remove(exRelation);
    }

    public void addFamilyConnection(FamilyRelation record) {
        familyConnections.add(record);
    }


    // Add a MedicalRecord to medicalRecords
    public void addMedicalRecord(MedicalRecord record) {
        medicalRecords.add(record);
    }

    public String getEntryDate() {
        return ENTRY_DATE;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments =  comments;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (!gender.matches("(?i)^(male|female|other)$")) {
            throw new IllegalArgumentException("Invalid gender. Acceptable values are male, female, or other.");
        }
        this.gender = gender.toLowerCase(); // Store in a consistent format
    }

    public List<String> getGenderOptions() {
        return genderOptions;
    }

    public void loadGenderOptionsFromFile(String fileName) {
        try {
            genderOptions = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<DietaryRestriction> getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public void setDietaryRestrictions(List<DietaryRestriction> dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }

    public static enum DietaryRestriction {
        AVML,
        DBML,
        GFML,
        KSML,
        LSML,
        MOML,
        PFML,
        VGML,
        VJML
    }




   
}





