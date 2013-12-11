package ch.bfh.btx8081.w2013.green.data;

import java.util.ArrayList;
import java.util.List;

public class FakeDataAccess implements IProfessionalDataAccess {

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

        patients = new ArrayList<Patient>();

        Patient p1 = new Patient(1, "Traurig", "Vreni");
        Patient p2 = new Patient(1, "Sensibel", "Hans");
        Patient p3 = new Patient(1, "Depro", "Freddy");
        Patient p4 = new Patient(1, "Borderline", "Meieli");

        p1.setCustomContacts(generateContacts());
        p1.setCustomMedications(generateMedications());

        p2.setCustomContacts(generateContacts());
        p2.setCustomMedications(generateMedications());

        p3.setCustomContacts(generateContacts());
        p3.setCustomMedications(generateMedications());

        p4.setCustomContacts(generateContacts());
        p4.setCustomMedications(generateMedications());


        patients.add(p1);
        patients.add(p2);
        patients.add(p3);
        patients.add(p4);

        return patients;
    }

    private List<Contact> generateContacts() {
        contacts = new ArrayList<Contact>();

        Contact c1 = new Contact(1, "Psychologist", "Dr. Lieb", "Fritz", "123 123 12 34");
        Contact c2 = new Contact(1, "Doctor", "Dr. Heil", "Hans", "123 123 12 35");
        Contact c3 = new Contact(1, "Helping Hand", "Help", "Please", "123 123 23 45");
        Contact c4 = new Contact(1, "Professional", "Hilfreich", "Wanda", "123 123 67 89");

        contacts.add(c1);
        contacts.add(c2);
        contacts.add(c3);
        contacts.add(c4);

        return contacts;
    }

    private List<Medication> generateMedications() {
        medics = new ArrayList<Medication>();

        Medication m1 = new Medication("Dafalgan", new int[]{1,1,0},1);
        Medication m2 = new Medication("Antidepressiva", new int[]{0,1,0},2);
        Medication m3 = new Medication("Tranquillanzium", new int[]{1,1,1},3);
        Medication m4 = new Medication("Antidementivum", new int[]{0,0,1},4);

        medics.add(m1);
        medics.add(m2);
        medics.add(m3);
        medics.add(m4);

        return medics;
        
    }

    @Override
    public List<Patient> getPatients() {
        return patients;
    }

    @Override
    public List<Medication> getMedications() {
        return medics;
    }

    @Override
    public List<Skill> getSkills() {
        return skills;
    }

    @Override
    public List<Contact> getContacts() {
        return contacts;
    }

}
