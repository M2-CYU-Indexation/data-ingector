package fr.m2_cyu_indexation.saver.oracle;

import fr.m2_cyu_indexation.config.OracleConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The JDBC connection to the oracle database
 *
 * @author Aldric Vitali Silvestre
 */
public class OracleConnection implements AutoCloseable {

    Connection connection;

    public OracleConnection(String username, String password, String ip, int port, String sid) throws SQLException {
        System.out.println("Create connection to oracledb");
        connection = DriverManager.getConnection(
            createUrl(ip, port, sid),
            username,
            password
        );
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    private String createUrl(String ip, int port, String sid) {
        return "jdbc:oracle:thin:@" + ip + ":" + port + ":" + sid;
    }

    public static OracleConnection fromConfig(OracleConfig config) throws SQLException {
        return new OracleConnection(
                config.getUsername(),
                config.getPassword(),
                config.getIpAddress(),
                config.getPort(),
                config.getSid()
        );
    }

    @Override
    public void close() throws Exception {
        System.out.println("Close oracledb connection");
        connection.close();
    }
}
