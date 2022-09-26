import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Ls {
    public static void execute(Path path) throws IOException {
        List<Path> content = Files.walk(path, 1).collect(Collectors.toList());
        for (Path w : content) {
            if (w != path) {
                System.out.println(w.getFileName() + " " + Files.size(w) + " KB");
            }
        }
    }
}
