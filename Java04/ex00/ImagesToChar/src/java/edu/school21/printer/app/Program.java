package edu.school21.printer.app;

import edu.school21.printer.logic.Convert;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Program {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Wrong number of arguments");
            System.exit(-1);
        }
        if (args[0].length() != 1 || args[1].length() != 1 || !Files.exists(Paths.get(args[2]))) {
            System.err.println("Invalid arguments");
            System.exit(-1);
        }
        File file = new File(args[2]);
        if (file.isDirectory()) {
            System.err.println("File path is a directory");
            System.exit(-1);
        }
        Convert converter = new Convert(file, args[0].charAt(0), args[1].charAt(0));
        converter.drawImage();
    }
}
