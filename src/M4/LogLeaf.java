package M4;

import java.util.List;

import M0.Log;

/**
 * Leaf component representing a single log entry.
 */
public class LogLeaf implements LogComponent {

    private Log log;

    public LogLeaf(Log log) {
        this.log = log;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "- " + log.getLevel() + ": " + log.getMessage());
    }

    @Override
    public List<Log> getLogs() {
        return List.of(log);
    }
}