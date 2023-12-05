import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.io.*;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Class for improving the user security through hashing and password to user storage
 */
public class AccountDatabase {

    private String file_name;
    private TreeMap<String, String> account_db;
    private final String FILENAME;

    public AccountDatabase(){
        this.FILENAME = "AccountDB.csv";
        this.account_db = new TreeMap<>();
        this.loadFromFile();
    }

    //loads up the file to use
    private void loadFromFile(){
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILENAME));

            while((line = br.readLine()) != null) {
                String[] row = line.split(",");
                for (int i = 0; i < row.length; i++) {
                    // Remove leading and trailing spaces, and then remove all quotation marks
                    row[i] = row[i].trim().replace("\"", "");
                }
                //The below stores the id and password into a treemap
                account_db.put(row[0], row[1]);
            }

        } catch(IOException e) {
            System.out.println("Error reading from the file!");
        }

    }
    // Check is the id key's value password matches pass(the inputted password)
    public boolean login(String id, String pass){
        return Objects.equals(account_db.get(id), preformHashing(pass));
    }

    /**
     * Adds a user to the csv file with passwords hashed
     * @param idOrUsername The user of the services
     * @param pass The value which will be hashed for security purposes
     */
    public void addUser(String idOrUsername, String pass){
        account_db.put(idOrUsername, preformHashing(pass));
        this.saveToFile();
    }

    public void removeUser(String id){
        account_db.remove(id);
        this.saveToFile();
    }
    //saves changes made to the file: MAKE SURE THAT THE FILE IS IN A FOLDER WITH THE CODE OR GIVE THE PATH
    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (Map.Entry<String, String> entry : account_db.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
            }
            System.out.println("Users saved to " + FILENAME);
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
    //Checks the criteria of the password given (formatting seen in the CLI)
    public boolean isValidPassword(String password) {
        //only a certain number of characters will be allowed for the password
        return password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()?]).{8,64}$");
    }
    //Checks the criteria of the id given (formatting seen in the CLI)
    public boolean isValidId(String id) {
        //eight digits in an id
        return id.matches( "^\\d{8}$");
    }

    public boolean isValidUsername(String user) {
        //username for the staff login should be seperated by a dot e.g "michael.english"
        return user.matches(".*\\..*");
    }

    // testing stuff which I have used to help with fixing bugs
    public String toString(){
        StringBuilder holder = new StringBuilder();
        for(Map.Entry< String, String > entry: account_db.entrySet()){
            holder.append(entry.getKey()).append("    ").append(entry.getValue()).append("\n");
        }

        return holder.toString();
    }

    /**
     * Uses the SHA-256 algorithm to convert the passwords into a very long illegible string of characters
     * @param pass The string password which will be hashed
     * @return The hashed password
     */
    private String preformHashing(String pass){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(pass.getBytes());
            byte[] resultByteArray = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for(byte b : resultByteArray){
                sb.append(String.format("%02x" , b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}