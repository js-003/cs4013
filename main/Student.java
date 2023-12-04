
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

/**
 * @author Sinead
 */
public class Student {
    private String firstName;
    private String lastName;
    private String id; //when creating student ask them to enter year of study as their id and then use this to generate them an id?
    private String address;
    private String email;
    private String phone;
    private String bankDetails;
    private String courseCode;
    private static ArrayList<String> idList = new ArrayList<>();

    /**
     * student constructor that creates a new stsudent given a firstname,lastname,email
     * phone number and bank details
     * @param firstName Students first name
     * @param lastName Students last name
     * @param email Students email
     * @param address Students address
     * @param phone Students phone number
     * */
    //student constructor
    public Student(String firstName, String lastName, String address, String email, String phone, String courseCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        generateStudentId();
        this.courseCode = courseCode;

    }

    // Method to generate a student ID
    /**
     * method to create a studentId
     * */
    public void generateStudentId() { //or the original id they insert=yearOfstudy
        LocalDate t = LocalDate.now();
        String id = "" + t.toString().charAt(2) + t.toString().charAt(3);
        boolean checker = true;
        while (checker) {
            int i;
            for (i = 2; i < 8; i++) {

                id += ((int) (Math.random() * 10));
            }
            if (!idList.contains(id.toString())) {
                checker = false;

            } else i = 0;

        }
        idList.add(id.toString());
        this.id = id.toString();

    }

    // Method to change email
    /**
     * method to change an email address number
     * @param newEmail the updated address number
     * */
    public void changeEmail(String newEmail) {
        // checks to see if newEmail is a valid address,if true changes it
        if (isValidEmail(newEmail)) {
            this.email = newEmail;
            System.out.println("Email changed successfully.");
        } else {
            System.out.println("Invalid email format. Email not changed.");
        }
    }

    //method to change Phone number
    /**
     * method to change a phone number
     * @param newPhone the updated phone number
     * */
    public void changePhone(String newPhone) {
        // checks to see if the newPhone is a valid phone number,if true changes it
        if (isValidPhone(newPhone)) {
            this.phone = newPhone;
            System.out.println("Phone number changed successfully.");
        } else {
            System.out.println("Invalid phone number format. Phone number not changed.");
        }
    }

    // Method to change bank details
    /**
     * method that changes bankDetails to the String inputted as a parameter
     * @param newBankDetails updated bankDetails
     * #*/
    public void changeBankDetails(String newBankDetails) {
        //not sure how to check if bank details are correct
        this.bankDetails = newBankDetails;
        System.out.println("Bank details changed successfully.");
    }

    // Validation method for email
    private boolean isValidEmail(String email) {
        // if the email conatins an '@' and a '.'it's considered valid
        return email.contains("@") && email.contains(".");
    }

    // Validation method for phone number format
    private boolean isValidPhone(String phone) {
        // Add your phone number validation logic here
        // For simplicity, a basic check for numeric characters is done
        return phone.matches("\\d+");
    }

    /**
     * method to return a students id number as a string
     * */

    public String getId() {
        return id;
    }
    /**
     * method to return a student's firstname as a string
     * */
    public String getFirstName() {
        return firstName;
    }
    /**
     * method to return a student's lastname as a string
     * */
    public String getLastName() {
        return lastName;
    }
    /**
     * method to return a student's address as a string
     * */
    public String getAddress() {
        return address;
    }
    /**
     * method to return a student's email as a string
     * */
    public String getEmail() {
        return email;
    }
    /**
     * method to return a student's phone number as a string
     * */
    public String getPhone(){return phone;
    }
    /**
     * method to return a student's bank details as a string
     * */
    public String getBankDetails() {
        return bankDetails;
    }
    /**
     * method to return a student's details as a string
     * */
    public String toString(){
        String format;
        format = String.format("%s,%s,%s,%s,%s,%s,%s", id, firstName, lastName, address, email,phone,courseCode);
        return format;
    }

    //note i know this method will be moved but leaving it here for now
}