package ph2.api.auth;
import org.springframework.web.bind.annotation.*;
import ph2.dto.LoginRequest;
import ph2.dto.LoginResponse;
import ph2.service.AuthService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final AuthService authSrv;
    public AuthController(AuthService authService){
        this.authSrv = authService;
    }
    @PostMapping("/api/auth/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authSrv.login(request);
    }   
}
