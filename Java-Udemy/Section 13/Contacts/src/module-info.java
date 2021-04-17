module Contacts {
    requires java.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;

    opens sample;
    opens sample.ContactModel;
}