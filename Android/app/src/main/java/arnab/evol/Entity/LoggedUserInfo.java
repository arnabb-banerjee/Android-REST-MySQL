package arnab.evol.Entity;

public class LoggedUserInfo {
    private static LoggedUserInfo instance;
    private String user_type;
    private String user_code;
    private String email;
    private String mobile;
    private String shop_name;
    private String User_password_status;
    private String User_status;

    public synchronized static LoggedUserInfo GetInstance(){
        if(instance==null){
            instance = new LoggedUserInfo();
        }
        return instance;
    }

    public String getUser_type() { return user_type; }
    public void setUser_type(String user_type) { this.user_type = user_type; }

    public String getUser_coe() { return user_code; }
    public void setuser_code(String user_code) { this.user_code = user_code; }

    public String getUser_password_status() { return User_password_status; }
    public void setUser_password_status(String User_password_status) { this.User_password_status = User_password_status; }

    public String getUser_status() { return User_status; }
    public void setUser_status(String User_status) { this.User_status = User_status; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

}
