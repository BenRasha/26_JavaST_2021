public class CapacityNotificationListener implements EventListener{

    private double capacity;

    public CapacityNotificationListener() {
        this.capacity = 0;
    }

    @Override
    public void update(CommandName commandName, Command command, Pyramid pyramid) {
        this.capacity = command.execute(commandName.name(), pyramid);
        System.out.println("Someone has just changed capacity:" + this.capacity);
    }
}
