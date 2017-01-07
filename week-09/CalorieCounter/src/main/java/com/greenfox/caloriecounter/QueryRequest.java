package com.greenfox.caloriecounter;

import lombok.Data;

/**
 * Created by Rita on 2017-01-07.
 */
@Data
public class QueryRequest {
    String type;
    String startdate;
    String enddate;
    int limit;

    public String getPath() {
        if (startdate.equals("")) {
            startdate = "1900-01-01";
        }
        if (enddate.equals("")) {
            enddate = "2100-01-01";
        }
        return "redirect:/caloriecounter/index?page=0&limit=" + limit + "&startdate=" + startdate + "&enddate=" + enddate + "&type=" + type;
    }
}
