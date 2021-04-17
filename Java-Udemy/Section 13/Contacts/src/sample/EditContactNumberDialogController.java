package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.ContactModel.Contact;

public class EditContactNumberDialogController {
    @FXML
    private TextField contactNumber;

    public Contact processResult(Contact oldContact){

        Contact newItem = new Contact(oldContact.getFirstName(),oldContact.getLastName(),
                contactNumber.getText().trim(),oldContact.getNotes());

        return newItem;
    }
}
