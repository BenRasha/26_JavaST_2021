import java.util.Arrays;
import java.util.List;

public enum CommandName {
    CHANGE_WHEEL(Arrays.asList("change_wheel", "сменить_колесо")),
    CHARGE_ENGINE(Arrays.asList("charge_engine", "заправить_двигатель")),
    SHOW_BRAND(Arrays.asList("show_brand", "показать_марку")),
    DRIVE_AUTOMOBILE(Arrays.asList("drive_automobile", "вести_автомобиль")),
    WRONG_REQUEST(Arrays.asList("wrong_request", "неверный_запрос"));

    private List<String> internationalNames;

    CommandName(List<String> internationalNames) {
        this.internationalNames = internationalNames;
    }

    public List<String> getInternationalNames() {
        return internationalNames;
    }
}
