import java.util.Locale;
import java.util.ResourceBundle;

public enum MessageManager {
    EN(ResourceBundle.getBundle("text", new Locale("en", "EN"))),
    RU(ResourceBundle.getBundle("text", new Locale("ru", "RU")));

    private ResourceBundle bundle;

    MessageManager(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    public void changeResource(Locale locale) {
        bundle = ResourceBundle.getBundle("text", locale);
    }

    public String getString(String key) {
        return bundle.getString(key);
    }

    public ResourceBundle getBundle() {
        return bundle;
    }
}
