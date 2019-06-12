package core.dbConnect;

import core.configuration.TestsConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnect {

    public static String url = TestsConfig.getConfig().getDbUrl();
    public static String username = TestsConfig.getConfig().getDbUsername();
    public static String password = TestsConfig.getConfig().getDbPassword();

    static Connection connection = null;
    static Statement statement = null;

    public static void connectDb(String url, String username, String password) throws ClassNotFoundException, SQLException {

        //Class.forName("oracle.jdbc.driver.OracleDriver"); // load sql driver
        //Class.forName("oracle.jdbc.OracleDriver");
        Class.forName("com.mysql.jdbc.Driver");


        connection = DriverManager.getConnection(url, username, password); //DB connection
    }

    public static List<String> getOrderIDsList() throws SQLException {

        String query = "";
        ResultSet rs = null;
        List<String> orderIds = new ArrayList<String>();

        try {
            connectDb(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        query = "SELECT booking_confirmation_id FROM servicemarket_business.booking_confirmation WHERE booking_id=53045";

        statement = connection.createStatement();
        rs = statement.executeQuery(query);
        rs.setFetchSize(100);

        while (rs.next()){
            orderIds.add(rs.getString("booking_confirmation_id"));
        }
        rs.close();
        statement.close();

        return orderIds;

    }



}
