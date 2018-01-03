package com.example.demo.DbConnection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Andrei on 26.11.2017.
 */
@Controller
@RequestMapping(value = "/conDb")
public class ConnectionConfiguration {
    @RequestMapping(value="/test")
    @ResponseBody
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/events_db","postgres","andrei11");
           // System.out.println("connection established******");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("connection FAIL!!!");
        }
        return connection;
    }
}
