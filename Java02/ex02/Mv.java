import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Mv {
    public static void execute(Path path, String startPath, String dest) throws IOException {
        Path start = Paths.get(path + "/" + startPath);
        Path dst = Paths.get(path + "/" + dest);

        if (Files.isRegularFile(start)) {
            if (Files.isDirectory(dst)) {
                dst = Paths.get(dst + "/" + start.getFileName());
            }
            Files.move(start, dst, REPLACE_EXISTING);
        } else {
            System.err.println("File path error");
        }
    }
}
