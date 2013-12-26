package ch.bfh.btx8081.w2013.green.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int contactId = -1;
    private String profession = null;
    private String name = null;
    private String forename = null;
    private String phoneNumber = null;

    public Contact() {}

    public Contact(int id, String profession, String name, String forename, String phoneNumber) {

        this.contactId = id;
        this.profession = profession;
        this.name = name;
        this.forename = forename;
        this.phoneNumber = phoneNumber;
    }

    public int getContactId() {
        return contactId;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return
                "Profession: " + profession + "\n\r" +
                "Name: " + name  + ", " + forename + "\n\r" +
                "Phone: " + "<a href=\"tel:" + phoneNumber + "\">Tel: " + phoneNumber + "</a>\n\r";
    }
}
