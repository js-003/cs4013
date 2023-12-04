import java.util.*;

public class StudentDatabase extends Database<Student> {
    StudentDatabase(){
        super.general_db = new TreeMap<>();
        super.file_name = "StudentDB.csv";
        super.loadFromFile();
    }

    public String[] getDetails(String id){
        return super.general_db.get(id);
    }

    @Override

    public void addToDb(Student o) {
        String[] row = o.toString().split(",");
        // Store only the necessary elements, excluding the key
        general_db.put(row[0], Arrays.copyOfRange(row, 1, row.length));
        saveToFile();
    }

}
