/**
 * Represents a warning log message.
 */
public class WarningLog extends Log {

    public WarningLog(String message) {
        super(message);
        this.level = LogLevel.WARNING;
    }
}