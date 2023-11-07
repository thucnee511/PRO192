package control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Admin
 */
public final class Menu {

    private List<String> options = new ArrayList<>();
    private String title;

    public Menu() {
    }

    public Menu(String title) {
        this.title = title;
    }

    public void setOptions(String options, String regex) {
        List<String> choices = Arrays.asList(options.split(regex));
        this.options.addAll(choices);
    }

    public void printMenu() {
        System.out.println(toTitleLine(title));
        int count = 1;
        for (String line : options) {
            System.out.println(count + ". " + line);
            count++;
        }
    }

    public int getChoice() throws Exception {
        int choice = DataInput.getNumber("Select an option: ", "!>> Choice invalid. Choice must be an integer number");
        if (choice <= options.size()) {
            return choice;
        } else {
            return -1;
        }
    }

    public static String toTitleLine(String str) {
        String tmp = String.join("", Collections.nCopies(30, "*"));
        String titleLine = String.format("%s %s %s", tmp, str, tmp);
        return titleLine;
    }
}
