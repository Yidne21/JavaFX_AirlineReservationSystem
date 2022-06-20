package model;

public class seat {
    int seat_id;

    int pid;

    String Class1;

    String cost;

    public seat(int seat_id) {
        this.seat_id = seat_id;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getClass1() {
        return Class1;
    }

    public void setClass(String class1) {
        Class1 = class1;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    @Override
    public String toString() {
        return String.valueOf(getSeat_id());
    }
}
