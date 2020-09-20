package co.uk.gumtree.backend.service.dao;

import co.uk.gumtree.backend.configuration.Config;
import co.uk.gumtree.backend.model.AddressBook;
import co.uk.gumtree.backend.model.Gender;
import co.uk.gumtree.backend.service.mapping.AddressBookCsvMapper;
import co.uk.gumtree.backend.service.utils.CsvManager;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBookDAO implements DAO<AddressBook> {

    private Config config;

    public AddressBookDAO(Config config) {
        this.config = config;
    }

    private Stream<AddressBook> loadAllData() {
        return CsvManager.
                read(config.getPath()).
                stream().
                map(AddressBookCsvMapper::map);
    }

    @Override
    public List<AddressBook> getAll() {
        return loadAllData().collect(Collectors.toList());
    }

    @Override
    public List<AddressBook> getByGender(Gender gender) {
        return loadAllData().
                filter(a -> a.getGender() == gender).
                collect(Collectors.toList());
    }

    @Override
    public List<AddressBook> getByFirstName(String firstName) {
        return loadAllData().
                filter(a -> a.getFirstName().equals(firstName)).
                collect(Collectors.toList());
    }

}
