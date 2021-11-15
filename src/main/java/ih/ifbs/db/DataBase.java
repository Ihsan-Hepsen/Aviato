package ih.ifbs.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class DataBase {

    private static final Logger log = LoggerFactory.getLogger(DataBase.class);

    public void getData() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:dbData/demo", "sa", "");
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS PERSONS ");
            boolean status = statement.execute("CREATE TABLE PERSONS (ID INTEGER NOT NULL IDENTITY, " +
                    "NAME VARCHAR(100)NOT NULL, FIRSTNAME VARCHAR(100)NOT NULL)");
            int rowsAffected = statement.executeUpdate("INSERT INTO PERSONS(NAME, FIRSTNAME) VALUES " +
                    "(' JONES', 'JACK'), ('POTTER', 'MIA'), ('REED', 'JACK') ");
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM PERSONS WHERE FIRSTNAME = ' JACK' ");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PERSONS WHERE FIRSTNAME = ?");
            preparedStatement.setString(1, "JACK");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                log.info("Found a person:");
                log.info("Id:" + resultSet.getInt("id"));
                log.info("Name:" + resultSet.getString("name"));
                log.info("Firstname:" + resultSet.getString("firstname"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException sqlException) {
            log.error(sqlException.getMessage(), sqlException);
        }
    }
}
