package sample.ContactModel;

import javafx.beans.property.SimpleStringProperty;

public class Contact {

    private String firstName = null;
    private String lastName = null;
    private String phoneNumber = null;
    private String notes = null;

    public Contact(String firstName, String lastName, String phoneNumber, String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
    }



    public Contact() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Contact " +
                "Name " + firstName + " " + lastName +
                "phoneNumber = " + phoneNumber +
                ", notes = " + notes;
    }
}
