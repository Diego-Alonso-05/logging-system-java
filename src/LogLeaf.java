import java.util.List;

/**
 * Leaf component representing a single log entry.
 *
 * Wraps a Log object and provides access to it
 * within the composite structure
 */

public class LogLeaf implements LogComponent {

    private Log log;

    public LogLeaf(Log log) {
        this.log = log;
    }

    @Override
    public void display() {
        System.out.println(log.getMessage());
    }


    @Override
    public List<Log> getLogs() {
        return List.of(log);
    }


}