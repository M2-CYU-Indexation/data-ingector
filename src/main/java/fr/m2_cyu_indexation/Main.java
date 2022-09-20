package fr.m2_cyu_indexation;

import fr.m2_cyu_indexation.config.Arguments;
import fr.m2_cyu_indexation.config.Config;
import fr.m2_cyu_indexation.indexer.Indexer;

public class Main {
    public static void main(String[] args) {
        Config config = new Config();
        Arguments arguments = new Arguments(args);
        Indexer indexer = new Indexer(arguments.getInputPath(), arguments.getOutputFolderPath(), config.getIndexerPath());
        indexer.startIndexing();
    }
}