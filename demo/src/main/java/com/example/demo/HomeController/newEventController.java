package com.example.demo.HomeController;

import com.example.demo.AppService.NewEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.util.*;

/**
 * Created by Andrei on 08.12.2017.
 */
@Controller
@RequestMapping(value = "/new-event")
public class newEventController {
    @Autowired
    NewEventService newEventService;
    @RequestMapping(value = "/add-new-event")
    public
    @ResponseBody Boolean addNewEvent(String eventName, String eventDate, String eventTime, String eventImg,String address,String city,String province) {
        newEventService.addNewEvent(eventName, eventDate,eventTime,eventImg,address,city,province);
        return true;
    }
}
