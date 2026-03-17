package ph2.service;
import org.springframework.stereotype.Service;
import ph2.dto.LoginRequest;
import ph2.dto.LoginResponse;
import ph2.entity.User;
import ph2.repository.UserRepository;

@Service
public class AuthService {
    private final UserRepository userRepo;

    public AuthService(UserRepository userRepo){
        this.userRepo = userRepo;
    }
    public LoginResponse login(LoginRequest request){
        User user = userRepo.findByAcname(request.getUsername()).orElse(null);
        if(user == null) {
            return new LoginResponse(false);
        }
        return new LoginResponse(true);
    }
}
