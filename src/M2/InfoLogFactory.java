package M2;

import M0.Log;

public class InfoLogFactory extends LoggingFactory {

    private static InfoLogFactory instance;

    private InfoLogFactory() {}

    public static InfoLogFactory getInstance() {
        if (instance == null) {
            instance = new InfoLogFactory();
        }
        return instance;
    }

    @Override
    public Log createLog(String message) {
        return new InfoLog(message);
    }


}