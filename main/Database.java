import java.io.*;
import java.util.*;

public abstract class Database<T> {
    protected String file_name;
    protected TreeMap<String, String[]> general_db;

    /**
     * Converts a csv file into a Treemap<String, String[]>
     */
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
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    /**
     * Stores the tree map into a csv file
     *
     */
    protected void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file_name)))) {
            for (Map.Entry<String, String[]> entry : general_db.entrySet()) {
                String csvLine = entry.getKey() + "," + String.join(",", entry.getValue());
                writer.println(csvLine);
            }
            System.out.println("Users saved to " + file_name);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }


    public abstract void addToDb(T o);

    public void removeFromDb(String keyValue){
        general_db.remove(keyValue);
        saveToFile();
    }

    public Set<String> getUniqueIdentifier(){
        return general_db.keySet();
    }

    public String[] getDetails(String id){
        return general_db.get(id);
    }

    public void removeDB(String id){
        general_db.remove(id);
        saveToFile();
    }

}
