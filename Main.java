import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner (System.in);

        // printing main menu
        System.out.println("enter number for the service you want : ");
        System.out.println("1- sign up: "+"\n"+"2- sign in: "+"\n"+"3- end program: ");
        int option = scan.nextInt();

        Vector<Email> emails= new Vector<>();// vector to store all the emails in
        // making some predefined emails
        Email khalil = new Email("khalil@icloud.com","Aa123","khalil",20,"makkah");
        emails.add( khalil );
        while(option!=3){

            switch (option){
                case 1:// sign up option
                    Email m = new Email();
                    System.out.println("enter the needed info to make your account : ");
                    System.out.println("Name :");

                    break;
                case 2:// sign in option

                    break;
                default:
                    System.out.println("invalid option try again ");
                    continue;
            }

        }
    }
}
