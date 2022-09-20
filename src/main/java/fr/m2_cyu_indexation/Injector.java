package fr.m2_cyu_indexation;

import fr.m2_cyu_indexation.indexer.Indexer;

import java.nio.file.Path;

/**
 * The facade of the program. Index all files of folder and persist the data.
 *
 * @author Aldric Vitali Silvestre
 */
public class Injector {
    private final Indexer indexer;

    public Injector(Path inputPath, Path outputFolderPath, Path indexerPath) {
        this.indexer = new Indexer(inputPath, outputFolderPath, indexerPath);
    }

    public void run() {
        System.out.println("Start indexing files");
        indexer.startIndexing();
    }

}
