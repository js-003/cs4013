import java.util.Objects;
import java.util.Scanner;


public class CLI {

    private String user_id;
    private String password;
    //Admin password for restricted access
    private String admin_pass = "TestingStuff123?";
    private String admin_pass_attempt = "";
    public void run() {
        Scanner in = new Scanner(System.in);
        boolean running = true;
        AccountDatabase user_db = new AccountDatabase("Account.csv");
        System.out.println(user_db.toString());

        while (running) {
            System.out.println("L)ogin F)ormatting A)dd-User R)emove-User ~more functionality to be added~");
            String command = in.nextLine();
            switch (command) {
                case "L" -> {
                    System.out.println("Enter your user id.");
                    user_id = in.nextLine();
                    System.out.println("Enter the user's password.");
                    password = in.nextLine();
                    if (user_db.login(user_id, password)) {
                        System.out.println("login was successful");
                    } else {
                        System.out.println("login was unsuccessful");
                    }
                }
                case "F" -> {
                    System.out.println("""
                            #####################################################################
                            ID FORMATTING:
                            -IDs will contain only 8 numbers
                                                        
                            PASSWORD FORMATTING:
                            -Ensure that at least one upper case letter is used
                            -Ensure that at least one lower case letter is used
                            -Ensure that at least one digit is used
                            -Ensure that at least one special character is used from the follow:
                                        [ !, @, #, $, %, ^, &, *, (, ), ? ]
                            -Only passwords with 8 to 64 characters will be acceptable
                            #####################################################################""");


                }
                case "A" -> {
                    System.out.println("Create the new user ID");
                    user_id = in.nextLine();
                    if(!user_db.isValidId(user_id)){
                        System.out.println("Invalid ID try again!");
                        break;
                    }
                    System.out.println("Create the new password for that user");
                    password = in.nextLine();
                    if(!user_db.isValidPassword(password)){
                        System.out.println("Invalid password try again!");
                        break;
                    }
                    System.out.println("ADMIN PASSWORD REQUIRED TO PROCEED");
                    admin_pass_attempt = in.nextLine();
                    if(Objects.equals(admin_pass_attempt, admin_pass)) {
                        user_db.addUser(user_id, password);
                        user_db.saveToFile();
                        System.out.println("New user added!");
                    } else {
                        System.out.println("INCORRECT PASSWORD: ACCESS DENIED!");
                    }
                }
                case "R" -> {
                    System.out.println("Enter user ID");
                    user_id = in.nextLine();
                    if(!user_db.isValidId(user_id)){
                        System.out.println("Invalid ID try again!");
                        break;
                    }
                    System.out.println("ADMIN PASSWORD REQUIRED TO PROCEED");
                    admin_pass_attempt = in.nextLine();
                    if(Objects.equals(admin_pass_attempt, admin_pass)) {
                        user_db.removeUser(user_id, password);
                        user_db.saveToFile();
                        System.out.println("User removed!");
                    } else {
                        System.out.println("INCORRECT PASSWORD: ACCESS DENIED!");
                    }

                }

            }

        }
    }
}
