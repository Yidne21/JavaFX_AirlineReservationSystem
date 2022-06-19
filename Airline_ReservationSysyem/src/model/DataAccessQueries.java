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
     
    String dbName = "AirLine";
    String user = "root" ;
    String password = "metegese.4122";
     String url = "jdbc:mysql://localhost:3306/"+dbName;

    private Connection connection;
    private PreparedStatement selectByemail;
    private PreparedStatement getPassworedandEmail;
    PreparedStatement selectAll;
    private PreparedStatement getflightlist;
    ResultSet resultSet = null;
    PreparedStatement selectByCity;
    PreparedStatement selectByFlightNumber;
    PreparedStatement deleteById;
    PreparedStatement selectByName;
    PreparedStatement selectByEmail;
    PreparedStatement selectByDate; 

    String deleteQuery = ("  delete flight_schedule , tickets from flight_schedule  inner join  tickets  on flight_schedule.schedule_id=tickets.scheid where schedule_id= ?;");
    String getAll = ("select schedule_id , from_ , destination , DATE_ , departure_time , cost  from flight_schedule inner join  tickets  on flight_schedule.schedule_id=tickets.scheid;");
    String byCityQuery = ("select schedule_id , from_ , destination , DATE_ , departure_time , cost  from flight_schedule inner join  tickets  on flight_schedule.schedule_id=tickets.scheid where from_= ?;");
    String byFlightNumberQuery = ("select schedule_id , from_ , destination , DATE_ , departure_time , cost  from flight_schedule inner join  tickets  on flight_schedule.schedule_id=tickets.scheid where schedule_id= ?;");
   
    String byAllQuery=(" select fname , lname , email , phone , dob , no_person , cost , total_price from books inner join user on books.uid_ = user.user_id inner join tickets on   tickets.ticket_id=books.ticketid;");
    // String byNameQuery=("select   fname , lname , phone , email , no_person , cost as 'Iicket price' , total_price from books inner join user on  books.uid_ = user.id inner join tickets on tickets.ticket_id = books.ticketid where fname=?;");
    // String byEmailQuery=("select   fname , lname , phone , email , no_person , cost as 'Iicket price' , total_price from books inner join user on  books.uid_ = user.id inner join tickets on tickets.ticket_id = books.ticketid where email=?;");
   
    
    public DataAccessQueries() {
        try {
            connection = DriverManager.getConnection(url, user, password);

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




    public List<adminFlightList> getFlight() {   
        try {
            selectAll=connection.prepareStatement(getAll);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        try (ResultSet rs = selectAll.executeQuery()) {
            List<adminFlightList> results = new ArrayList<>();
            while (rs.next()) {
                results.add(new adminFlightList(

                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getInt(6)));
            }
            return results;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }



    public List<adminFlightList> getByCity(String city) {   
        try {
            selectByCity=connection.prepareStatement(byCityQuery);
            selectByCity.setString(1, city);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        try (ResultSet rs = selectByCity.executeQuery()) {
            List<adminFlightList> results = new ArrayList<>();
            while (rs.next()) {
                results.add(new adminFlightList(

                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getInt(6)));
            }
            return results;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<adminFlightList> getByFlightNumber(int num) {   
        try {
            selectByFlightNumber=connection.prepareStatement(byFlightNumberQuery);
            selectByFlightNumber.setInt(1, num);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        try (ResultSet rs = selectByFlightNumber.executeQuery()) {
            List<adminFlightList> results = new ArrayList<>();
            while (rs.next()) {
                results.add(new adminFlightList(

                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getInt(6)));
            }
            return results;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    public List<adminFlightList> deleteByid(int num) {   
        try {
            deleteById=connection.prepareStatement(deleteQuery);
            deleteById.setInt(1, num);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        try (ResultSet rs = selectAll.executeQuery()) {
            List<adminFlightList> results = new ArrayList<>();
            while (rs.next()) {
                results.add(new adminFlightList(

                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getInt(6)));
            }
            return results;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }






    public List<BookedTicket> booked() {

        List<BookedTicket> result = new ArrayList<>();
    
        try {
      
             selectAll=connection.prepareStatement(byAllQuery);
             ResultSet rs ; 
            rs = selectAll.executeQuery();
            while (rs.next()) {
                result.add(new BookedTicket(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getInt(6),
                    rs.getInt(7)));
            }
                    return result;
        } catch (SQLException e) {
           
            System.out.println(e);
            return null;
        }
   
}










}
