package co.uk.gumtree.backend.service.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvManager {

    private static final String DELIMITER = ",";

    public static List<List<String>> read(String csvFilePath) {

        List<List<String>> content = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {

            String line = "";
            while ((line = reader.readLine()) != null) {
                List<String> row = Arrays.stream(line.split(DELIMITER)).
                        map(String::trim).
                        collect(Collectors.toList());

                content.add(row);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File: " + csvFilePath + " not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;

    }

}
