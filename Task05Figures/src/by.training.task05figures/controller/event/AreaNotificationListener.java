public class AreaNotificationListener implements EventListener{

    private double area;

    public AreaNotificationListener() {
        this.area = 0;
    }

    @Override
    public void update(CommandName commandName, Command command, Pyramid pyramid) {
        this.area = command.execute(commandName.name(), pyramid);
        System.out.println("Someone has just changed the area:" + this.area);
    }
}
