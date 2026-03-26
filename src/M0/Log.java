package M0;

/**
 * Abstract base class for all log types.
 * Defines common attributes and enforces specific behavior
 * through the formatMessage method.
 */
public abstract class Log {

    protected LogLevel level;
    protected String message;

    public Log(String message) {
        this.message = message;
    }

    public abstract void formatMessage();

    public String getMessage() {
        return message;
    }

    public LogLevel getLevel() {
        return level;
    }
}
