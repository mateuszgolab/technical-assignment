package co.uk.gumtree.backend.service.mapping;

import co.uk.gumtree.backend.model.AddressBook;
import co.uk.gumtree.backend.model.Gender;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

public class AddressBookCsvMapperTest {

    @Test
    public void testValidMapping() {

        // given
        List<String> input = Arrays.asList("Bill McKnight", "Male", "16/03/77");

        // when
        AddressBook result = AddressBookCsvMapper.map(input);

        // then
        assertNotNull(result);
        assertThat(result.getFirstName(), is("Bill"));
        assertThat(result.getLastName(), is("McKnight"));
        assertThat(result.getGender(), is(Gender.MALE));
        assertThat(result.getDateOfBirth(), is(LocalDate.parse("1977-03-16")));

    }

    @Test
    public void testMappingInvalidGender() {

        // given
        List<String> input = Arrays.asList("Bill McKnight", "abcd", "16/03/77");

        // when
        AddressBook result = AddressBookCsvMapper.map(input);

        // then
        assertNotNull(result);
        assertThat(result.getFirstName(), is("Bill"));
        assertThat(result.getLastName(), is("McKnight"));
        assertThat(result.getGender(), is(Gender.UNKNOWN));
        assertThat(result.getDateOfBirth(), is(LocalDate.parse("1977-03-16")));

    }

}