package com.example.demo.HomeController;


import com.example.demo.AppService.AppService;
import com.example.demo.AppService.NewEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Andrei on 24.11.2017.
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController {
    @Autowired
    AppService appService;

    @RequestMapping(value = "/get-events")
    public
    @ResponseBody  List getEvents() throws SQLException {
        return  appService. getFullEvents();
    }

    @RequestMapping(value = "/get-vote")
    public
    @ResponseBody Map getVote(Integer vote,Integer id_event){

        return  appService.getVote(vote,id_event);
    }
}
