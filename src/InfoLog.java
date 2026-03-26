public class InfoLog extends Log {

    public InfoLog(String message) {
        super(message);
        this.level = LogLevel.INFO;
    }
}