import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User_Queries {
    Database database = new Database();
    PreparedStatement selectAll;
    PreparedStatement Insert;
    PreparedStatement register;

    public User_Queries() {
        try {
            Connection connection = database.Connection();
            selectAll = connection.prepareStatement("select * from user");
            Insert = connection.prepareStatement(" insert into flight_schedule (flightNumber , planeNumber , from_ , to_ , date, time, Rout , AirpotName , ticketPrice  ) values (? , ? , ? , ? , ? , ? , ?, ?,? );");
            register = connection.prepareStatement(" insert into user (fname , lname , email , phone , pass_word, roles) values (? , ? , ? , ? , ? , ? );");

        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();
        }
    }

    public int addSchedule(String flightNumber, String planeNumber, String from, String to, String date, String time,
            String Rout, String AirpotName, String ticketPrice) {
                System.out.println(flightNumber);

        try {
            Insert.setString(1, flightNumber);
            Insert.setString(2, planeNumber);
            Insert.setString(3, from);
            Insert.setString(4, to);
            Insert.setString(5, date);
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
    public int AddUser(String fName, String lName, String Email, String Phone, String password,  String user) {
        try {
            register.setString(1, fName);
            register.setString(2, lName);
            register.setString(3, Email);
            register.setString(4, Phone);
            register.setString(5, password);
            register.setString(6, user);
           return  register.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    
    public int check(String username, String password) {
        try (ResultSet resultSet = selectAll.executeQuery()) {
            int returned = 0;
            while (resultSet.next()) {
                if (resultSet.getString(4).equals(username)
                        && (resultSet.getString(6).equals(password))) {
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

    // public void user_validator(){
    // connection con = new connection();
    // Connection c = con.getconnection();
    // Scanner input = new Scanner(System.in);

    // System.out.println("Enter email and password");

    // String email = input.nextLine();
    // String password = input.nextLine();

    // String verify = (" select count(1) from user where email = '"+email+"' and
    // pass_word = '"+password+"';");

    // try {
    // Statement st = c.createStatement();
    // ResultSet rs = st.executeQuery(verify);

    // while (rs.next()) {

    // if (rs.getInt(1)==1) {
    // System.out.println("logged");
    // } else {
    // System.out.println("Invalid Login Please try again");
    // }
    // input.close();
    // }

    // } catch(Exception e){
    // System.out.println(e);
    // }

    // }

    // public void admin_validator(){
    // connection con = new connection();
    // Connection c = con.getconnection();
    // Scanner input = new Scanner(System.in);

    // System.out.println("Enter email and password");

    // String email = input.nextLine();
    // String password = input.nextLine();

    // String verify = (" select count(1) from admin where email = '"+email+"' and
    // pass_word = '"+password+"';");

    // try {
    // Statement st = c.createStatement();
    // ResultSet rs = st.executeQuery(verify);

    // while (rs.next()) {

    // if (rs.getInt(1)==1) {
    // System.out.println("logged");
    // } else {
    // System.out.println("Invalid Login Please try again");
    // }
    // input.close();
    // }

    // } catch(Exception e){
    // System.out.println(e);
    // }

    // }

}
