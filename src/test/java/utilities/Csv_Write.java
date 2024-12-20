package utilities;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Csv_Write {

    public static void writeToCSV(List<Map<String, Object>> dataList, String filePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            // Write header
            String[] header = {"OrganizationID", "OrgName", "LocName", "LocationID"};
            writer.writeNext(header);

            // Write data
            for (Map<String, Object> data : dataList) {
                String[] line = {
                        data.get("OrganizationID").toString(),
                        data.get("OrganizationName").toString(),
                        data.get("LocationName").toString(),
                        data.get("LocationID").toString(),

                };
                writer.writeNext(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
