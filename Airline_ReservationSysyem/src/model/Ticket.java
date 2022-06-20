package model;

public class Ticket {
    String FirstName;
    String Lastname ;
    String phone ;
    String date ;
    String email;
    int no_person ;
    int ticket_price;
    int total_price ;
    public Ticket(String firstName, String lastname, String phone, String date, String email, int no_person,
            int ticket_price, int total_price) {
        FirstName = firstName;
        Lastname = lastname;
        this.phone = phone;
        this.date = date;
        this.email = email;
        this.no_person = no_person;
        this.ticket_price = ticket_price;
        this.total_price = total_price;
    }


public String getFirstName() {
    return FirstName;
} 

public void setFirstName(String firstName) {
    FirstName = firstName;
}

public String getLastname() {
    return Lastname;
}

public void setLastname(String lastname) {
    Lastname = lastname;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getDate() {
    return date;
}

public void setDate(String date) {
    this.date = date;
}

public int getNo_person() {
    return no_person;
}

public void setNo_person(int no_person) {
    this.no_person = no_person;
}

public String getPhone() {
    return phone;
}

public void setPhone(String phone) {
    this.phone = phone;
}

public int getTicket_price() {
    return ticket_price;
}

public void setTicket_price(int ticket_price) {
    this.ticket_price = ticket_price;
}

public int getTotal_price() {
    return total_price;
}

public void setTotal_price(int total_price) {
    this.total_price = total_price;
}














}
