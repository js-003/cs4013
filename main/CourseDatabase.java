import java.util.*;

public class CourseDatabase extends Database<Course> {
    /**
     * Creates a database to store courses
     */
    CourseDatabase(){
        super.general_db = new TreeMap<>();
        super.file_name = "CourseDB.csv";
        super.loadFromFile();

    }

    /**
     * Returns the course details
     *
     * @param id Unique key
     * @return Course details
     */

    public String[] getDetails(String id){
        return super.general_db.get(id);
    }

    /**
     * Adds a course object to the database
     *
     * @param o Course object
     */
    @Override
    public void addToDb(Course o) {
        String[] row = o.toString().split(",");
        // Store only the necessary elements, excluding the key
        general_db.put(row[0], Arrays.copyOfRange(row, 1, row.length));
        saveToFile();
    }
}