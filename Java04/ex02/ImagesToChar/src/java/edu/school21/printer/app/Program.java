package edu.school21.printer.app;
import edu.school21.printer.logic.Convert;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Parameters(separators = "=")
public class Program {
    @Parameter(names = {"--white"})
    private static String white;
    @Parameter(names = {"--black"})
    private static String black;

    private static final String IMAGE_PATH = "/resources/it.bmp";

    public static void main(String... argv) {
        Program main = new Program();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(argv);

        Convert converter = new Convert(white, black);

        try {
            converter.drawImage(new File(Program.class.getResource(IMAGE_PATH).getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
