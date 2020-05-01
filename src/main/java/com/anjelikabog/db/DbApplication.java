package com.anjelikabog.db;

import com.anjelikabog.db.connection_to_db.HikariCPConnectionToDB;
import com.anjelikabog.db.unmarshall_xml.*;

import javax.sql.DataSource;
import javax.xml.bind.*;
import java.io.File;
import java.sql.*;

public class DbApplication {
    public static void main(String[] args) {
        Connection connection;
        PreparedStatement insertPersons;
        PreparedStatement insertHobby;
        PreparedStatement insertHobbies;
        ResultSet rsPer;
        ResultSet rsHob;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Persons pers = (Persons) jaxbUnmarshaller.unmarshal(new File("src/main/resources/fileXmlPersons.xml"));

            DataSource dataSource = HikariCPConnectionToDB.getDataSource();
            connection = dataSource.getConnection();
            insertPersons = connection.prepareStatement(
                    "insert into persons(fullname, birthday) values (?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            insertHobby = connection.prepareStatement(
                    "insert into hobby(complexity, hobby_name) values (?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            insertHobbies = connection.prepareStatement(
                    "insert into hobbies values (?,?)"
            );

            for (Person per : pers.getPersons()) {
                insertPersons.setString(1, per.getName());
                insertPersons.setDate(2, new java.sql.Date(per.getBirthday().getTime()));
                insertPersons.executeUpdate();
                if (!per.getHobbies().isEmpty()) {
                    for (Hobbies hobbs : per.getHobbies()) {
                        for (Hobby hob : hobbs.getHobby()) {
                            insertHobby.setInt(1, hob.getComplexity());
                            insertHobby.setString(2, hob.getHobbyName());
                            insertHobby.executeUpdate();
                            rsPer = insertPersons.getGeneratedKeys();
                            rsHob = insertHobby.getGeneratedKeys();
                            if (rsPer.next()) {
                                insertHobbies.setInt(1, rsPer.getInt(1));
                            }
                            if (rsHob.next()) {
                                insertHobbies.setInt(2, rsHob.getInt(1));
                            }
                            insertHobbies.executeUpdate();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
