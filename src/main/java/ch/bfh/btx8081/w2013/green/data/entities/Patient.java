package ch.bfh.btx8081.w2013.green.data.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Describes a Patient.</p>
 *
 * @author Esma Dagdas, dagde1@bfh.ch
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 *
 * @version 11-12-2013
 */
public class Patient implements Serializable {

    private int patientId = -1;
    private String name = null;
    private String forename = null;

    private List<Medication> customMedications = new ArrayList<Medication>();
    private List<Contact> customContacts = new ArrayList<Contact>();
    private List<Skill> customSkills = new ArrayList<Skill>();


    /**
     * default constructor
     */
    public Patient() {

    }

    public Patient(int id, String name, String forename) {

        this.patientId = id;
        this.name = name;
        this.forename = forename;

    }

    public Patient (int id, String name, String forename, List<Medication> customMedications,
                    List<Contact> customContacts, List<Skill> customSkills) {

         this(id, name, forename);

        this.customMedications = customMedications;
        this.customContacts = customContacts;
        this.customSkills = customSkills;

    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public List<Medication> getCustomMedications() {
        return customMedications;
    }

    public void setCustomMedications(List<Medication> customMedications) {
        this.customMedications = customMedications;
    }

    public List<Contact> getCustomContacts() {
        return customContacts;
    }

    public void setCustomContacts(List<Contact> customContacts) {
        this.customContacts = customContacts;
    }

    public List<Skill> getCustomSkills() {
        return customSkills;
    }

    public void setCustomSkills(List<Skill> customSkills) {
        this.customSkills = customSkills;
    }


}
