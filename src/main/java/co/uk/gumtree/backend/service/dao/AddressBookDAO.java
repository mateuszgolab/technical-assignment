package co.uk.gumtree.backend.service.dao;

import co.uk.gumtree.backend.configuration.Config;
import co.uk.gumtree.backend.model.AddressBook;
import co.uk.gumtree.backend.service.mapping.AddressBookCsvMapper;
import co.uk.gumtree.backend.service.utils.CsvManager;

import java.util.List;
import java.util.stream.Collectors;

public class AddressBookDAO implements DAO<AddressBook>{

    private Config config;

    public AddressBookDAO(Config config) {
        this.config = config;
    }

    @Override
    public List<AddressBook> getAll() {

        List<List<String>> csvData = CsvManager.read(config.getPath());

        return csvData.stream().
                map(AddressBookCsvMapper::map).
                collect(Collectors.toList());
    }

}
