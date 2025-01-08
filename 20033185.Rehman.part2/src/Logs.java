import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Logs {
    private static Logs instance;
    private StringBuilder log;

    private Logs() {
        log = new StringBuilder();
    }

    public static Logs getInstance() {
        if (instance == null) {
            instance = new Logs();
        }
        return instance;
    }

    public void addEntry(String entry) {
        log.append(entry).append("\n");
    }

    public void writeToFile(String filename) {
        try {
            Files.write(Paths.get(filename), log.toString().getBytes());
            System.out.println("Written Logs to " + filename);
        } catch (IOException e) {
            System.err.println("Log File failed to be written to : " + e.getMessage());
        }
    }
}
