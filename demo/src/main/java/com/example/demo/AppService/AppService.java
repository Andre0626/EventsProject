package com.example.demo.AppService;

import com.example.demo.DbConnection.ConnectionConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.lang.model.element.Element;
import java.net.ConnectException;
import java.sql.*;
import java.util.*;

/**
 * Created by Andrei on 24.11.2017.
 */

@Service
public class AppService {
    @Autowired

    public String testService() {
        return "Service ready";
    }
    public List getListOfEvents() throws SQLException {

        List eventsList = new ArrayList();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        HashMap vResult = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT events.id,events.event_name,events.event_date,events.event_time,events.event_creator,events.image_url," +
                    "events.vote,events.min_persons,events.max_persons," +
                    "location.address,location.city,location.province " +
                    "FROM events " +
                    "INNER  JOIN location ON location.eventid=events.id");

            while (resultSet.next()) {
                //  System.out.println(resultSet.getInt("actor_id"));
                vResult = new HashMap();
                vResult.put("id", resultSet.getInt("id"));
                vResult.put("name", resultSet.getString("event_name"));
                vResult.put("date", resultSet.getString("event_date"));
                vResult.put("time", resultSet.getString("event_time"));
                vResult.put("vote",resultSet.getInt("vote"));
                vResult.put("min_persons",resultSet.getInt("min_persons"));
                vResult.put("max_persons",resultSet.getInt("max_persons"));
                vResult.put("event_creator", resultSet.getString("event_creator"));
                vResult.put("address", resultSet.getString("address"));
                vResult.put("city", resultSet.getString("city"));
                vResult.put("province", resultSet.getString("province"));
                vResult.put("imgUrl", resultSet.getString("image_url"));
                eventsList.add(vResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventsList;
    }

    public List getSessions() throws SQLException {
        List sessions = new ArrayList();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try{
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM sessions");
            while (rs.next()){
                Map<String,Object> session = new HashMap();
                session.put("name",rs.getString("name"));
                session.put("creator_name",rs.getString("creatorname"));
                session.put("duration",rs.getInt("duration"));
                session.put("level",rs.getString("level"));
                session.put("description",rs.getString("abstract"));
                session.put("vote",rs.getInt("upvotecount"));
                session.put("eventId",rs.getInt("eventId"));
                sessions.add(session);

            }
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("fail Load Sessions");
        }
        return sessions;
    }

    public List getFullEvents() throws SQLException{
       List<Map<String,Object>> sessions = null;
       List<Map<String,Object>> listOfEvents = null;

        try {
            sessions = getSessions();
            listOfEvents = getListOfEvents();
            for (Map<String,Object> event:listOfEvents) {
                List sessionList = new ArrayList();
                event.put("sessions",sessionList);
                //System.out.println(event);
                //populate sessionList
                for (Map session : sessions) {
                    //add item if eventId din event curent = cu sessionId din item
                    if(session.get("eventId") == event.get("id")){
                       sessionList.add(session);
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return listOfEvents;
    }

    public Map getVote(Integer newVote,Integer id_event){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Map returnVote = new HashMap();
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE events SET vote = ? WHERE id = ?");
            preparedStatement.setInt(1,newVote);
            preparedStatement.setInt(2,id_event);
            preparedStatement.executeUpdate();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT vote FROM  events");
            while (resultSet.next()){
                returnVote.put("vote",resultSet.getInt("vote"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return returnVote;
    }

}
