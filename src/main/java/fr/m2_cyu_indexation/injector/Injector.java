package fr.m2_cyu_indexation.injector;

import fr.m2_cyu_indexation.index.indexer.Indexer;
import fr.m2_cyu_indexation.index.parser.IndexParser;
import fr.m2_cyu_indexation.saver.IndexSaver;

import java.nio.file.Path;

/**
 * The facade of the program. Index all files of folder and persist the data.
 *
 * @author Aldric Vitali Silvestre
 */
public class Injector {

    private final Indexer indexer;

    private final IndexParser indexParser;
    private final IndexSaver saver;

    public Injector(Indexer indexer, IndexParser indexParser, IndexSaver saver) {
        this.indexer = indexer;
        this.indexParser = indexParser;
        this.saver = saver;
    }

    public void inject(Path inputPath, Path outputFolderPath, boolean doUploadImage) {
        System.out.println("Start indexing files");
        indexer.createIndexes(inputPath, outputFolderPath);

    }

}
