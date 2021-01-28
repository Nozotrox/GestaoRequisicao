package com.example.accessingdatamysql.responseRequestBodies;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class GetByDate {
    Date date;

    public GetByDate() {

    }

    public GetByDate(@JsonProperty("date") Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
