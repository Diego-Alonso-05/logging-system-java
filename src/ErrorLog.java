
/**
 * Represents an error log message.
 * Sets the log level to ERROR and formats the message accordingly
 */

public class ErrorLog extends Log {

    public ErrorLog(String message) {
        super(message);
        this.level = LogLevel.ERROR;
        formatMessage();
    }

    @Override
    public void formatMessage() {
        this.message = "ERROR: " + message;
    }
}