
/**
 * Represents a debug log message.
 *
 * Used for development and debugging purposes,
 * providing detailed internal information
 */



public class DebugLog extends Log {

    public DebugLog(String message) {
        super(message);
        this.level = LogLevel.DEBUG;
        formatMessage();
    }

    @Override
    public void formatMessage() {
        this.message = "DEBUG: " + message;
    }
}