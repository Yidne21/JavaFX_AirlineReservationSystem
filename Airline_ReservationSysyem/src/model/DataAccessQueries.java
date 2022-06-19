package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;

public class DataAccessQueries {
    private static final String URL = "jdbc:mysql://localhost/Airline";
    private static final String USER = "yidne";
    private static final String PASSWORD = "19ybb21";

    private Connection connection;
    private PreparedStatement selectByemail;
    private PreparedStatement getPassworedandEmail;
    private PreparedStatement getflightlist;
    ResultSet resultSet = null;

    public DataAccessQueries() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            selectByemail = connection
                    .prepareStatement(
                            "SELECT firstname, lastname, email FROM studentinfo order by firstname,lastname where email=?");
            getflightlist = connection.prepareStatement(
                    " select schedule_id, flightNumber, flight_name, from_ , destination , DATE_ , arrival_time , destination_time ,ticketPrice from flight_schedule");
        } catch (SQLException ex) {

            ex.printStackTrace();
            System.exit(1);
        }
    }

    public List<flightList> getflightLists() {

        List<flightList> result = new ArrayList<>();
        try {
            resultSet = getflightlist.executeQuery();
            while (resultSet.next()) {
                result.add(new flightList(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getInt(9)));
            }
            return result;
        } catch (SQLException e) {

            e.printStackTrace();
            return null;
        }
    }
}
