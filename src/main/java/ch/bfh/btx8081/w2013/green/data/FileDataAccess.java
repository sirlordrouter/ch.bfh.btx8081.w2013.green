package ch.bfh.btx8081.w2013.green.data;

import ch.bfh.btx8081.w2013.green.data.entities.Contact;
import ch.bfh.btx8081.w2013.green.data.entities.Medication;
import ch.bfh.btx8081.w2013.green.data.entities.Patient;
import ch.bfh.btx8081.w2013.green.data.entities.Skill;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>
 * class for Retrieving all needed data stored in .txt files.
 *
 * </p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 27-12-2013
 */
public class FileDataAccess implements IDataAccess, ISettingsDataAccess {

    private final static String CONTACTS_FILE         = "storage/contacts.txt";
    private final static String SKILLS_FILE           = "storage/skills.txt";
    private final static String MEDICATIONS_FILE      = "storage/medications.txt";
    private final static String PATIENTS_FILE         = "storage/patients.txt";
    private final static String REGISTERED_USERS_FILE = "storage/registered_users.txt";

    private final static String ENTITY_SEPARATOR = ";";
    private final static String ID_SEPARATOR = "$";
    private final static String ID_SPLITTER = "\\$";
    private final static String PLACEHOLDER = "-";

    private FileInputStream fileInputStream = null;
    private FileOutputStream fileOutputStream = null;

    private List<Medication> medicationList = new ArrayList<>();
    private List<Skill> skillList = new ArrayList<>();
    private List<Contact> contactList = new ArrayList<>();
    private List<Patient> patientList = new ArrayList<>();


    /**
     * When initation the <code>FileDataAccess</code> all data is loaded from the files.
     * Medication, Skills and Contacts are not changing and are therefore loaded first.
     * Patients refer to the other entities and are loaded in the end.
     */
    public FileDataAccess() {
        this.medicationList = loadMedicationsFromFile();
        this.skillList = null;
        this.contactList = loadContactsFromFile();
        this.patientList = loadPatientsFromFile();
    }

    /**
     * Creates a Reader for the given file.
     * Execption handling when open the file is handled here.
     *
     * @param file a file to open
     * @return a BufferedReader for the given file.
     */
    private BufferedReader openFile(String file) {

        try {
            this.fileInputStream = new FileInputStream(file);
            DataInputStream dataInputStream = new DataInputStream(this.fileInputStream);

            return new BufferedReader(new InputStreamReader(dataInputStream));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Closes the Reader to make sure the Files are stored consistently.
     */
    private void CloseReader() {
        try {

            this.fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the Medications for a specific user.
     *
     * @param userId of the user
     * @return a List with his own medications
     */
    @Override
    public List<Medication> getMedications(int userId) {
        for (Patient patient : this.patientList) {
            if (patient.getUserId() == userId) {
                return patient.getCustomMedications();
            }
        }

        return null;
    }

    /**
     * Get the Skills for a specific user.
     * @param userId of the user
     * @return a List with his own Skills
     */
    @Override
    public List<Skill> getSkills(int userId) {
        for (Patient patient : this.patientList) {
            if (patient.getUserId() == userId) {
                return patient.getCustomSkills();
            }
        }

        return null;
    }

    /**
     * Get the Contacts for a specific user
     * @param userId of the user
     * @return a List with his own contacts
     */
    @Override
    public List<Contact> getContacts(int userId) {
        for (Patient patient : this.patientList) {
            if (patient.getUserId() == userId) {
                return patient.getCustomContacts();
            }
        }

        return null;
    }

    /**
     * Returns the initially loaded patients
     *
     * @return list of all patients
     */
    @Override
    public List<Patient> getPatients() {
        return this.patientList;
    }


    /**
     * Returns the initially loaded skills
     * @return list of all available skills
     */
    @Override
    public List<Skill> getSkills() {

        throw new NotImplementedException();

    }

    /**
     * Returns the initally loaded contacts
     * @return list of all available contacts
     */
    @Override
    public List<Contact> getContacts() {
        return this.contactList;

    }

    /**
     * Returns the initally loaded Medications
     * @return list of all available medications.
     */
    @Override
    public List<Medication> getMedications() {
        return medicationList;
    }

    /**
     * loads all patients from a textfile.
     * for every patient, it must be proved, if there is data for the specific
     * items (medication, skills, contacts).
     * In the file are only the ids for these items stored. For each id the item is
     * retrieved by another method.
     *
     * @return a list of all patients stored in the file
     */
    private List<Patient> loadPatientsFromFile() {
        List<Patient> patients = new ArrayList<>();

        BufferedReader bufferedReader = openFile(PATIENTS_FILE);

        String line;

        try {
            while ((line  = bufferedReader.readLine()) != null) {
                String[] patient = line.split(ENTITY_SEPARATOR);


                List<Medication> customMedications = null;
                if (!patient[4].equals("-")) {
                    String ids = patient[4];
                    String[] medicsIds = patient[4].length() == 1 ? new String[] {ids} : ids.split(ID_SPLITTER);
                    customMedications = new ArrayList<>();
                    for (String medicsId : medicsIds) {
                        int id = Integer.parseInt(medicsId);
                        customMedications.add(getMediationById(id));
                    }
                }

                List<Contact> customContacts = null;
                if (!patient[5].equals(PLACEHOLDER)) {
                    String[] contactsIds = patient[5].length() == 1 ? new String[] {patient[5]} : patient[5].split(ID_SPLITTER);
                    customContacts = new ArrayList<>();
                    for (String contactsId : contactsIds) {
                        int id = Integer.parseInt(contactsId);
                        customContacts.add(getContactById(id));
                    }
                }

                List<Skill> customSkills = null;
                if (!patient[6].equals(PLACEHOLDER)) {
                    String[] skillsIds = patient[6].length() == 1 ? new String[] {patient[6]} : patient[6].split(ID_SPLITTER);
                    customSkills = new ArrayList<>();
                    for (String skillsId : skillsIds) {
                        int id = Integer.parseInt(skillsId);
                        customSkills.add(getSkillById(id));
                    }
                }


                Patient aPatient = new Patient(
                        Integer.parseInt(patient[0]),
                        Integer.parseInt(patient[1]),
                        patient[2],
                        patient[3],
                        customMedications,
                        customContacts,
                        customSkills
                );
                patients.add(aPatient);
            }

            CloseReader();

            return patients;
        } catch (IOException e) {

            e.printStackTrace();
            return null;
        } finally {
            CloseReader();
        }
    }

    /**
     * Loads all available medications from the file.
     *
     * @return a list with all available medications
     */
    private List<Medication> loadMedicationsFromFile() {
        List<Medication> medications = new ArrayList<>();

        BufferedReader bufferedReader = openFile(MEDICATIONS_FILE);

        String line;

        try {
            while ((line  = bufferedReader.readLine()) != null) {
                String[] medication = line.split(ENTITY_SEPARATOR);

                Medication aMedication = new Medication(
                        medication[0],
                        new int[] {
                                Integer.parseInt(medication[1].trim()),
                                Integer.parseInt(medication[2].trim()),
                                Integer.parseInt(medication[3].trim())
                        },
                        Integer.parseInt(medication[4].trim()));
                medications.add(aMedication);

            }

            CloseReader();
            return medications;
        } catch (IOException e) {

            e.printStackTrace();
            return null;
        } finally {
            CloseReader();
        }
    }


    /**
     * Loads all available contacts from the file.
     *
     * @return a list with all available contacts
     */
    private List<Contact> loadContactsFromFile() {
        List<Contact> contacts = new ArrayList<>();

        BufferedReader bufferedReader = openFile(CONTACTS_FILE);

        String line;

        try {
            while ((line  = bufferedReader.readLine()) != null) {
                String[] contact = line.split(ENTITY_SEPARATOR);
                Contact aContact = new Contact(Integer.parseInt(contact[0]),contact[1],contact[2],contact[3],contact[4]);
                contacts.add(aContact);
            }

            CloseReader();
            return contacts;
        } catch (IOException e) {

            e.printStackTrace();
            return null;
        } finally {
            CloseReader();
        }
    }


    /**
     * returns the Skill corresponding to the given id.
     * @param id of a Skill
     * @return Skill with this id
     */
    private Skill getSkillById(int id) {

        for (Skill skill : this.skillList) {
            if (skill.getSkillId() == id) {
                return  skill;
            }
        }

        return null;
    }

    /**
     * returns the Contact corresponding to the given id.
     * @param id of a Contact
     * @return Contact with this id
     */
    private Contact getContactById(int id) {

        for (Contact contact : this.contactList) {
            if (contact.getContactId() == id) {
                return contact;
            }
        }

        return null;
    }

    /**
     * returns the Medication corresponding to the given id.
     * @param id of a Medication
     * @return Medication with this id
     */
    private Medication getMediationById(int id) {

        for (Medication medication : this.medicationList) {
            if (medication.getMedicationID() == id) {
                return medication;
            }
        }

        return null;
    }


    /**
     * Stores all patients from a given list to the file.
     * For each of its items, only the Ids are stored with the patient.
     *
     * @param aPatientList the list of all patients with their items.
     */
    @Override
    public void setPatients(List<Patient> aPatientList) {


        try {
            BufferedWriter printWriter = new BufferedWriter(
                    new OutputStreamWriter(
                    new FileOutputStream(PATIENTS_FILE), "utf-8")
            );


            String patientString = "";

            for (Patient patient : aPatientList) {
                
                String medics = "";
                String contacts = "";
                String skills = "";

                /**
                 * for every item it must be defined, if there is any data stored.
                 * if not, a place holder must be stored.
                 * Every Id of an item is separated with an $
                 *
                 */

                if (patient.getCustomMedications() != null) {
                    for (Medication medication : patient.getCustomMedications()) {
                        medics += medication.getMedicationID() + ID_SEPARATOR;
                    }
                    medics = medics.substring(0,medics.length()-1);
                } else {
                    medics = PLACEHOLDER;
                }

                if (patient.getCustomContacts() != null) {
                    for (Contact contact : patient.getCustomContacts()) {
                        contacts += contact.getContactId() + ID_SEPARATOR;
                    }
                    contacts = contacts.substring(0, contacts.length()-1);
                } else {
                    contacts = PLACEHOLDER;
                }

                if (patient.getCustomSkills() != null) {
                    for (Skill skill : patient.getCustomSkills()) {
                        skills += skill.getSkillId() + ID_SEPARATOR;
                    }
                    skills = skills.substring(0, skills.length()-1);
                } else {
                    skills = PLACEHOLDER;
                }

                patientString +=
                patient.getPatientId() + ENTITY_SEPARATOR +
                patient.getUserId() + ENTITY_SEPARATOR +
                patient.getName() + ENTITY_SEPARATOR +
                patient.getForename() + ENTITY_SEPARATOR +
                medics + ENTITY_SEPARATOR +
                contacts + ENTITY_SEPARATOR +
                skills + "\n";


            }

            printWriter.write(patientString);
            printWriter.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
