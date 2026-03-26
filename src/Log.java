public abstract class Log {

    protected LogLevel level;
    protected String message;

    public Log(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public LogLevel getLevel() {
        return level;
    }
}