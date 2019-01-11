package utils;

import com.mysql.jdbc.Statement;
import dao.entity.Festival;
import dao.entity.Performer;
import dao.entity.User;
import dao.entity.enums.TypeEvent;

import java.sql.*;
import java.util.Set;

public class Connector {
    private String host;
    private String schema;
    private String user;
    private String password;

    private Connection connection;
    private boolean isConnected = false;

    public Connector(String host, String schema, String user, String password) {
        this.host = host;
        this.schema = schema;
        this.user = user;
        this.password = password;
    }

    public void openConnection() throws SQLException{
        if(isConnected){
            return;
        }

        connection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + schema + "?verifyServerCertificate=false" + "&useSSL=false" + "&requireSSL=false" + "&useLegacyDatetimeCode=false" + "&amp" + "&serverTimezone=UTC", user, password);
    }

    public User addUser(int age) throws SQLException{
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            PreparedStatement findUserByAge = connection.prepareStatement("Select id, firstname, lastname, age from user where age < ?");
            findUserByAge.setLong(1, age);
            resultSet = findUserByAge.executeQuery();
          /*  if(resultSet.next()){
                 Long id = resultSet.getLong("ID");
                String firstName = resultSet.getString("FIRSTNAME");
                String lastName = resultSet.getString("LASTNAME");
                age = resultSet.getInt("AGE");
                return new User(id, firstName, lastName, age);
            }*/
            return null;

        } finally{
            if(statement!=null){
                statement.close();
            }
            if(resultSet!=null){
                resultSet.close();
            }
        }
    }


    public Festival addFest(String type) throws SQLException{
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            PreparedStatement findFestByType = connection.prepareStatement("Select id, name, description, countplace, price from FEST left join fest_type on fest.id = fest_type.fest_id  where type = ? ");
            findFestByType.setObject(1, type);
            resultSet = findFestByType.executeQuery();
           /* if(resultSet.next()){
                Long id = resultSet.getLong("ID");
                String name = resultSet.getString("NAME");
                String description = resultSet.getString("DESCRIPTION");
                int countPlace = resultSet.getInt("COUNTPLACE");
                double price = resultSet.getDouble("PRICE");
                return new Festival(id, name, description, countPlace, price);
            }*/
            return null;

        } finally{
            if(statement!=null){
                statement.close();
            }
            if(resultSet!=null){
                resultSet.close();
            }
        }
    }


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }
}
