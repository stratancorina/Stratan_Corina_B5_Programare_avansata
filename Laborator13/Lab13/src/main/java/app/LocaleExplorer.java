package app;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplorer {
    public void testLocaleApp() {
        DisplayLocales displayLocales = new DisplayLocales();
        SetLocale setLocale = new SetLocale();
        Info info = new Info();

        Scanner scanner = new Scanner(System.in);

        String command;
        String[] input;
        // default value
        String currentLocale = "United States";
        ResourceBundle resources = ResourceBundle.getBundle("Messages");

        boolean isRunning = true;
        while (isRunning) {
            System.out.print(resources.getString("prompt") + ' ');
            command = scanner.nextLine();
            input = command.split(" ");

            switch (input[0]) {
                case "info" -> {
                    System.out.println(MessageFormat.format(resources.getString("info"), currentLocale));
                    info.getInfo(Locale.getDefault());
                }
                case "display" -> {
                    System.out.println(resources.getString("locales"));
                    displayLocales.display();
                }
                case "set" -> {
                    if (input.length < 3) {
                        System.out.println("Invalid command. Specify 'set <language> <country>'.");
                        break;
                    }

                    Locale locale = new Locale(input[1], input[2]);
                    setLocale.set(locale);
                    resources = ResourceBundle.getBundle("Messages", locale);
                    currentLocale = locale.getDisplayCountry();
                    System.out.println(MessageFormat.format(resources.getString("locale.set"), currentLocale));
                }
                case "exit" -> {
                    System.out.println("Exiting application...");
                    isRunning = false;
                }
                default -> System.out.println(resources.getString("invalid"));
            }
        }
    }

    public static void main(String[] args) {
        LocaleExplorer app = new LocaleExplorer();
        app.testLocaleApp();
    }
}
