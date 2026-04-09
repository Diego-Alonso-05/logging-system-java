package M2;

import M0.Log;

public class ErrorLogFactory extends LoggingFactory {

    private static ErrorLogFactory instance;

    private ErrorLogFactory() {}

    public static ErrorLogFactory getInstance() {
        if (instance == null) {
            instance = new ErrorLogFactory();
        }
        return instance;
    }

    @Override
    public Log createLog(String message) {
        return new ErrorLog(message);
    }
}