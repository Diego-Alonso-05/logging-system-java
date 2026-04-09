package M4;

import M0.Log;
import java.util.List;

/*
 * Component interface for the Composite pattern.
 * Allows treating individual logs and groups uniformly.
 */
public interface LogComponent {

    // Show tree with indentation
    void display(String indent);

    // Plain logs and save
    List<Log> getLogs();
}