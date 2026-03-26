import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class FileLogDestination implements LogDestination {

    @Override
    public void save(Log log) {
        LogConfig config = ConfigManager.INSTANCE.getConfig();
        String path = config.getLogFilePath();
        String format = config.getLogFormat();

        String formattedLog = formatLog(format, log);

        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
            writer.println(formattedLog);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + path);
        }
    }

    private String formatLog(String format, Log log) {

        if (format == null || format.isEmpty()) {
            return "[" + log.getLevel() + "] " + log.getMessage();
        }

        return format
                .replace("{level}", log.getLevel().toString())
                .replace("{message}", log.getMessage())
                .replace("{timestamp}", LocalDateTime.now().toString());
    }
}