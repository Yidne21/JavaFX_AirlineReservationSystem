package model;



public class adminFlightList {

    int schedule_id ;
    String from ;
    String destination ;
    String date;
    String departure_time ;
    int ticket_price ;
  
  
 public  adminFlightList( int schedule_id ,  String from, String destination, String date ,String departure_time,  int ticket_price) {
      this.schedule_id = schedule_id;
      this.from = from;
      this.destination = destination;
      this.date = date;
      this.departure_time = departure_time;
      this.ticket_price = ticket_price;
  
    }
  
    public int getSchedule_id() {
        return schedule_id;
    }
  
    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }
  
  
    public String getFrom() {
        return from;
    }
  
    public void setFrom(String from) {
        this.from = from;
    }
  
    public String getDestination() {
        return destination;
    }
  
    public void setDestination(String destination) {
        this.destination = destination;
    }
  
    public String getDate() {
        return date;
    }
  
    public void setDate(String date) {
        this.date = date;
    }
  
  public String getDeparture_time() {
      return departure_time;
  }
  
  public void setDeparture_time(String departure_time) {
      this.departure_time = departure_time;
  }
  
  public int getTicket_price() {
      return ticket_price;
  }
  
  public void setTicket_price(int ticket_price) {
      this.ticket_price = ticket_price;
  }
  
  }
