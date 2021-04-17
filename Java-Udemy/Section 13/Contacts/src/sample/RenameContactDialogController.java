package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.ContactModel.Contact;

public class RenameContactDialogController {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;

    public Contact processResult(Contact oldContact){

        if(firstName.getText().toString().trim().equals("")){
            firstName.setText(oldContact.getFirstName().toString().trim());
        }if (lastName.getText().toString().trim().equals("")){
            lastName.setText(oldContact.getLastName().toString().trim());
        }

        Contact newItem = new Contact(firstName.getText().trim(),lastName.getText().trim(),
                oldContact.getPhoneNumber(),oldContact.getNotes());

        return newItem;
    }
}
