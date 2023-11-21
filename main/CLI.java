import java.util.Objects;
import java.util.Scanner;


public class CLI {

    private String user_id;
    private String password;
    //Admin password for restricted access
    private String admin_pass = "TestingStuff123?";
    Scanner in = new Scanner(System.in);
    AccountDatabase user_db = new AccountDatabase("Account.csv");
    public void run() {
        boolean running = true;
        System.out.println(user_db.toString());
        while (running) {
            System.out.println("U)ser-Acess F)ormatting A)dmin-Access ~more functionality to be added~");
            String command = in.nextLine();
            switch (command) {
                case "U" -> {
                    userAcess();
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
                    adminAccess();
                }

            }

        }
    }

    private void adminAccess(){
        System.out.println("ADMIN PASSWORD REQUIRED");
        String admin_pass_attempt = in.nextLine();
        if(Objects.equals(admin_pass_attempt, admin_pass)) {
            System.out.println("ACCESS GRANTED");
            String adminCommands;
            boolean running = true;
            while(running){
                System.out.println("A)dd-User R)emove-User Q)uit");
                adminCommands = in.nextLine();
                switch(adminCommands){
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
                        user_db.addUser(user_id, password);
                        System.out.println("New user added!");
                    }
                    case "R" -> {
                        System.out.println("Enter user ID for removal");
                        user_id = in.nextLine();
                        if(!user_db.isValidId(user_id)){
                            System.out.println("Invalid ID try again!");
                            break;
                        }
                        user_db.removeUser(user_id);
                        System.out.println("User removed!");
                    }
                    case "Q" -> {
                        running = false;
                    }
                }
            }
        }

    }

    public void userAcess(){
        boolean running = true;
        String userCommandds;
        while(running){
            System.out.print("L)ogin Q)uit ~more functionality to be added~" );
            userCommandds = in.nextLine();
            switch(userCommandds){
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
                case "Q" -> {
                    running = false;
                }
            }
        }
    }
}
