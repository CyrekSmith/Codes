import java.io.*;
import java.util.*;

public class DataManager {
    private static final String FILE_NAME = "internships.txt";

    public static void save(List<Internship> internships) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Internship i : internships) {
                writer.write(i.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    public static List<Internship> load() {
        List<Internship> list = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return list;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(Internship.fromFileString(line));
            }
        } catch (IOException e) {
            System.out.println("Error loading data.");
        }
        return list;
    }
}
