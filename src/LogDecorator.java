public abstract class LogDecorator implements LogDestination {

    protected LogDestination wrapped;

    public LogDecorator(LogDestination wrapped) {
        this.wrapped = wrapped;
    }
}