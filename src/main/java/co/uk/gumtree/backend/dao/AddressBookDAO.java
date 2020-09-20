package co.uk.gumtree.backend.dao;

import co.uk.gumtree.backend.model.AddressBook;

import java.util.ArrayList;
import java.util.List;

public class AddressBookDAO implements DAO<AddressBook> {

    @Override
    public List<AddressBook> getAll() {
        return new ArrayList<>();
    }

}
