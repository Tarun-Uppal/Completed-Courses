package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import sample.ContactModel.Contact;
import sample.ContactModel.ContactData;

import java.io.IOException;
import java.util.Optional;

public class Controller {
    @FXML
    private TableView<Contact> contacts;
    @FXML
    private BorderPane mainPanel;
    private ContactData contactData;


    public void initialize() {
        contactData = new ContactData();
        contacts.setItems(contactData.getContacts());
        contactData.loadContacts();
        contacts.setEditable(true);
    }

    @FXML
    public void deleteItem() {
        Contact item = contacts.getSelectionModel().getSelectedItem();
        if (item == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Please select a contact");
            alert.setHeaderText(null);
            alert.setContentText("Please select the contact you want to edit");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete todo Item");
            alert.setHeaderText("Delete item:" + item.getFirstName());
            alert.setContentText("Press OK to confirm or cancel to back out.");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && (result.get() == ButtonType.OK)) {
                contactData.deleteContact(item);
                contactData.saveContacts();
            }
        }
    }

    public void exit() {
        contactData.saveContacts();
        System.exit(0);
    }

    @FXML
    public void showAddContactDialog() {
        Dialog<ButtonType> dialog = new Dialog<ButtonType>();
        dialog.initOwner(mainPanel.getScene().getWindow());
        dialog.setTitle("Add a new contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("addContactDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            addContactDialogController containController = fxmlLoader.getController();
            Contact contact = containController.processResult();
            contactData.addContact(contact);
            contactData.saveContacts();
        }
    }

    public void renameContact() {
        Contact currentContact = contacts.getSelectionModel().getSelectedItem();
        if (currentContact == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Please select a contact");
            alert.setHeaderText(null);
            alert.setContentText("Please select the contact you want to edit");
            alert.showAndWait();
        } else {
            Dialog<ButtonType> dialog = new Dialog<ButtonType>();
            dialog.initOwner(mainPanel.getScene().getWindow());
            dialog.setTitle("Edit Contact " + currentContact.getFirstName());
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("RenameContactDialog.fxml"));
            try {
                dialog.getDialogPane().setContent(fxmlLoader.load());
            } catch (IOException e) {
                System.out.println("Couldn't load the dialog");
                e.printStackTrace();
                return;
            }
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

            Optional<ButtonType> result = dialog.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                RenameContactDialogController containController = fxmlLoader.getController();
                Contact newContact = containController.processResult(currentContact);
                contactData.addContact(newContact);
                contactData.deleteContact(currentContact);
                contactData.saveContacts();
            }
        }
    }

    public void editContactNumber() {
        Contact currentContact = contacts.getSelectionModel().getSelectedItem();
        if (currentContact == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Please select a contact");
            alert.setHeaderText(null);
            alert.setContentText("Please select the contact you want to edit");
            alert.showAndWait();
        } else {
            Dialog<ButtonType> dialog = new Dialog<ButtonType>();
            dialog.initOwner(mainPanel.getScene().getWindow());
            dialog.setTitle("Edit Contact number " + currentContact.getFirstName());
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("EditContactNumberDialog.fxml"));
            try {
                dialog.getDialogPane().setContent(fxmlLoader.load());
            } catch (IOException e) {
                System.out.println("Couldn't load the dialog");
                e.printStackTrace();
                return;
            }
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

            Optional<ButtonType> result = dialog.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                EditContactNumberDialogController containController = fxmlLoader.getController();
                Contact newContact = containController.processResult(currentContact);
                contactData.addContact(newContact);
                contactData.deleteContact(currentContact);
                contactData.saveContacts();
            }
        }
    }

    public void editNote() {
        Contact currentContact = contacts.getSelectionModel().getSelectedItem();
        if (currentContact == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Please select a contact");
            alert.setHeaderText(null);
            alert.setContentText("Please select the contact you want to edit");
            alert.showAndWait();
        } else {
            Dialog<ButtonType> dialog = new Dialog<ButtonType>();
            dialog.initOwner(mainPanel.getScene().getWindow());
            dialog.setTitle("Edit Contact number " + currentContact.getFirstName());
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("EditNoteDialog.fxml"));
            try {
                dialog.getDialogPane().setContent(fxmlLoader.load());
            } catch (IOException e) {
                System.out.println("Couldn't load the dialog");
                e.printStackTrace();
                return;
            }
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

            Optional<ButtonType> result = dialog.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                EditNoteDialogController containController = fxmlLoader.getController();
                Contact newContact = containController.processResult(currentContact);
                contactData.addContact(newContact);
                contactData.deleteContact(currentContact);
                contactData.saveContacts();
            }
        }
    }
}