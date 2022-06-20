package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataAccessQueries {

    private static final String URL = "jdbc:mysql://localhost/ARS";
    private static final String USER = "yidne";
    private static final String PASSWORD = "19ybb21";

    private Connection connection;
    private PreparedStatement getflightlist;
    private PreparedStatement getflightlistfillter;
    private PreparedStatement inserIntoBook;
    private PreparedStatement getEcoSeat;
    private PreparedStatement getBussiSeat;
    private PreparedStatement register;
    private PreparedStatement deleteFlightSchedule;
    private PreparedStatement selectAllUser;
    private PreparedStatement Insert;
    private PreparedStatement UpdateSeat;
    private PreparedStatement getBookedlist;
    private PreparedStatement getMyTicket;
    private ResultSet resultSet;

    public DataAccessQueries() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            getflightlist = connection.prepareStatement(
                    " select schedule_id, ticketId, from_ , destination , DATE_ , arrival_time , destination_time ,ticketPrice from flight_schedule");
            getflightlistfillter = connection.prepareStatement(
                    " select schedule_id, ticketId, from_ , destination , DATE_ , arrival_time , destination_time ,ticketPrice from flight_schedule where from_ = ? && destination=?");
            inserIntoBook = connection.prepareStatement("INSERT INTO books(email,schedule_id, seatid) VALUES(?,?,?);");
            getEcoSeat = connection
                    .prepareStatement("SELECT seat_id FROM seats WHERE class like 'eco' && status like 'avil';");
            getBussiSeat = connection
                    .prepareStatement("SELECT seat_id FROM seats WHERE class like 'bessiness' && status like 'avil';");

            selectAllUser = connection.prepareStatement("select * from user where roles=?");
            Insert = connection.prepareStatement(
                    " insert into flight_schedule (schedule_id , ticketId , from_ , destination , DATE_, arrival_time, rout , AirportName , ticketPrice  ) values (? , ? , ? , ? , ? , ? , ?, ?,? );");
            register = connection.prepareStatement(
                    " insert into user (fname , lname , email, pass_word, roles) values (? , ? , ? , ? , ? )");
            UpdateSeat = connection.prepareStatement("UPDATE seats SET status = ? WHERE seat_id = ?;");
            deleteFlightSchedule = connection.prepareStatement("DELETE FROM flight_schedule WHERE schedule_id=?");
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
                        resultSet.getInt(8)));
            }
            return result;
        } catch (SQLException e) {

            e.printStackTrace();
            return null;
        }
    }

    public List<flightList> getflightListsFillter(String from, String to) {

        List<flightList> result = new ArrayList<>();
        try {
            getflightlistfillter.setString(1, from);
            getflightlistfillter.setString(2, to);
            resultSet = getflightlistfillter.executeQuery();
            while (resultSet.next()) {
                result.add(new flightList(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getInt(8)));
            }
            return result;
        } catch (SQLException e) {

            e.printStackTrace();
            return null;
        }
    }

    public int inserIntoBook(int ticketId, String email, int seat_id) throws SQLException {
        inserIntoBook.setString(1, email);
        inserIntoBook.setInt(2, ticketId);
        inserIntoBook.setInt(3, seat_id);
        return inserIntoBook.executeUpdate();
    }

    public List<seat> getEcoSeat() {
        List<seat> result = new ArrayList<>();
        try {
            resultSet = getEcoSeat.executeQuery();
            while (resultSet.next()) {
                result.add(new seat(resultSet.getInt(1)));
            }
            return result;
        } catch (SQLException e) {

            e.printStackTrace();
            return null;
        }
    }

    public List<seat> getBessiSeat() {
        List<seat> result = new ArrayList<>();
        try {
            resultSet = getBussiSeat.executeQuery();
            while (resultSet.next()) {
                result.add(new seat(resultSet.getInt(1)));
            }
            return result;
        } catch (SQLException e) {

            e.printStackTrace();
            return null;
        }
    }

    public int addSchedule(String flightNumber, String planeNumber, String from, String to, String string, String time,
            String Rout, String AirpotName, String ticketPrice) {

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

    public int check(String username, String password, String user) throws SQLException {
        selectAllUser.setString(1, user);
        try (ResultSet resultSet = selectAllUser.executeQuery()) {
            int returned = 0;
            while (resultSet.next()) {
                if (resultSet.getString(3).equals(username)
                        && (resultSet.getString(4).equals(password) && (resultSet.getString(5).equals(user)))) {
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

    public int confirm(String username, String password, String Admin) throws SQLException {
        selectAllUser.setString(1, Admin);
        try (ResultSet resultSet = selectAllUser.executeQuery()) {
            int returned = 0;
            while (resultSet.next()) {
                if (resultSet.getString(3).equals(username)
                        && (resultSet.getString(4).equals(password) && (resultSet.getString(5).equals(Admin)))) {
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

    public int AddUser(String fName, String lName, String Email, String password, String user) {
        try {
            register.setString(1, fName);
            register.setString(2, lName);
            register.setString(3, Email);
            register.setString(4, password);
            register.setString(5, user);
            return register.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int UpdateSeat(int seat_id, String value) throws SQLException {
        UpdateSeat.setString(1, value);
        UpdateSeat.setInt(2, seat_id);
        return UpdateSeat.executeUpdate();
    }

    public int deleteFlightSchedule(int schedule_id) throws SQLException {
        deleteFlightSchedule.setInt(1, schedule_id);
        return deleteFlightSchedule.executeUpdate();
    }
}