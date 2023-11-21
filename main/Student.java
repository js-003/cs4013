package main;

import java.util.Random;

public class Student {
    private String first_Name;
    private String last_Name;
    private int id; //when creating student ask them to enter year of study as their id and then use this to generate them an id?
    private String address;
    private String email;
    private String phone;
    private String bankDetails;

    public Student(String first_Name, String last_Name, int id, String address, String email, String phone, String BankDetails) {
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.id = id; //do i remove id as a paramter and then just generate one? or do i allow them to enter an id number and reset it later
        this.address = address;
        this.email = email;
        this.phone = phone;


    }

    // Method to generate a student ID
    public int generateStudentId(int yearOfStudy) { //or the original id they insert=yearOfstudy
        // to get last two digits from the year of study
        int lastTwoDigits = yearOfStudy % 100;

        // Generate random 6-digit number
        Random random = new Random();
        int randomSixDigits = random.nextInt(900000) + 100000; // all 6 digit number are between 100000 upto (not including) 1,000,000

        // to add last two digits to randomSixDigits
        int studentId = (lastTwoDigits * 1000000) + randomSixDigits; //ensures they are the first 2 digits in the id

        // Set the generated ID to be the new id
        this.id = studentId;
        return id;
        //need to add a check if already exists but not 100% because this class describes 1 student not all students.
    }

    // Method to change email
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
}
//going to add getters and setters later
//trying to work out how to enusre an address is valid (maybe by zip/eir code?)