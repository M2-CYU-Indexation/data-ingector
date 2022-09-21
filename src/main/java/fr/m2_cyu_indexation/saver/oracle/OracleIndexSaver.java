package fr.m2_cyu_indexation.saver.oracle;

import fr.m2_cyu_indexation.index.parser.IndexContent;
import fr.m2_cyu_indexation.saver.IndexSaver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Aldric Vitali Silvestre
 */
public class OracleIndexSaver implements IndexSaver {

    private final OracleConnection oracleConnection;

    public OracleIndexSaver(OracleConnection connection) {
        this.oracleConnection = connection;
    }

    @Override
    public void save(IndexContent indexContent, boolean doUploadImage) {

        System.out.println("Process " + indexContent.getImageName() + " : " + doUploadImage);

        String query = createQuery(indexContent, doUploadImage);

        try (
                Statement statement = oracleConnection.createStatement();
                ResultSet rs = statement.executeQuery(query);
        ) {
            // TODO real handling
            if (rs.next()) {
                System.out.println("WORKS !");
            } else {
                System.err.println("What ??");
            }

        } catch (SQLException exception) {
            throw new RuntimeException("Error while handling statement", exception);
        }
    }

    private String createQuery(IndexContent indexContent, boolean doUploadImage) {
        // TODO
        return "SELECT 1 FROM imageTable";
    }
}
