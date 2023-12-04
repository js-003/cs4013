import java.util.*;

public class StudentDatabase extends Database<Student> {
    /**
     * Creates a database to store student details
     */
    StudentDatabase(){
        super.general_db = new TreeMap<>();
        super.file_name = "StudentDB.csv";
        super.loadFromFile();
    }

    /**
     * Returns student details by searching for a student by their ID
     *
     * @param id Student id
     * @return Student details
     */

    public String[] getDetails(String id){
        return super.general_db.get(id);
    }

    /**
     * Adds a student object to the database
     *
     * @param o Student Object
     */
    @Override
    public void addToDb(Student o) {
        String[] row = o.toString().split(",");
        // Store only the necessary elements, excluding the key
        general_db.put(row[0], Arrays.copyOfRange(row, 1, row.length));
        saveToFile();
    }

}
