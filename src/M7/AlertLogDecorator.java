package M7;

import M0.Log;
import M0.LogDecorator;
import M0.LogLevel;
import M3.LogDestination;

public class AlertLogDecorator extends LogDecorator {

    public AlertLogDecorator(LogDestination wrapped) {
        super(wrapped);
    }

    @Override
    public void save(Log log) {
        wrapped.save(log);

        if (log.getLevel() == LogLevel.ERROR) {
            System.out.println("ALERT: Sending notification!");
        }
    }
}