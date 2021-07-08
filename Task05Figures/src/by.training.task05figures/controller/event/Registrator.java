public class Registrator {
    public EventManager events;
    private Command command;

    public Registrator() {
        this.events = new EventManager(CommandName.COUNT_AREA, CommandName.COUNT_CAPACITY);
    }

    public double countArea(Pyramid pyramid) {
        this.command = new CountAreaImpl();
        events.notify("count_area", command, pyramid);
        return command.execute("count_area", pyramid);
    }

    public double countCapacity(Pyramid pyramid) {
        this.command = new CountCapacityImpl();
        events.notify("count_capacity", command, pyramid);
        return command.execute("count_capacity", pyramid);
    }
}
