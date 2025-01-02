package utilities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Csv_reader {

    public  static  String OrgID;
    public static  String LocID;
    public static  String LocationName;
    public static String organizationName;


    public static List<List<String>>  ReadCsvData() {
        String filePath ="C:\\Users\\adit\\IdeaProjects\\AdminPanelClientDetailsFetch\\src\\test\\java\\utilities\\OrganizationLocation.csv";
        List<List<String>> credentials = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read the header row (and discard it)
            String[] headerRow = reader.readNext();
            // Read all rows at once
            List<String[]> data = reader.readAll();

            // Iterate over each row
            for (String[] row : data) {
                List<String> credential = new ArrayList<>();
                // Assuming the first column is username and the second column is password
                organizationName =row[0];
                LocationName=row[1];

                credential.add(organizationName);
                credential.add(LocationName);
                credentials.add(credential);
                System.out.println(credential);

            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        return credentials;
    }
}

