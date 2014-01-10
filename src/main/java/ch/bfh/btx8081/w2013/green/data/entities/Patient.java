package ch.bfh.btx8081.w2013.green.data.entities;

import javax.persistence.*;
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
 *
 * @version 11-12-2013
 */
@Entity
public class Patient implements Serializable, Comparable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int patientId = -1;
    private int userId = -1;
    private String name = null;
    private String forename = null;
    private String patientName = null;

    @OneToMany
    private List<Medication> customMedications = new ArrayList<Medication>();
    @OneToMany
    private List<Contact> customContacts = new ArrayList<Contact>();
    @OneToMany
    private List<Skill> customSkills = new ArrayList<Skill>();


    /**
     * default constructor
     */
    public Patient() {

    }

    public Patient(int id, int userId, String name, String forename) {

        this.patientId = id;
        this.userId = userId;
        this.name = name;
        this.forename = forename;
        this.patientName = name + ", " + forename;

    }

    public Patient (int id, int userId,String name, String forename, List<Medication> customMedications,
                    List<Contact> customContacts, List<Skill> customSkills) {

        this(id, userId, name, forename);

        this.customMedications = customMedications;
        this.customContacts = customContacts;
        this.customSkills = customSkills;

    }

    public int getPatientId() {
        return this.patientId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForename() {
        return this.forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public List<Medication> getCustomMedications() {
        return this.customMedications;
    }

    public void setCustomMedications(List<Medication> customMedications) {
        this.customMedications = customMedications;
    }

    public List<Contact> getCustomContacts() {
        return this.customContacts;
    }

    public void setCustomContacts(List<Contact> customContacts) {
        this.customContacts = customContacts;
    }

    public List<Skill> getCustomSkills() {
        return this.customSkills;
    }

    public void setCustomSkills(List<Skill> customSkills) {
        this.customSkills = customSkills;
    }

    /**
     * The full patient name for fast usage. Format "Name,Forename"
     *
     * @return
     *      formatted Person Name
     */
    public String getPatientName() {
        return this.patientName;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int compareTo(Object o) {
        Patient p = (Patient) o;
        return this.getName().compareTo(p.getName());
    }
}
