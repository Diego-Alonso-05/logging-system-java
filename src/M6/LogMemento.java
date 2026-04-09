package M6;

import M0.Log;
import M1.LogConfig;
import M4.LogGroup;
import M4.LogLeaf;

public class LogMemento {

    private final LogConfig config;
    private final String destinationType;
    private final LogGroup root;

    public LogMemento(LogConfig config, String destinationType, LogGroup root) {
        this.config = config;
        this.destinationType = destinationType;
        this.root = cloneTree(root);
    }

    private LogGroup cloneTree(LogGroup original) {
        LogGroup copy = new LogGroup("ROOT");

        for (Log log : original.getLogs()) {
            copy.add(new LogLeaf(log));
        }

        return copy;
    }

    public LogConfig getConfig() {
        return config;
    }

    public String getDestinationType() {
        return destinationType;
    }

    public LogGroup getRoot() {
        return root;
    }
}