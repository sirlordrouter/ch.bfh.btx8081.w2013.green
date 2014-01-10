package ch.bfh.btx8081.w2013.green.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>
 * Describes an Contact for a Patient, which he can contact in difficult situations.
 * For this reason just a few information is needed, like name & phone number.
 * </p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 28-12-2013
 */
@Entity
public class Contact implements Comparable {

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
        return this.contactId;
    }

    public String getProfession() {
        return this.profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName( ) {
        return this.name + ", " + this.forename;
    };

    public String getPhoneNumberHtml() {
        return "Phone: " + "<a href=\"tel:" + this.phoneNumber + "\">Tel: " + this.phoneNumber + "</a>\n\r";
    }

    /**
     * Formats the Contact to a HTML String, so that the phone number
     * can be used with Skype or something similar.
     *
     * @return
     *      HTML String
     */
    @Override
    public String toString() {
        return
                "Profession: " + this.profession + "\n\r" +
                "Name: " + this.name  + ", " + this.forename + "\n\r" +
                "Phone: " + "<a href=\"tel:" + this.phoneNumber + "\">Tel: " + this.phoneNumber + "</a>\n\r";
    }

    /**
     * Sorts the Contact by its Name
     * @param o
     *  another Contact
     * @return
     *
     */
    @Override
    public int compareTo(Object o) {
        Contact c = (Contact) o;
        return this.getName().compareTo(((Contact) o).getName());
    }
}
