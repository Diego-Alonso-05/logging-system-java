package M6;

import M1.LogConfig;
import M4.LogGroup;

public class LogMemento {

    private final LogConfig config;
    private final String destinationType;
    private final LogGroup root;

    public LogMemento(LogConfig config, String destinationType, LogGroup root) {
        this.config = config;
        this.destinationType = destinationType;
        this.root = root;
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