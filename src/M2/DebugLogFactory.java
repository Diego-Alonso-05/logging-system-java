package M2;

import M0.Log;

public class DebugLogFactory extends LoggingFactory {

    private static DebugLogFactory instance;

    private DebugLogFactory() {}

    public static DebugLogFactory getInstance() {
        if (instance == null) {
            instance = new DebugLogFactory();
        }
        return instance;
    }

    @Override
    public Log createLog(String message) {
        return new DebugLog(message);
    }
}