package com.wrox;
import java.io.Serializable;
import java.text.NumberFormat;

public class Ticket1 implements Serializable {

    private int ticket_number;
    private String ticket_date;
    private String ticket_details;

    public int getTicket_number() {
        return ticket_number;
    }

    public void setTicket_number(int ticket_number) {
        this.ticket_number = ticket_number;
    }

    public String getTicket_date() {
        return ticket_date;
    }

    public void setTicket_date(String ticket_date) {
        this.ticket_date = ticket_date;
    }

    public String getTicket_details() {
        return ticket_details;
    }

    public void setTicket_details(String ticket_details) {
        this.ticket_details = ticket_details;
    }

    public Ticket1() {
        ticket_number = 0;
        ticket_date = "";
        ticket_details = "No Details";
    }

    
}