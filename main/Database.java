import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
public abstract class Database {
    protected String file_name;
    protected TreeMap<String, String[]> general_db;

    protected void loadFromFile() {
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file_name));

            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                for (int i = 0; i < row.length; i++) {

                    row[i] = row[i].trim().replace("\"", "").replaceAll("^\\[|\\]$", "");
                }

                general_db.put(row[0], Arrays.copyOfRange(row, 1, row.length));
            }

        } catch (IOException e) {
            System.out.println("Error reading from the file!");
        }
    }


    protected void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file_name))) {
            for (Map.Entry<String, String[]> entry : general_db.entrySet()) {
                writer.println(entry.getKey() + "," + Arrays.toString(entry.getValue()).replaceAll("^\\[|\\]$", "").replaceAll(" ", ""));
            }
            System.out.println("Users saved to " + file_name);
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    abstract void addToDb(Object o);

    abstract void removeFromDb(String keyValue);
}
