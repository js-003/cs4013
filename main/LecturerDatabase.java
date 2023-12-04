import java.util.*;

public class LecturerDatabase extends Database<Lecturer> {
    /**
     * Creates a database to store lecturers
     */
    LecturerDatabase(){
        super.general_db = new TreeMap<>();
        super.file_name = "ModuleDB.csv";
        super.loadFromFile();
    }

    /**
     * Returns details from the database
     *
     * @param id Lecturer id
     * @return A String array made up of the details
     */
    public String[] getDetails(String id){
        return super.general_db.get(id);
    }
    /**
     * Adds a lecturer object to the database
     *
     * @param o Lecturer object
     */

    @Override

    public void addToDb(Lecturer o) {
        String[] row = o.toString().split(",");
        // Store only the necessary elements, excluding the key
        general_db.put(row[0], Arrays.copyOfRange(row, 1, row.length));
        saveToFile();
    }

}