import java.security.InvalidParameterException;
import java.util.Vector;

public class EmailOwnerInfo{
    private String name;
    private String city;
    private int age;

    public  EmailOwnerInfo(String name, String city, int age){
        this.name= name;
        this.city=city;
        this.age=age;

    }

    public EmailOwnerInfo(){
        this("defult ","none",0);
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
        this.name = name;
    }

    public String getName() {
        return name;
    }


    
}
