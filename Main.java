import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner (System.in);

        System.out.println("enter number for the service you want : ");
        System.out.println("1- sign up: "+"\n"+"2- sign in: "+"\n"+"3- end program: ");
        int option = scan.nextInt();
        int numOfTermination=0;

        while(numOfTermination!=3){
            switch (option){
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("invalid option try again ");
                    continue;
            }

        }
    }
}
