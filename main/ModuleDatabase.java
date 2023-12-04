import java.util.*;

public class ModuleDatabase extends Database<Module> {

    /**
     * Creates a database to store modules
     */
    ModuleDatabase(){
        super.general_db = new TreeMap<>();
        super.file_name = "ModuleDB.csv";
        super.loadFromFile();
    }

    /**
     * Adds a module object to the database
     * @param o Module Object
     */
    @Override

    public void addToDb(Module o) {
        String[] row = o.toString().split(",");
        // Store only the necessary elements, excluding the key
        general_db.put(row[0], Arrays.copyOfRange(row, 1, row.length));
        saveToFile();
    }

}