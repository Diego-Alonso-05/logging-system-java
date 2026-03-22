import java.util.List;


/*
 * Component interface for the Composite pattern.
 * Defines common operations for both individual logs
 * and groups of logs, allowing them to be treated uniformly
 */
import java.util.List;

public interface LogComponent {
    void display();
    List<Log> getLogs();
}

