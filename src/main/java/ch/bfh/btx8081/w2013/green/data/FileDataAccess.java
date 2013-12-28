package ch.bfh.btx8081.w2013.green.data;

import ch.bfh.btx8081.w2013.green.data.entities.Contact;
import ch.bfh.btx8081.w2013.green.data.entities.Medication;
import ch.bfh.btx8081.w2013.green.data.entities.Patient;
import ch.bfh.btx8081.w2013.green.data.entities.Skill;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Class Description</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 27-12-2013
 */
public class FileDataAccess implements IDataAccess, ISettingsDataAccess {

    private final static String BASE_PATH = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();

    private final static String CONTACTS_FILE         = "storage/contacts.txt";
    private final static String SKILLS_FILE           = "storage/skills.txt";
    private final static String MEDICATIONS_FILE      = "storage/medications.txt";
    private final static String PATIENTS_FILE         = "storage/patients.txt";
    private final static String REGISTERED_USERS_FILE = "storage/registered_users.txt";

    private FileInputStream fileInputStream = null;
    private FileOutputStream fileOutputStream = null;
    private List<Medication> medicationList = new ArrayList<>();
    private List<Skill> skillList = new ArrayList<>();
    private List<Contact> contactList = new ArrayList<>();
    private List<Patient> patientList = new ArrayList<>();


    public FileDataAccess() {

        ///Users/Johannes/Daten/04_Projekte/04_dev/spielwiese/ch.bfh.btx8081.w2013.green/src/main/webapp
        File aFile = new File(BASE_PATH + MEDICATIONS_FILE);

        medicationList = loadMedicationsFromFile();
        skillList = null;
        contactList = loadContactsFromFile();
        patientList = loadPatientsFromFile();
    }

    private BufferedReader openFile(String file) {

        try {
            this.fileInputStream = new FileInputStream(file);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);

            return new BufferedReader(new InputStreamReader(dataInputStream));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void CloseReader() {
        try {

            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Medication> getMedications(int userId) {
        for (Patient patient : patientList) {
            if (patient.getUserId() == userId) {
                return patient.getCustomMedications();
            }
        }

        return null;
    }

    @Override
    public List<Skill> getSkills(int userId) {
        for (Patient patient : patientList) {
            if (patient.getUserId() == userId) {
                return patient.getCustomSkills();
            }
        }

        return null;
    }

    @Override
    public List<Contact> getContacts(int userId) {
        for (Patient patient : patientList) {
            if (patient.getUserId() == userId) {
                return patient.getCustomContacts();
            }
        }

        return null;
    }

    @Override
    public List<Patient> getPatients() {
        return patientList;
    }


    @Override
    public List<Skill> getSkills() {

        throw new NotImplementedException();

    }

    @Override
    public List<Contact> getContacts() {
        return contactList;

    }

    @Override
    public List<Medication> getMedications() {
        return medicationList;
    }

    private List<Patient> loadPatientsFromFile() {
        List<Patient> patients = new ArrayList<>();

        BufferedReader bufferedReader = openFile(PATIENTS_FILE);

        String line;

        try {
            while ((line  = bufferedReader.readLine()) != null) {
                String[] patient = line.split(";");


                List<Medication> customMedications = null;
                if (!patient[4].equals("-")) {
                    String ids = patient[4];
                    String[] medicsIds = patient[4].length() == 1 ? new String[] {ids} : ids.split("\\$");
                    customMedications = new ArrayList<>();
                    for (String medicsId : medicsIds) {
                        int id = Integer.parseInt(medicsId);
                        customMedications.add(getMediationById(id));
                    }
                }

                List<Contact> customContacts = null;
                if (!patient[5].equals("-")) {
                    String[] contactsIds = patient[5].length() == 1 ? new String[] {patient[5]} : patient[5].split("\\$");
                    customContacts = new ArrayList<>();
                    for (String contactsId : contactsIds) {
                        int id = Integer.parseInt(contactsId);
                        customContacts.add(getContactById(id));
                    }
                }

                List<Skill> customSkills = null;
                if (!patient[6].equals("-")) {
                    String[] skillsIds = patient[6].length() == 1 ? new String[] {patient[6]} : patient[6].split("\\$");
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
                System.out.println(aPatient.toString());
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

    private List<Medication> loadMedicationsFromFile() {
        List<Medication> medications = new ArrayList<>();

        BufferedReader bufferedReader = openFile(MEDICATIONS_FILE);

        String line;

        try {
            while ((line  = bufferedReader.readLine()) != null) {
                String[] medication = line.split(";");
                
                String name = medication[0];
                int id = Integer.parseInt(medication[4]);
                int morning = Integer.parseInt(medication[1].trim());
                int noon = Integer.parseInt(medication[2].trim());
                int evening = Integer.parseInt(medication[3].trim());
                
                
                Medication aMedication = new Medication(
                        medication[0],
                        new int[] {
                                Integer.parseInt(medication[1].trim()),
                                Integer.parseInt(medication[2].trim()),
                                Integer.parseInt(medication[3].trim())
                        },
                        Integer.parseInt(medication[4].trim()));
                medications.add(aMedication);
                System.out.println(aMedication.toString());
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


    private List<Contact> loadContactsFromFile() {
        List<Contact> contacts = new ArrayList<>();

        BufferedReader bufferedReader = openFile(CONTACTS_FILE);

        String line;

        try {
            while ((line  = bufferedReader.readLine()) != null) {
                String[] contact = line.split(";");
                Contact aContact = new Contact(Integer.parseInt(contact[0]),contact[1],contact[2],contact[3],contact[4]);
                contacts.add(aContact);
                System.out.println(aContact.toString());
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


    private Skill getSkillById(int id) {

        for (Skill skill : skillList) {
            if (skill.getSkillId() == id) {
                return  skill;
            }
        }

        return null;
    }

    private Contact getContactById(int id) {

        for (Contact contact : contactList) {
            if (contact.getContactId() == id) {
                return contact;
            }
        }

        return null;
    }

    private Medication getMediationById(int id) {

        for (Medication medication : medicationList) {
            if (medication.getMedicationID() == id) {
                return medication;
            }
        }

        return null;
    }

    

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

                //TODO: if null => - als platzhalter verwenden

                if (patient.getCustomMedications() != null) {
                    for (Medication medication : patient.getCustomMedications()) {
                        medics += medication.getMedicationID() + "$";
                    }
                    medics = medics.substring(0,medics.length()-1);
                } else {
                    medics = "-";
                }

                if (patient.getCustomContacts() != null) {
                    for (Contact contact : patient.getCustomContacts()) {
                        contacts += contact.getContactId() + "$";
                    }
                    contacts = contacts.substring(0, contacts.length()-1);
                } else {
                    contacts = "-";
                }

                if (patient.getCustomSkills() != null) {
                    for (Skill skill : patient.getCustomSkills()) {
                        skills += skill.getSkillId() + "$";
                    }
                    skills = skills.substring(0, skills.length()-1);
                } else {
                    skills = "-";
                }

                patientString +=
                patient.getPatientId() + ";" +
                patient.getUserId() + ";" +
                patient.getName() + ";" +
                patient.getForename() + ";" +
                medics + ";" +
                contacts + ";" +
                skills + "\n";


            }

            printWriter.write(patientString);
            printWriter.close();
            
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
