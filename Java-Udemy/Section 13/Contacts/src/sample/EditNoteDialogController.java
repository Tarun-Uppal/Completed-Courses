package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.ContactModel.Contact;

public class EditNoteDialogController {
    @FXML
    private TextField newNote;

    public Contact processResult(Contact oldContact){
        Contact newItem = new Contact(oldContact.getFirstName(),oldContact.getLastName()
                ,oldContact.getPhoneNumber(),newNote.getText().trim());
        return newItem;
    }
}
