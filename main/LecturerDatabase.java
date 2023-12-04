import java.util.*;

public class LecturerDatabase extends Database<Lecturer> {
    LecturerDatabase(){
        super.general_db = new TreeMap<>();
        super.file_name = "ModuleDB.csv";
        super.loadFromFile();
    }


    public String[] getDetails(String id){
        return super.general_db.get(id);
    }

    @Override

    public void addToDb(Lecturer o) {
        String[] row = o.toString().split(",");
        // Store only the necessary elements, excluding the key
        general_db.put(row[0], Arrays.copyOfRange(row, 1, row.length));
        saveToFile();
    }

}