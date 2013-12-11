package ch.bfh.btx8081.w2013.green.data;

import ch.bfh.btx8081.w2013.green.data.entities.Contact;
import ch.bfh.btx8081.w2013.green.data.entities.Medication;
import ch.bfh.btx8081.w2013.green.data.entities.Skill;

import java.util.List;

public interface IDataAccess {

    List<Medication> getMedications();
    List<Skill> getSkills();
    List<Contact> getContacts();
}
