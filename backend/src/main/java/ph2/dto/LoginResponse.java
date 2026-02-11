package ph2.dto;

public class LoginResponse{
    private boolean success;

    public LoginResponse(boolean success){
        this.success = success;
    }

    public boolean isSuccess(){
        return success;
    }

    public void setSuccess(boolean success){
        this.success = success;
    }

}

