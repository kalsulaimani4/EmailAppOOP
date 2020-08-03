
import java.security.InvalidParameterException;
import java.util.Vector;

public class Email extends EmailOwnerInfo{
    private String email;
    private String password;

    public Email(String email,String password,String name,int age,String city){
        super(name,city,age);
        this.email=email;
        this.password=password;
    }

    public Email(String email,String password){
        this.email=email;
        this.password=password;
    }
    public Email(){
        this("defult@gmail.com ","Aa1","default",0,"default");
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    // test if the given email contains  the @ sign and ends with .com
    public static void testEmail(String email) {
        if (!(email.endsWith( ".com" ) && email.contains( "@" ))) {
            throw new InvalidParameterException( "invalid email doesn't contain  @ or doesn't end with .com \n" );
        }
    }

    // test eatch char if its cap or small or a didgit and if it meets the requirements if not throw a exception
    public static  void testPassword(String password){
        int len=password.length();
        int capCount=0;
        int smallCount=0;
        int digitCount=0;
        if(len>=3){
            if(len<=12){
                for(int i=0;i<len;i++){
                    char ch=password.charAt( i );
                    if(Character.isUpperCase( ch )){
                        capCount++;
                    }if(Character.isLowerCase( ch )){
                        smallCount++;
                    }if(Character.isDigit( ch )){
                        digitCount++;
                    }
                }
                if(!(capCount>=1 && smallCount>=1 && digitCount>=1)){
                    throw new InvalidParameterException("Invalid password did not meet capital,small letter and number requirements \n");
                }

            }else{
                throw new InvalidParameterException("password too long \n");
            }
        }else{
            throw new InvalidParameterException("password too short \n");
        }
    }

    // print user info
    public static void getInfo(Email email) {

            System.out.println("Name: "+email.getName());
            System.out.println("Age: "+email.getAge());
            System.out.println("city: "+email.getCity());

    }

    // test the password twice to make sure suer remebers the password
    public static void testTwice(String firstPassword,String secondPassword){

        if(!(firstPassword.equals( secondPassword ))){
            throw new InvalidParameterException("passwords don't match enter again ");
        }

    }

    // if the element is in the vector we wont go into the if statement after the for loop . if it is not we will and the exception will be thrown
    public static int  logInEmailTest(String email, Vector<Email> emails) {
        boolean test = false;
        int j=0,i=0;
        for(i=0,j=0;i<emails.size();i++){
            if(emails.elementAt( i ).getEmail().equals( email )){
                test=true;
                j=i;
            }else if(i==(emails.size()-1)){
                test=false;
            }
        }
        if(test==false){
            throw new InvalidParameterException("Email dosnt exist");
        }
        return j;
    }

    public  static void loginPasswordTest(String testPassword,Email user){
        if(user.getPassword().equals( testPassword )){
            System.out.println("welcome");
        }else{
            throw new InvalidParameterException("wrong password try again"+user.getPassword());

        }
    }

}
