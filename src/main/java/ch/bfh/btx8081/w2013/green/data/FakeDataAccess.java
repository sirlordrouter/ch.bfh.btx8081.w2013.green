package ch.bfh.btx8081.w2013.green.data;

import ch.bfh.btx8081.w2013.green.data.entities.Contact;
import ch.bfh.btx8081.w2013.green.data.entities.Medication;
import ch.bfh.btx8081.w2013.green.data.entities.Patient;
import ch.bfh.btx8081.w2013.green.data.entities.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>A class that generates Sampledata for the different Usecase Scenarios.</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 06-01-2014
 */
public class FakeDataAccess implements ISettingsDataAccess, IDataAccess {

    private List<Patient> patients = new ArrayList<Patient>();

    private List<Medication> medics = new ArrayList<Medication>();
    private List<Skill> skills = new ArrayList<Skill>();
    private List<Contact> contacts = new ArrayList<Contact>();

    public FakeDataAccess() {

        generateContacts();
        generateMedications();
        generatePatients();
    }

    private List<Patient> generatePatients() {

        this.patients = new ArrayList<Patient>();

        Patient p1 = new Patient(1,1000, "Traurig", "Vreni");
        Patient p2 = new Patient(2,1010, "Sensibel", "Hans");
        Patient p3 = new Patient(3,1020, "Depro", "Freddy");
        Patient p4 = new Patient(4,1030, "Borderline", "Meieli");

        p1.setCustomContacts(generateContacts());
        p1.setCustomMedications(generateMedications());

        p2.setCustomContacts(generateContacts());
        p2.setCustomMedications(generateMedications());

        p3.setCustomContacts(generateContacts());
        p3.setCustomMedications(generateMedications());

        p4.setCustomContacts(generateContacts());
        p4.setCustomMedications(generateMedications());


        this.patients.add(p1);
        this.patients.add(p2);
        this.patients.add(p3);
        this.patients.add(p4);

        return this.patients;
    }

    private List<Contact> generateContacts() {
        this.contacts = new ArrayList<Contact>();

        Contact c1 = new Contact(1, "Psychologist", "Dr. Lieb", "Fritz", "123 123 12 34");
        Contact c2 = new Contact(1, "Doctor", "Dr. Heil", "Hans", "123 123 12 35");
        Contact c3 = new Contact(1, "Helping Hand", "Help", "Please", "123 123 23 45");
        Contact c4 = new Contact(1, "Professional", "Hilfreich", "Wanda", "123 123 67 89");

        this.contacts.add(c1);
        this.contacts.add(c2);
        this.contacts.add(c3);
        this.contacts.add(c4);

        return this.contacts;
    }

    private List<Medication> generateMedications() {
        this.medics = new ArrayList<Medication>();

        Medication m1 = new Medication("Dafalgan", new int[]{1,1,0},1);
        Medication m2 = new Medication("Antidepressiva", new int[]{0,1,0},2);
        Medication m3 = new Medication("Tranquillanzium", new int[]{1,1,1},3);
        Medication m4 = new Medication("Antidementivum", new int[]{0,0,1},4);

        this.medics.add(m1);
        this.medics.add(m2);
        this.medics.add(m3);
        this.medics.add(m4);

        return this.medics;
        
    }

    @Override
    public List<Patient> getPatients() {
        return this.patients;
    }

    @Override
    public List<Medication> getMedications() {
        return this.medics;
    }

    @Override
    public List<Skill> getSkills() {
        return this.skills;
    }

    @Override
    public List<Contact> getContacts() {
        return this.contacts;
    }

    @Override
    public void setPatients(List<Patient> patientList) {

    }

    @Override
    public List<Medication> getMedications(int PatientId) {
        for (Patient patient : this.patients) {
            if (patient.getUserId()  == PatientId) {
                return patient.getCustomMedications();
            }
        }

        return null;
    }

    @Override
    public List<Skill> getSkills(int PatientId) {
        for (Patient patient : this.patients) {
            if (patient.getUserId()  == PatientId) {
                return patient.getCustomSkills();
            }
        }

        return null;
    }

    @Override
    public List<Contact> getContacts(int PatientId) {
        for (Patient patient : this.patients) {
            if (patient.getUserId() == PatientId) {
                return patient.getCustomContacts();
            }
        }

        return null;
    }
}
