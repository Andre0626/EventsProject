package com.example.demo.AppService;

import com.example.demo.DbConnection.ConnectionConfiguration;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Andrei on 08.12.2017.
 */
@Service
public class NewEventService {
    public Boolean addNewEvent(String eventName, String eventDate, String eventTime, String eventImg,String address,String city,String province) {
        Connection  connection= null;
        PreparedStatement preparedStatement = null;
        Date dateEventSql = null;
        Time timeSql = null;
        Integer maxId = getMaxId()+1;

        try {
            //convert time and date in SQL format
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            java.util.Date parsed = format.parse(eventDate);
            dateEventSql = new Date(parsed.getTime());
            timeSql = java.sql.Time.valueOf(eventTime);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ERROR FORMAT DATE OR TIME.....!!!");
        }

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO events(id,event_name,event_date,event_time,event_creator,image_url)" +
                    "VALUES (?,?,?,?,?,?)");

            preparedStatement.setInt(1,(maxId));
            preparedStatement.setString(2,eventName);
            preparedStatement.setDate(3,dateEventSql);
            preparedStatement.setTime(4,timeSql);
            preparedStatement.setString(5,null);
            preparedStatement.setString(6,eventImg);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("INSERT INTO location(id,address,city,province,eventid)" +
                    "VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1,maxId);
            preparedStatement.setString(2,address);
            preparedStatement.setString(3,city);
            preparedStatement.setString(4,province);
            preparedStatement.setInt(5,maxId);
            preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

return true;
    }

    public Integer getMaxId(){
        int maxId = 0;
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            rs  = statement.executeQuery("SELECT * from events ORDER BY id DESC LIMIT 1");
            while (rs.next()) {
            maxId = rs.getInt("id");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return maxId;
    }
}
