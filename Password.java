public class Password {
    private String password;
    private int length;
    private String randomPassword;

    public Password(String password,int length){
        this.length = length;
        this.password=password;
    }

    public  Password(){
        this(" ",0);
    }






}
