package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataAccessQueries {

    private static final String URL = "jdbc:mysql://localhost/Airline";
    private static final String USER = "yidne";
    private static final String PASSWORD = "19ybb21";

    private Connection connection;
    PreparedStatement selectAll;
    private PreparedStatement getflightlist;
    private PreparedStatement getflightlistfillter;
    private PreparedStatement inserIntoBook;
    private PreparedStatement getEcoSeat;
    private PreparedStatement getBussiSeat;
    private PreparedStatement register;
    private PreparedStatement deleteFlightSchedule;

    ResultSet resultSet = null;
    PreparedStatement selectByCity;
    PreparedStatement selectByFlightNumber;
    PreparedStatement deleteById;
    PreparedStatement selectByName;
    PreparedStatement selectByEmail;
    PreparedStatement selectByDate;
    PreparedStatement getTicket;
    PreparedStatement getByFirstName;
    PreparedStatement getByDate;
    PreparedStatement selectAllUser;
    PreparedStatement Insert;
    PreparedStatement UpdateSeat;

    String deleteQuery = ("  delete  flight_schedule , tickets from flight_schedule  inner join  tickets  on flight_schedule.schedule_id=tickets.scheid where schedule_id= ?;");
    String getAll = ("select DISTINCT schedule_id , from_ , destination , DATE_ , departure_time , ticketPrice  from flight_schedule;");
    String byCityQuery = ("select schedule_id, flightNumber, flight_name, from_ , destination , DATE_ , arrival_time , destination_time ,ticketPrice from flight_schedule where from_= ?;");
    String byFlightNumberQuery = ("select schedule_id , from_ , destination , DATE_ , departure_time , cost  from flight_schedule inner join  tickets  on flight_schedule.schedule_id=tickets.scheid where schedule_id= ?;");

    String byAllQuery = (" select fname , lname , email , phone , dob , no_person , cost , total_price from books inner join user on books.uid_ = user.user_id inner join tickets on   tickets.ticket_id=books.ticketid;");
    String byNameQuery = ("select   fname , lname , phone , email , no_person , cost as 'Iicket price' , total_price from books inner join user on  books.uid_ = user.id inner join tickets on tickets.ticket_id = books.ticketid where fname=?;");
    String byEmailQuery = ("select   fname , lname , phone , email , no_person , cost as 'Iicket price' , total_price from books inner join user on  books.uid_ = user.id inner join tickets on tickets.ticket_id = books.ticketid where email=?;");

    String getTicketQuery = ("select fname , lname , phone , dob  , email , no_person ,  cost as ticket_price ,  total_price from user inner join books on user.user_id = books.uid_ inner join tickets on books.ticketid = tickets.ticket_id ;");
    String getTicketByFirstName = ("select fname , lname , phone , dob  , email , no_person ,  cost as ticket_price ,  total_price from user inner join books on user.user_id = books.uid_ inner join tickets on books.ticketid = tickets.ticket_id where fname=?;");
    String getTicketByDate = ("select fname , lname , phone , dob  , email , no_person ,  cost as ticket_price ,  total_price from user inner join books on user.user_id = books.uid_ inner join tickets on books.ticketid = tickets.ticket_id where dob=?;");

    public DataAccessQueries() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            selectByEmail = connection
                    .prepareStatement(
                            "SELECT firstname, lastname, email FROM studentinfo order by firstname,lastname where email=?");
            getflightlist = connection.prepareStatement(
                    " select schedule_id, ticketId, from_ , destination , DATE_ , arrival_time , destination_time ,ticketPrice from flight_schedule");
            getflightlistfillter = connection.prepareStatement(
                    " select schedule_id, ticketId, from_ , destination , DATE_ , arrival_time , destination_time ,ticketPrice from flight_schedule where from_ = ? && destination=?");
            inserIntoBook = connection.prepareStatement("INSERT INTO books(email,ticketid, seat_id) VALUES(?,?,?);");
            getEcoSeat = connection
                    .prepareStatement("SELECT seat_id FROM seats WHERE class like 'eco' && status like 'avil';");
            getBussiSeat = connection
                    .prepareStatement("SELECT seat_id FROM seats WHERE class like 'bessi' && status like 'avil';");

            selectAllUser = connection.prepareStatement("select * from user where roles=?");
            Insert = connection.prepareStatement(
                    " insert into flight_schedule (flightNumber , ticketId , from_ , destination , DATE_, arrival_time, rout , AirportName , ticketPrice  ) values (? , ? , ? , ? , ? , ? , ?, ?,? );");
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

    public int check(String username, String password, String user) throws SQLException {
        selectAllUser.setString(1, user);
        try (ResultSet resultSet = selectAllUser.executeQuery()) {
            int returned = 0;
            while (resultSet.next()) {
                if (resultSet.getString(4).equals(username)
                        && (resultSet.getString(5).equals(password) && (resultSet.getString(6).equals(user)))) {
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
                if (resultSet.getString(4).equals(username)
                        && (resultSet.getString(5).equals(password) && (resultSet.getString(6).equals(Admin)))) {
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

    public List<BookedTicket> booked() {

        List<BookedTicket> result = new ArrayList<>();

        try {

            selectAll = connection.prepareStatement(byAllQuery);
            ResultSet rs;
            rs = selectAll.executeQuery();
            while (rs.next()) {
                result.add(new BookedTicket(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }
            return result;
        } catch (SQLException e) {

            System.out.println(e);
            return null;
        }

    }

    public List<Ticket> ticket() {

        List<Ticket> result = new ArrayList<>();

        try {

            getTicket = connection.prepareStatement(getTicketQuery);
            ResultSet rs;
            rs = getTicket.executeQuery();
            while (rs.next()) {
                result.add(new Ticket(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }
            return result;
        } catch (SQLException e) {

            System.out.println(e);
            return null;
        }

    }

    public List<Ticket> getByFirstName(String name) {
        try {
            getByFirstName = connection.prepareStatement(getTicketByFirstName);
            getByFirstName.setString(1, name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        try (ResultSet rs = getByFirstName.executeQuery()) {
            List<Ticket> results = new ArrayList<>();
            while (rs.next()) {
                results.add(new Ticket(

                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }
            return results;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Ticket> getByDate(String date) {
        try {
            getByDate = connection.prepareStatement(getTicketByDate);
            getByDate.setString(1, date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        try (ResultSet rs = getByDate.executeQuery()) {
            List<Ticket> results = new ArrayList<>();
            while (rs.next()) {
                results.add(new Ticket(

                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }
            return results;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}