package ch.bfh.btx8081.w2013.green.data.entities;


public class Contact {

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
}
