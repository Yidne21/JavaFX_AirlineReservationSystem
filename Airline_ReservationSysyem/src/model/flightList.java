package model;

import Utility.SceneSwitcher;

import javafx.scene.control.Button;

public class flightList extends SceneSwitcher {

    int schedule_id;
    String flight_name;
    String from;
    String destination;
    String date;
    String arrival_time;
    String destination_time;
    int ticket_price;

    public flightList(int schedule_id, int i, String flight_name, String from, String destination, String date,
            String arrival_time, String destination_time, int ticket_price) {
        this.schedule_id = schedule_id;
        this.flight_name = flight_name;
        this.from = from;
        this.destination = destination;
        this.date = date;
        this.arrival_time = arrival_time;
        this.destination_time = destination_time;
        this.ticket_price = ticket_price;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public String getFlight_name() {
        return flight_name;
    }

    public void setFlight_name(String flight_name) {
        this.flight_name = flight_name;
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

    public String getDestination_time() {
        return destination_time;
    }

    public void setDestination_time(String destination_time) {
        this.destination_time = destination_time;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public int getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(int ticket_price) {
        this.ticket_price = ticket_price;
    }

<<<<<<< HEAD
    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }
=======
    public Button getBook() {
        return book;
    }

    public void setBook(Button book) {
        this.book = book;
    }

   
>>>>>>> 17014ff5b1e6c61fe08c4bfea01d2120dbbfba4e
}