package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.ContactModel.Contact;
import sample.ContactModel.ContactData;

public class addContactDialogController {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField notes;
    @FXML
    private TextField phoneNumber;
    private Contact contact;

    public Contact processResult(){
        String firstName = this.firstName.getText().trim();
        String lastName = this.lastName.getText().trim();
        String notes = this.notes.getText().trim();
        String phoneNumber = this.phoneNumber.getText().trim();

        Contact newItem = new Contact(firstName,lastName,phoneNumber,notes);
        contact = newItem;
        return newItem;
    }
}
