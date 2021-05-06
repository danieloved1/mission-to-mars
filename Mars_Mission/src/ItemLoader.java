import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ItemLoader {
    private String fileName;

    public ItemLoader(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<Item> loadItems() {
        ArrayList<Item> items = new ArrayList<Item>();
        Parser<Item> parser = new ItemParser();
        String record = "";

        try {
            File itemsFile = new File(this.fileName);
            Scanner in = new Scanner(itemsFile);

            while (in.hasNextLine()) {
                record = in.nextLine();
                items.add(parser.parse(record));
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found " + this.fileName);
        } catch (InputMismatchException | NumberFormatException e) {
            System.err.println("Error parsing items record '" + record + '\'');
        }

        System.out.println("Number of items loaded " + items.size());
        return items;
    }
}
