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

        while(3 != numOfTermnation){

            // printing main menu
            System.out.println("enter number for the service you want : ");
            System.out.println("1- sign up: "+"\n"+"2- sign in: "+"\n"+"3- end program: ");
            int option = scan.nextInt();

            switch (option){
                case 1:// sign up option
                    // calling empty constructor to make the object and then setting all the needed info
                    Email m = new Email();

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
                            Email.testEmail( email );
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

                    break;

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
