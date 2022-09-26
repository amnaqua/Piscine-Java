import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            throw new ArgsException();
        }
        Path path = Paths.get(args[0]);
        if (args[0].startsWith("--current-folder=")) {
            path = Paths.get(args[0].substring(17));
        }
        if (!Files.exists(path)) {
            throw new FileException();
        }
        System.out.println(path);
        Scanner input = new Scanner(System.in);

        String commandLine = "";
        while (!commandLine.equals("exit")) {
            commandLine = input.nextLine();
            String[] command = commandLine.split(" ");
            switch (command[0]) {
                case ("mv"):
                    Mv.execute(path, command[1], command[2]);
                    break;
                case ("ls"):
                    Ls.execute(path);
                    break;
                case ("cd"):
                    path = Cd.execute(path, command[1]);
                    break;
                case ("exit"):
                    input.close();
                    break;
                default:
                    System.err.println("Unknown command");
            }
        }
    }
}
