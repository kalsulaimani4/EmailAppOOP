import java.security.InvalidParameterException;
import java.util.Vector;

public class EmailOwnerInfo{
    private String firstName;
    private String city;
    private int age;

    public  EmailOwnerInfo(String firstName, String city, int age){
        this.firstName= firstName;
        this.city=city;
        this.age=age;

    }

    public EmailOwnerInfo(){
        this("default ","none",0);
    }



    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.firstName = name;
    }

    public String getName() {
        return firstName;
    }
}
