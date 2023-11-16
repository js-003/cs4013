import java.util.Map;
import java.io.*;
import java.util.Objects;
import java.util.TreeMap;

public class AccountDatabase {

    private String file_name;
    private TreeMap<String, String> account_db;

    public AccountDatabase(String file_name){
        this.file_name = file_name;
        this.account_db = new TreeMap<>();
        this.loadFromFile();
    }

    //loads up the file to use
    private void loadFromFile(){
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file_name));

            while((line = br.readLine()) != null) {
                String[] row = line.split(",");
                for (int i = 0; i < row.length; i++) {
                    // Remove leading and trailing spaces, and then remove all quotation marks
                    row[i] = row[i].trim().replace("\"", "");
                }
                //The below stores the id and password into a treemap
                if(this.isValidId(row[0]) && this.isValidPassword(row[1])) {
                    account_db.put(row[0], row[1]);
                }
            }

        } catch(IOException e) {
            System.out.println("Error reading from the file!");
        }

    }
    // Check is the id key's value password matches pass(the inputted password)
    public boolean login(String id, String pass){
        return Objects.equals(account_db.get(id), pass);
    }

    public void addUser(String id, String pass){
        account_db.put(id, pass);
    }

    public void removeUser(String id){
        account_db.remove(id);
    }
    //saves changes made to the file: MAKE SURE THAT THE FILE IS IN A FOLDER WITH THE CODE OR GIVE THE PATH
    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file_name))) {
            for (Map.Entry<String, String> entry : account_db.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
            }
            System.out.println("Users saved to " + file_name);
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
    //Checks the criteria of the password given (formatting seen in the CLI)
    public boolean isValidPassword(String password) {
        //only a certain number of characters will be allowed for the password
        String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()?]).{8,64}$";

        return password.matches(passwordRegex);
    }

    public boolean isValidId(String id) {
        //eight digits in an id
        String idRegex = "^\\d{8}$";
        return id.matches(idRegex);
    }

    // testing stuff which I have used to help with fixing bugs
    public String toString(){
        StringBuilder holder = new StringBuilder();
        for(Map.Entry< String, String > entry: account_db.entrySet()){
            holder.append(entry.getKey()).append("    ").append(entry.getValue()).append("\n");
        }
        return holder.toString();
    }
}
