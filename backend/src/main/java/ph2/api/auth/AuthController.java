package ph2.api.auth;

import org.springframework.web.bind.annotation.*;
import ph2.dto.LoginRequest;
import ph2.dto.LoginResponse;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @PostMapping("/api/auth/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return new LoginResponse(true);
    }   
}
