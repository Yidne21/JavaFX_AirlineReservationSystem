package model;

public class BookedTicket {
    String DATE_;

    String email;
    int seatid;

    int schedule_id;

    int ticketPrice;

    public BookedTicket(String dATE_, String email, int seatid, int schedule_id, int ticketPrice) {
        DATE_ = dATE_;
        this.email = email;
        this.seatid = seatid;
        this.schedule_id = schedule_id;
        this.ticketPrice = ticketPrice;
    }

    public void setSeatid(int seatid) {
        this.seatid = seatid;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSeatid() {
        return seatid;
    }

    public String getDATE_() {
        return DATE_;
    }

    public void setDATE_(String dATE_) {
        DATE_ = dATE_;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }
}
