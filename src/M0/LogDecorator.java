package M0;

import M3.LogDestination;

public abstract class LogDecorator implements LogDestination {

    protected LogDestination wrapped;

    public LogDecorator(LogDestination wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public abstract void save(Log log);
}