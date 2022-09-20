package fr.m2_cyu_indexation.config;

import java.io.File;
import java.nio.file.Path;

/**
 * This loads and checks the arguments passed to the command to run it.
 *
 * @author Aldric Vitali Silvestre
 */
public class Arguments {

    // Can be either a folder or a file
    private final Path inputPath;

    // Can only be a file
    private final Path outputFolderPath;

    /**
     * Loads and checks the arguments.
     * @param args the arguments of the main function
     * @throws IllegalArgumentException if any arg is not valid
     */
    public Arguments(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("No enough arguments : need input path and output path");
        }
        inputPath = createExistingPath(args[0], false);
        outputFolderPath = createExistingPath(args[1], true);
    }

    public Path getInputPath() {
        return inputPath;
    }

    public Path getOutputFolderPath() {
        return outputFolderPath;
    }

    private Path createExistingPath(String strPath, boolean mustBeDir) {
        Path path = Path.of(strPath);
        File file = path.toFile();
        if (!file.exists()) {
            throw new IllegalArgumentException("Path provided is not a file : " + path);
        }
        if (mustBeDir && !file.isDirectory()){
            throw new IllegalArgumentException("Path provided must be a directory : " + path);
        }
        return path;
    }
}
