package fr.m2_cyu_indexation.indexer;

import java.io.IOException;
import java.nio.file.Path;

/**
 * The main service that will call the C program in order to
 * create indexes of the files targeted as inputs.
 *
 * @author Aldric Vitali Silvestre
 */
public class Indexer {
    private final Path inputPath;
    private final Path outputFolderPath;
    private final Path indexerPath;

    public Indexer(Path inputPath, Path outputFolderPath, Path indexerPath) {
        this.inputPath = inputPath;
        this.outputFolderPath = outputFolderPath;
        this.indexerPath = indexerPath;
    }

    /**
     * From the given inputs and outputs, call the C program in order to index all images in the targeted folder.
     * @throws RuntimeException if an error happens during or at the end of the process.
     */
    public void startIndexing() {
        System.out.println("==== Start C program ====");
        Process process = startProgram();
        int returnCode = waitProgramEnd(process);
        if (returnCode != 0) {
            throw new RuntimeException("Program ended with error code " + returnCode);
        }
        System.out.println("==== End of C program ====");
    }

    private int waitProgramEnd(Process process) {
        try {
            return process.waitFor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private Process startProgram() {
        try {
            return new ProcessBuilder()
                    .command(indexerPath.toString(), inputPath.toString(), outputFolderPath.toString())
                    .inheritIO()
                    .start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
