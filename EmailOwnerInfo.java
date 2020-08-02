import java.security.InvalidParameterException;
import java.util.Vector;

public class EmailOwnerInfo{
    private String name;
    private String city;
    private int age;
    private String backQuestion;
    private String backQuestionAnswer;

    public  EmailOwnerInfo(String name, String city, int age,String backQuestion,String backQuestionAnswer){
        this.name= name;
        this.city=city;
        this.age=age;
        this.backQuestion=backQuestion;
        this.backQuestionAnswer=backQuestionAnswer;
    }

    public EmailOwnerInfo(){
        this("default ","none",0,"default","default");
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

    public void setBackQuestion(String backQuestion) {
        this.backQuestion = backQuestion;
    }

    public String getBackQuestion() {
        return backQuestion;
    }

    public void setBackQuestionAnswer(String backQuestionAnswer) {
        this.backQuestionAnswer = backQuestionAnswer;
    }

    public String getBackQuestionAnswer() {
        return backQuestionAnswer;
    }



}
