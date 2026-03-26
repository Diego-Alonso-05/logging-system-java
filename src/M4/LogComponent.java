package M4;

import java.util.List;

import M0.Log;

/*
 * Component interface for the Composite pattern.
 * Defines common operations for both individual logs
 * and groups of logs, allowing them to be treated uniformly
 */

public interface LogComponent {
    void display();
    List<Log> getLogs();
}

