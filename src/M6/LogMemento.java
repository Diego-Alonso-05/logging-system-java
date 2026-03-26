package M6;

import M1.LogConfig;

public class LogMemento {

    private final LogConfig config;
    private final String destinationType;

    public LogMemento(LogConfig config, String destinationType) {
        this.config = config;
        this.destinationType = destinationType;
    }

    public LogConfig getConfig() {
        return config;
    }

    public String getDestinationType() {
        return destinationType;
    }
}