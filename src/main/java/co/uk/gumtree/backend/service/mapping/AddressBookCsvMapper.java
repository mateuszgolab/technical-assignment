package co.uk.gumtree.backend.service.mapping;

import co.uk.gumtree.backend.model.AddressBook;
import co.uk.gumtree.backend.model.Gender;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class AddressBookCsvMapper {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yy", Locale.ENGLISH);

    public static AddressBook map(List<String> csvRawData) {

        if (csvRawData.size() < 3) throw new IllegalArgumentException("cvs rows has less than 3 columns");

        String[] names = csvRawData.get(0).split(" ");
        Gender gender = mapGender(csvRawData.get(1));
        LocalDate dateOfBirth = mapDate(csvRawData.get(2));

        return new AddressBook(names[0], names[1], gender, dateOfBirth);

    }

    private static Gender mapGender(String genderAsString) {

        try {
            return Gender.valueOf(genderAsString.toUpperCase());
        } catch (IllegalArgumentException e) {
            return Gender.UNKNOWN;
        }
    }

    private static LocalDate mapDate(String dateAsString) {
        return LocalDate.parse(dateAsString, DATE_FORMATTER).minusYears(100);
    }

}
