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
    PreparedStatement selectAll;
    PreparedStatement Insert;
    ResultSet resultSet = null;

    public DataAccessQueries() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            selectByemail = connection
                    .prepareStatement(
                            "SELECT firstname, lastname, email FROM studentinfo order by firstname,lastname where email=?");
            getflightlist = connection.prepareStatement(
                    " select schedule_id, flightNumber, flight_name, from_ , destination , DATE_ , arrival_time , destination_time ,ticketPrice from flight_schedule");
            selectAll = connection.prepareStatement("select * from user");
            Insert = connection.prepareStatement(
                    " insert into flight_schedule (flightNumber , planeNumber , from_ , to_ , Date_, time, Rout , AirpotName , ticketPrice  ) values (? , ? , ? , ? , ? , ? , ?, ?,? );");
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

    public int addSchedule(String flightNumber, String planeNumber, String from, String to, String string, String time,
            String Rout, String AirpotName, String ticketPrice) {
        System.out.println(flightNumber);

        try {
            Insert.setString(1, flightNumber);
            Insert.setString(2, planeNumber);
            Insert.setString(3, from);
            Insert.setString(4, to);
            Insert.setString(5, string);
            Insert.setString(6, time);
            Insert.setString(7, Rout);
            Insert.setString(8, AirpotName);
            Insert.setString(9, ticketPrice);

            return Insert.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;

        }
    }

    public int check(String username, String password, String user) {
        try (ResultSet resultSet = selectAll.executeQuery()) {
            int returned = 0;
            while (resultSet.next()) {
                if (resultSet.getString(4).equals(username)
                        && (resultSet.getString(6).equals(password) && (resultSet.getString(9).equals(user)))) {
                    returned = 1;
                    break;
                } else {
                    returned = 0;
                }

            }
            return returned;
        } catch (Exception e) {
            return 0;
        }
    }

    public int confirm(String username, String password, String Admin) {
        try (ResultSet resultSet = selectAll.executeQuery()) {
            int returned = 0;
            while (resultSet.next()) {
                if (resultSet.getString(4).equals(username)
                        && (resultSet.getString(6).equals(password) && (resultSet.getString(9).equals(Admin)))) {
                    returned = 1;
                    break;
                } else {
                    returned = 0;
                }

            }
            return returned;
        } catch (Exception e) {
            return 0;
        }
    }
}
