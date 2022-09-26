import java.io.*;
import java.util.*;

public class Program {

    private static final String SIGNATURE_PATH = "signature.txt";
    private static final String OUTPUT_PATH = "result.txt";
    private static final String PROCESSED = "PROCESSED";
    private static final String UNDEFINED = "UNDEFINED";
    private static final String TERMINATOR = "42";

    public static void main(String[] args) {
        try (FileOutputStream result = new FileOutputStream(OUTPUT_PATH)) {
            File f;
            int index;
            String bytes;
            String input = "", type;
            LinkedHashMap<String, String> mapOfSigns = new LinkedHashMap<>();
            Scanner scanner = new Scanner(System.in);

            parsSignatures(mapOfSigns);

            while (!input.equals(TERMINATOR)) {
                input = scanner.next();
                index = input.indexOf(".");
                if (index != -1) {
                    type = input.substring(index + 1);
                    bytes = mapOfSigns.get(type);
                    if (bytes != null) {
                        f = new File(input);
                        if (f.exists() && !f.isDirectory()) {
                            bytes = type.toUpperCase();
                            for (int i = 0; i < bytes.length(); ++i) {
                                result.write(bytes.charAt(i));
                            }
                            result.write('\n');
                            System.out.println(PROCESSED);
                        }
                    } else {
                        System.out.println(UNDEFINED);
                    }
                } else if (!input.equals(TERMINATOR)) {
                    System.out.println(UNDEFINED);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void parsSignatures(LinkedHashMap<String, String> mapOfSigns) throws IOException {
        try (FileInputStream signatures = new FileInputStream(SIGNATURE_PATH)) {
            int i, k;
            StringBuilder in = new StringBuilder();

            while ((i = signatures.read()) != -1) {
                if (i == '\n') {
                    k = in.indexOf(",");
                    mapOfSigns.put((in.substring(0, k)).toLowerCase(), in.substring(k + 2));
                    in.delete(0, in.length());
                } else {
                    in.append((char) i);
                }
            }
            k = in.indexOf(",");
            mapOfSigns.put(in.substring(0, k).toLowerCase(), in.substring(k + 2));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}