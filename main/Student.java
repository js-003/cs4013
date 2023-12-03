
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;


public class Student {
    private String firstName;
    private String lastName;
    private String id; //when creating student ask them to enter year of study as their id and then use this to generate them an id?
    private String address;
    private String email;
    private String phone;
    private String bankDetails;
    private static ArrayList<String> idList = new ArrayList<>();


    //student constructor
    public Student(String firstName, String lastName, String address, String email, String phone, String bankDetails) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.bankDetails = bankDetails;
        generateStudentId();

    }


    // Method to generate a student ID
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
        idList.add(id);
        this.id = id;

    }

    // Method to change email
    public void changeEmail(String newEmail) {
        // checks to see if newEmail is a valid address,if true changes it

            this.email = newEmail;
            System.out.println("Email changed successfully.");
        }


    //method to change Phone number
    public void changePhone(String newPhone) {
        // checks to see if the newPhone is a valid phone number,if true changes it

            this.phone = newPhone;
            System.out.println("Phone number changed successfully.");
        }


    // Method to change bank details
    public void changeBankDetails(String newBankDetails) {
        //not sure how to check if bank details are correct
        this.bankDetails = newBankDetails;
        System.out.println("Bank details changed successfully.");
    }



    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone(){return phone;
    }

    public String getBankDetails() {
        return bankDetails;
    }

    @Override
    public String toString(){
        return String.format("%s,%s,%s,%s,%s,%s,%s",getFirstName(),getLastName(),getId(),getAddress(),getEmail(),getPhone(),getBankDetails());
    }
}