public class Email {
    private String email;
    private String password;

    public Email(String email,String password){
        this.email=email;
        this.password=password;
    }
    public Email(){
        this("defult@gmail.com ","Aa1");
    }
}
