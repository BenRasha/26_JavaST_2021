import java.io.FileNotFoundException;

public class Runner {

    public static void main (String []args) throws NumbersException, FileNotFoundException {
        Menu menu = new Menu();
        menu.go();
    }
}
