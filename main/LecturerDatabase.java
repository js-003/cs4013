import java.util.Arrays;
import java.util.TreeMap;

public class LecturerDatabase extends Database{
    LecturerDatabase(){
        super.general_db = new TreeMap<>();
        super.file_name = "LecturerDB.csv";
        super.loadFromFile();
    }
    @Override
    public void addToDb(Object o) {
        String[] row = o.toString().split(",");
        // Store only the necessary elements, excluding the key
        super.general_db.put(row[0], Arrays.copyOfRange(row, 1, row.length));
        super.saveToFile();
    }
    @Override
    public void removeFromDb(String keyValue){
        super.general_db.remove(keyValue);
        super.saveToFile();
    }

}
