package ch.bfh.btx8081.w2013.green.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Describes a Patient.</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 *
 * @version 11-12-2013
 */
public class Patient {

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


}
