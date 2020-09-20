package co.uk.gumtree.backend.service.utils;

import co.uk.gumtree.backend.configuration.AddressBookConfig;
import co.uk.gumtree.backend.model.AddressBook;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CsvManagerTest {

    @Test
    public void testLoadCSV() {

        // given
        String path = new AddressBookConfig().getPath();

        // when
        List<List<String>> results = CsvManager.read(path);

        // then
        assertThat(results.size(), is(5));

        List<String> first = results.get(0);
        assertThat(first.get(0), is("Bill McKnight"));
        assertThat(first.get(1), is("Male"));
        assertThat(first.get(2), is("16/03/77"));

        List<String> last = results.get(4);
        assertThat(last.get(0), is("Wes Jackson"));
        assertThat(last.get(1), is("Male"));
        assertThat(last.get(2), is("14/08/74"));

    }

}