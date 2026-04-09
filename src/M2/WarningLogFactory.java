package M2;

import M0.Log;

public class WarningLogFactory extends LoggingFactory {

    private static WarningLogFactory instance;

    private WarningLogFactory() {}

    public static WarningLogFactory getInstance() {
        if (instance == null) {
            instance = new WarningLogFactory();
        }
        return instance;
    }

    @Override
    public Log createLog(String message) {
        return new WarningLog(message);
    }
}