package fr.m2_cyu_indexation.saver;

import java.nio.file.Path;

/**
 * Responsible for saving data to the wanted source.
 *
 * @author Aldric Vitali Silvestre
 */
public interface IndexSaver {

    void save(Path inputFolderPath);

}
