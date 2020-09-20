package co.uk.gumtree.backend.service;

import co.uk.gumtree.backend.model.AddressBook;
import co.uk.gumtree.backend.dao.DAO;

public class AddressBookService {

    private DAO<AddressBook> addressBookDAO;

    public AddressBookService(DAO<AddressBook> addressBookDAO) {
        this.addressBookDAO = addressBookDAO;
    }


}
