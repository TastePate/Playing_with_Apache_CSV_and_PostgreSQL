package org.example;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseWorker {
    private final String url;
    private final String user;
    private final String password;

    public DatabaseWorker(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void addTable() {
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            assert con != null;

            Statement statement = con.createStatement();
            statement.execute("DROP TABLE IF EXISTS VEHICLES;" +
                    "" +
                    "CREATE TABLE VEHICLES" +
                    "(" +
                    "UID SERIAL," +
                    "VIN VARCHAR(11) NOT NULL," +
                    "COUNTRY VARCHAR(20) NOT NULL," +
                    "CITY VARCHAR(20) NOT NULL," +
                    "STATE VARCHAR(4) NOT NULL," +
                    "POSTAL_CODE INT NOT NULL," +
                    "MODEL_YEAR SMALLINT NOT NULL," +
                    "MAKE VARCHAR(15) NOT NULL," +
                    "ELECTRIC_VEHICLE_TYPE VARCHAR(20) NOT NULL," +
                    "CAFV_ELIGIBILITY VARCHAR(100) NOT NULL," +
                    "ELECTRIC_RANGE VARCHAR(100) NOT NULL," +
                    "BASE_MSPR SMALLINT NOT NULL," +
                    "LEGISLATIVE_DISTRICT INTEGER NOT NULL," +
                    "DOL_VEHICLE_ID SMALLINT NOT NULL," +
                    "LOCATION INTEGER NOT NULL," +
                    "ELECTRIC_UTILITY VARCHAR(100) NOT NULL," +
                    "CENSUS_TRACT VARCHAR(150) NOT NULL," +
                    "PRIMARY KEY (UID)" +
                    ")"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addNote(Vehicle vehicle) {
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            assert con != null;

            PreparedStatement statement = con.prepareStatement(
                    "INSERT INTO VEHICLES (VIN, COUNTRY, CITY, STATE, " +
                            "POSTAL_CODE, MODEL_YEAR, MAKE, ELECTRIC_VEHICLE_TYPE," +
                            "CAFV_ELIGIBILITY, ELECTRIC_RANGE, BASE_MSPR, LEGISLATIVE_DISTRICT," +
                            "DOL_VEHICLE_ID, LOCATION, ELECTRIC_UTILITY," +
                            "CENSUS_TRACT)" +
                    "VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?))");
            statement.setString(1, vehicle.getVin());
            statement.setString(2, vehicle.getCountry());
            statement.setString(3, vehicle.getCity());
            statement.setString(4, vehicle.getState());
            statement.setInt(5, Integer.parseInt(vehicle.getPostalCode()));
            statement.setInt(6, Integer.parseInt(vehicle.getModelYear()));
            statement.setString(7, vehicle.getMake());
            statement.setString(8, vehicle.getElectricVehicleType());
            statement.setString(9, vehicle.getCafvEligibilityl());
            statement.setString(10, vehicle.getElectricRange());
            statement.setInt(11, Integer.parseInt(vehicle.getBaseMSPR()));
            statement.setInt(12, Integer.parseInt(vehicle.getLegislativeDistrict()));
            statement.setInt(13, Integer.parseInt(vehicle.getDOLVehicleId()));
            statement.setInt(14, Integer.parseInt(vehicle.getLocation()));
            statement.setString(15, vehicle.getElectricUtility());
            statement.setString(16, vehicle.getCensusTract());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getNotesList(String tableName) {
        try (Connection con = DriverManager.getConnection(url, user,password)) {
            ArrayList<String> notesList = new ArrayList<>();
            PreparedStatement statement = con.prepareStatement(String.format("SELECT * FROM %s", tableName));
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                notesList.add(String.format("%s -> Girth (in): %f; Height (ft): %f; Volume (ft^3): %f",
                        result.getString("NAME"),
                        result.getDouble("GIRTH"),
                        result.getDouble("HEIGHT"),
                        result.getDouble("VOLUME")));
            }
            return notesList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
