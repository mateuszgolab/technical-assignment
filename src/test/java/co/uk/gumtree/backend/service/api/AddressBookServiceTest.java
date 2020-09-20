package co.uk.gumtree.backend.service.api;

import co.uk.gumtree.backend.configuration.AddressBookConfig;
import co.uk.gumtree.backend.configuration.Config;
import co.uk.gumtree.backend.model.AddressBook;
import co.uk.gumtree.backend.model.Gender;
import co.uk.gumtree.backend.service.dao.AddressBookDAO;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class AddressBookServiceTest {

    static AddressBookService service;

    @BeforeClass
    public static void init() {

        Config config = new AddressBookConfig();
        AddressBookDAO dao = new AddressBookDAO(config);
        service = new AddressBookService(dao);
    }


    /*
     * Bill McKnight, Male, 16/03/77
     * Paul Robinson, Male, 15/01/85
     * Gemma Lane, Female, 20/11/91
     * Sarah Stone, Female, 20/09/80
     * Wes Jackson, Male, 14/08/74
     */

    /**
     * 1. How many males are in the address book?
     */
    @Test
    public void testTask1() {

        // when
        long result = service.task1();

        // then
        assertThat(result, is(3L));

    }

    /**
     * 2. Who is the oldest person in the address book?
     */
    @Test
    public void testTask2() {

        // when
        Optional<AddressBook> result = service.task2();

        // then
        assertThat(result.isPresent(), is(true));

        AddressBook value = result.get();
        assertThat(value.getFirstName(), is("Wes"));
        assertThat(value.getLastName(), is("Jackson"));
        assertThat(value.getGender(), is(Gender.MALE));
        assertThat(value.getDateOfBirth(), is(LocalDate.parse("1974-08-14")));

    }

    /**
     * 3. How many days older is Bill than Paul?
     */
    @Test
    public void testTask3() {

        // when
        long result = service.task3();

        // then
        assertThat(result, is(2862L));

    }

}