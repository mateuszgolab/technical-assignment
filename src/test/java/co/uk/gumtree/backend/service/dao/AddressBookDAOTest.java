package co.uk.gumtree.backend.service.dao;

import co.uk.gumtree.backend.configuration.AddressBookConfig;
import co.uk.gumtree.backend.model.AddressBook;
import co.uk.gumtree.backend.model.Gender;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressBookDAOTest {

    @Test
    public void testLoadAll() {

        // given
        AddressBookConfig addressBookConfig = new AddressBookConfig();
        DAO<AddressBook> addressBookDAO = new AddressBookDAO(addressBookConfig);

        // when
        List<AddressBook> results = addressBookDAO.getAll();

        // then
        assertThat(results.size(), is(5));

        AddressBook first = results.get(0);
        assertThat(first.getFirstName(), is("Bill"));
        assertThat(first.getLastName(), is("McKnight"));
        assertThat(first.getGender(), is(Gender.MALE));
        assertThat(first.getDateOfBirth(), is(LocalDate.parse("1977-03-16")));

        AddressBook third = results.get(2);
        assertThat(third.getFirstName(), is("Gemma"));
        assertThat(third.getLastName(), is("Lane"));
        assertThat(third.getGender(), is(Gender.FEMALE));
        assertThat(third.getDateOfBirth(), is(LocalDate.parse("1991-11-20")));

    }

}