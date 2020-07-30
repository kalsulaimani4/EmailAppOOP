import com.sun.javaws.exceptions.InvalidArgumentException;

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
    public Email(){
        this("defult@gmail.com ","Aa1","defult",0,"none");
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

    public static void testEmail(String email) {
        if (!(email.endsWith( ".com" ) && email.contains( "@" ))) {
            throw new InvalidParameterException( "invalid email doesn't contain " );
        }
    }

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
                    throw new InvalidParameterException("Invalid password did not meet capital,small letter and number requirements ");
                }

            }else{
                throw new InvalidParameterException("password too long ");
            }
        }else{
            throw new InvalidParameterException("password too short");
        }
    }


    public void getInfo(Email em, Vector<Email> emails) {
        if (emails.contains( em )) {
            System.out.println("Name: "+em.getName());
            System.out.println("Age: "+em.getAge());
            System.out.println("city: "+em.getCity());
        } else {
            throw new InvalidParameterException( "invalid email doesn't exist in database " );
        }
    }
}
