import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cd {
    public static Path execute(Path path, String folder) {
        Path destination = Paths.get(path + "/" + folder);
        if (Files.exists(destination) && Files.isDirectory(destination)) {
            System.out.println(destination);
            return (destination);
        } else {
            System.err.println("Incorrect path");
            return (path);
        }
    }
}
