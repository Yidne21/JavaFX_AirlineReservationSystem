package model;

public class BookedTicket {
    String fname;
    String lname;
    String phone;
    String email;
    int no_person;
    int ticket_price;
    int total_price;
    String date;

    public BookedTicket(String fname, String lname, String phone, String email, String date, int no_person,
            int ticket_price,
            int total_price) {
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.email = email;
        this.no_person = no_person;
        this.ticket_price = ticket_price;
        this.total_price = total_price;
        this.date = date;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFname() {
        return fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLname() {
        return lname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public int getNo_person() {
        return no_person;
    }

    public void setNo_person(int no_person) {
        this.no_person = no_person;
    }

    public void setTicket_price(int ticket_price) {
        this.ticket_price = ticket_price;
    }

    public int getTicket_price() {
        return ticket_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public int getTotal_price() {
        return total_price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
