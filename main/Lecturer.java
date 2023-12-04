import java.util.ArrayList;

/**
 * @author Jakub
 */
public class Lecturer {
    private String firstName;
    private String surname;
    private String moduleCode;
    private String phoneNumber;
    private String email;
    private String department;

    private final ArrayList<Integer> listId = new ArrayList<>();

    private String username;

    /**
     * Create a lecturer object passing in the parameters below
     *
     * @param firstName Lecturers first name
     * @param surname Lecturers surname
     * @param moduleCode Lecturers module code
     * @param phoneNumber Lecturers phone number
     * @param email Lecturers email
     * @param department Lecturers department
     */
    public Lecturer(String firstName,String surname, String moduleCode, String phoneNumber, String email, String department){
        this.firstName = firstName;
        this.surname = surname;
        this.moduleCode = moduleCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.department = department;
        generateUsername();
    }

    /**
     * Generates a username for each lecturer created
     */
    public void generateUsername(){
        this.username = this.firstName.toLowerCase()+"."+this.surname.toLowerCase();
    }

    /**
     * Returns the module code of a lecturer
     *
     * @return The module code of a lecturer
     */
    public String getModuleCode(){
        return this.moduleCode;
    }

    /**
     * Returns the first name of a lecturer
     *
     * @return The first name of a lecturer
     */

    public String getFirstName() {
        return firstName;
    }

    /**
     * Changes the first name of a lecturer
     *
     * @param firstName The new name for a lecturer
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the surname of a lecturer
     *
     * @return Surname of a lecturer
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Changes the surname of a lecturer
     *
     * @param newSurname The new surname for a lecturer
     */
    public void setSurname(String newSurname) {
        this.surname = surname;
    }

    /**
     * Returns the phone number of a lecturer
     *
     * @return The phone number of a lecturer
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Changes the phone number of a lecturer
     *
     * @param newNumber The new phone number of a lecturer
     */
    public void setPhoneNumber(String newNumber) {
        this.phoneNumber = newNumber;
    }

    /**
     * Returns the email of a lecturer
     *
     * @return The email of a lecturers
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the login username of a lecturer
     *
     * @return The login username of a lecturers
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * Changes the email of a lecturer
     *
     * @param newEmail The new email for a lecturer
     */
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    /**
     * Returns all lecturer details in string format
     *
     * @return The string format of a lecturers details
     */
    public String toString(){
        return String.format("%s,%s,%s,%s,%s,%s",getUsername(),getFirstName(),getSurname(),getModuleCode(),getPhoneNumber(),getEmail());
    }

    /**
     * Returns the department of a lecturer
     *
     * @return The department of a lecturers
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Changes the department of a lecturer
     *
     * @param department The new department for a lecturer
     */
    public void setDepartment(String department) {
        this.department = department;
    }
}
