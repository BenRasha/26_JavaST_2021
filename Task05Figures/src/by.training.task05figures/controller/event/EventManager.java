import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class EventManager {

    static final Logger eventManagerLogger = LogManager.getLogger(EventManager.class.getName());
    Map<CommandName, List<EventListener>> listeners = new HashMap<>();

    public EventManager(CommandName... commandNames) {
        for (CommandName commandName : commandNames) {
            this.listeners.put(commandName, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener listener) {
        CommandName commandName = null;
        try {
            commandName = CommandName.valueOf(eventType.toUpperCase());
            List<EventListener> users = listeners.get(commandName);
            users.add(listener);
        } catch (IllegalArgumentException exception) {
            eventManagerLogger.error("Error during finding command", exception);
        }
    }

    public void unsubscribe(String eventType, EventListener listener) {
        CommandName commandName = null;
        try {
            commandName = CommandName.valueOf(eventType.toUpperCase());
            List<EventListener> users = listeners.get(commandName);
            users.remove(listener);
        } catch (IllegalArgumentException exception) {
            eventManagerLogger.error("Error during finding command", exception);
        }
    }

    public void notify(String eventType, Command command, Pyramid pyramid) {
        CommandName commandName = null;
        try {
            commandName = CommandName.valueOf(eventType.toUpperCase());
            List<EventListener> users = listeners.get(commandName);
            for (EventListener listener : users) {
                listener.update(commandName, command, pyramid);
            }
        } catch (IllegalArgumentException exception) {
            eventManagerLogger.error("Error during finding command", exception);
        }
    }

}
