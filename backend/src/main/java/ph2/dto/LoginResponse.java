package ph2.dto;

public class LoginResponse{
    private boolean success;
    private String acname;
    private String name;

    public LoginResponse(boolean success, String acname, String name){
        this.success = success;
        this.acname = acname;
        this.name = name;
    }

    public boolean isSuccess(){
        return success;
    }

    public void setSuccess(boolean success){
        this.success = success;
    }

    public String getAcname(){
        return acname;
    }
    public String getName(){
        return name;
    }
}

