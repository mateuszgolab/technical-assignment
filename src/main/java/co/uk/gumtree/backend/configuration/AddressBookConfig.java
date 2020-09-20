package co.uk.gumtree.backend.configuration;

public class AddressBookConfig implements Config {

    static final String AddressBookFilePath = "src/main/resources/AddressBook";

    public String getPath() {
        return AddressBookFilePath;
    }

}
