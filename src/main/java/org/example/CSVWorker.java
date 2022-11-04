package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVWorker {
    private final String fileName = "C:\\Users\\TastePate\\Downloads\\Electric_Vehicle_Population_Data.csv";

    public ArrayList<Vehicle> getCorrectCSVData(){
        try (CSVParser parser = getParser()) {
            ArrayList<Vehicle> csvNotes = new ArrayList<>();
            for (CSVRecord record : parser) {
                    if (record.size() != 17)
                        continue;
                    csvNotes.add(new Vehicle(
                            record.get(0), record.get(1),record.get(2),record.get(3),record.get(4),
                            record.get(5),record.get(6),record.get(7),record.get(8),record.get(9),
                            record.get(10),record.get(11),record.get(12),record.get(13),record.get(14),record.get(15)));
            }
            return csvNotes;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void writeCSVData(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        if (!Files.exists(path))
            Files.createFile(path);
        try (CSVParser parser = getParser();
             CSVPrinter printer = new CSVPrinter(new FileWriter(fileName), CSVFormat.DEFAULT)) {
            for (CSVRecord record : parser) {
                if (record.size() != 17)
                    continue;
                printer.printRecord(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CSVParser getParser() throws IOException {
        InputStreamReader input = new InputStreamReader(new FileInputStream(this.fileName));
        return CSVFormat.DEFAULT.parse(input);
    }
}
