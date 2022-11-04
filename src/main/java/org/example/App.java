package org.example;

import org.postgresql.util.PSQLException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class App
{
    public static void main( String[] args ) throws IOException {
        CSVWorker csvWorker = new CSVWorker();
        ArrayList<Vehicle> notes = csvWorker.getCorrectCSVData();

        String url = "jdbc:postgresql://localhost:5432/vehicles";
        String user = "postgres";
        String password = "Pashkalol2003.";

        DatabaseWorker dbw = new DatabaseWorker(url, user, password);
        dbw.addTable();
        int errors = 0;
        for (Vehicle vehicle : notes.stream().skip(1).toList()) {
            try {
                dbw.addNote(vehicle);
                System.out.println("Success!");
            } catch (Exception e) {
                System.out.println("Something goes wrong!");
                errors++;
            }
        }
        System.out.println("Ошибки: " + errors);
    }
}
