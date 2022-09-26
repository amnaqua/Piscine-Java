package edu.school21.printer.app;

import edu.school21.printer.logic.Convert;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Program {
    public static void main(String[] args) {
        if (args[0].length() != 1 || args[1].length() != 1) {
            System.err.println("Invalid arguments");
            System.exit(-1);
        }
        File file = new File("src/resources/it.bmp");
        if (file.isDirectory()) {
            System.err.println("File path is a directory");
            System.exit(-1);
        }
        Convert converter = new Convert(file, args[0].charAt(0), args[1].charAt(0));
        converter.drawImage();
    }
}
