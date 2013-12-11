package ch.bfh.btx8081.w2013.green.data;

import java.util.List;

public interface IDataAccess {

    List<Medication> getMedications();
    List<Skill> getSkills();
    List<Contact> getContacts();
}
