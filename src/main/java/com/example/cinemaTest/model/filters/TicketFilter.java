package com.example.cinemaTest.model.filters;

import com.example.cinemaTest.enums.City;
import com.example.cinemaTest.enums.Genre;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class TicketFilter {

    private String dateFrom;

    private String dateTo;

    private String filmName;

    private Genre genre;

    private City city;

    public Date getDateFrom() {
        return toDate(dateFrom);
    }

    public Date getDateTo() {
        return toDate(dateTo);
    }

    private Date toDate(String date) {

        if (date != null) {

            try {
                return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(date);
            } catch(Exception e) {
                e.printStackTrace();
            }

        }

        return null;
    }

}
