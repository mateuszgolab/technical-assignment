package co.uk.gumtree.backend.service.api;

import co.uk.gumtree.backend.model.AddressBook;
import co.uk.gumtree.backend.model.Gender;
import co.uk.gumtree.backend.service.dao.DAO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Optional;

public class AddressBookService {

    private static class DateOfBirthComparator implements Comparator<AddressBook> {
        @Override
        public int compare(AddressBook o1, AddressBook o2) {
            return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
        }
    }

    private DAO<AddressBook> addressBookDAO;

    public AddressBookService(DAO<AddressBook> addressBookDAO) {
        this.addressBookDAO = addressBookDAO;
    }

    /**
     * 1. How many males are in the address book?
     */
    public long task1() {
        return addressBookDAO.getByGender(Gender.MALE).size();
    }

    /**
     * 2. Who is the oldest person in the address book?
     */
    public Optional<AddressBook> task2() {

        return addressBookDAO.getAll().stream().
                min(new DateOfBirthComparator());
    }

    /**
     * 3. How many days older is Bill than Paul?
     */
    public long task3() {

        Optional<AddressBook> paul = addressBookDAO.getByFirstName("Paul").
                stream().
                findFirst();

        Optional<AddressBook> bill = addressBookDAO.getByFirstName("Bill").
                stream().
                findFirst();

        if (bill.isPresent() && paul.isPresent()) {

            LocalDate billBd = bill.get().getDateOfBirth();
            LocalDate paulBd = paul.get().getDateOfBirth();

            return ChronoUnit.DAYS.between(billBd, paulBd);

        }

        return -1;

    }


}
