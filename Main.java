import java.security.InvalidParameterException;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner (System.in);

        int numOfTermnation=0;// what will end the while loop

        Vector<Email> emails= new Vector<>();// vector to store all the emails in
        // making some predefined emails
        Email khalil = new Email("khalil@icloud.com","Aa123","khalil",20,"makkah");
        emails.add( khalil );

        start:
        while(3 != numOfTermnation){

            // printing main menu
            System.out.println("enter number for the service you want : ");
            System.out.println("1- sign up: "+"\n"+"2- sign in: "+"\n"+"3- end program: ");
            int option = scan.nextInt();
            Email m = new Email();

            switch (option){
                case 1:// sign up option
                    // calling empty constructor to make the object and then setting all the needed info

                    System.out.println("enter the needed info to make your account : ");

                    // getting name,age and city info and  setting it
                    System.out.println("Enter your first name  : ");
                    m.setName( scan.next() );

                    System.out.println("Enter your age : ");
                    m.setAge( scan.nextInt() );

                    System.out.println("Enter your city : ");
                    m.setCity( scan.next() );


                    //getting email testing it and setting it if the test method throws a exception make user renter email
                    String email;//declaring variable before loop to be able to set it outside the loop so we can test
                    while(true) {
                        System.out.println( "enter the new email: " );
                         email = scan.next();
                        try {
                            Email.testEmail( email, emails );
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            continue;//if we catch a email continue loop till no exception is thrown
                        }
                        // if no exception is caught break from loop
                        break;
                    }
                    m.setEmail( email );

                    //getting password and testing if it meets the requirements same processes as email test
                    //making user enter password twice before setting it and testing if its the same
                    String password;
                    System.out.println( "Enter the password you want to use for your email " + m.getEmail() + ": " );

                    while(true) {

                        System.out.println("Password requirements length from 3 to 12 and one capital letter and a small letter and a number at least");
                        password = scan.next();

                        try {
                            Email.testPassword( password );

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        break;
                    }

                    System.out.println("Valid password renter password for you to remember it");
                    while (true) {
                        String match= scan.next();
                        try {
                            Email.testTwice( password,match );

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        break;
                    }

                    m.setPassword( password );
                    emails.add( m );
                    break;
                case 2:// sign in option
                    String loginEmail;
                    String loginPassword;
                    Email user;
                    int index;
                    while (true) {
                        System.out.println( "enter Email : " );
                        loginEmail = scan.next();
                        try {
                            Email.testEmailLogIn( loginEmail );
                            index =Email.logInEmailTest( loginEmail , emails );
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        break;
                    }

                    user=emails.elementAt( index );
                    while (true){
                        System.out.println("Enter password :");
                        loginPassword = scan.next();

                        try{
                            Email.loginPasswordTest( loginPassword,user);
                        }catch (InvalidParameterException e){
                            System.out.println(e.getMessage());
                            continue;
                        }
                        break;
                    }

                    System.out.println("you have logged in ");;

                    while (true) {
                        System.out.println( "enter which option you want " );
                        System.out.println("1- Print all account info "+"\n2- Change password \n3- Sign out ");
                        int opt = scan.nextInt();
                        switch (opt){
                            case 1:
                                Email.getInfo( user );
                                break ;
                            case 2:
                                // testing old password to verify user
                                while(true) {
                                    System.out.println( "enter old password " );
                                    String oldPass = scan.next();
                                    try {
                                        Email.testTwice( user.getPassword(),oldPass );
                                    }catch (Exception e){
                                        System.out.println(e.getMessage());
                                        continue ;
                                    }

                                // changing the password for the user but testing of it meets the requirements
                                    while(true) {
                                        System.out.println( "enter new Password " );
                                        String newPass = scan.next();
                                        try {
                                            Email.testPassword( newPass );
                                        } catch (Exception e){
                                            System.out.println(e.getMessage());
                                            continue ;
                                        }
                                        Email.changePassword( newPass,user );
                                        break ;
                                    }
                                    System.out.println("password has been changed to "+user.getPassword());
                                    break ;
                                }
                                break ;
                            case 3:
                                continue start;// jump to the starting loop

                            default:
                                System.out.println("Invalid option ");
                                continue ;
                        }
                    }
                case 3:
                    System.out.println("program terminated ");
                    numOfTermnation=3;
                    continue;

                default:
                    System.out.println("invalid option try again ");
                    continue;
            }

        }
    }
}
