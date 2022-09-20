package fr.m2_cyu_indexation;

import fr.m2_cyu_indexation.config.Arguments;
import fr.m2_cyu_indexation.config.Config;
import fr.m2_cyu_indexation.index.indexer.ExternProgramIndexer;
import fr.m2_cyu_indexation.index.indexer.Indexer;
import fr.m2_cyu_indexation.index.parser.IndexParser;
import fr.m2_cyu_indexation.injector.Injector;

public class Main {
    public static void main(String[] args) {
        Config config = new Config();
        Arguments arguments = new Arguments(args);

        Indexer indexer = new ExternProgramIndexer(config.getIndexerPath());
        IndexParser indexParser = new IndexParser();
        Injector injector = new Injector(indexer, indexParser, null);

        injector.inject(arguments.getInputPath(), arguments.getOutputFolderPath(), arguments.isDoUploadImage());
    }
}