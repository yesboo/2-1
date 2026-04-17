package ph2.service;
import org.springframework.stereotype.Service;
import ph2.dto.LoginRequest;
import ph2.dto.LoginResponse;
import ph2.entity.User;
import ph2.repository.UserRepository;
import java.security.MessageDigest;

@Service
public class AuthService {
    private final UserRepository userRepo;

    public AuthService(UserRepository userRepo){
        this.userRepo = userRepo;
    }
    public LoginResponse login(LoginRequest request){
        User user = userRepo.findByAcname(request.getUsername()).orElse(null);
        if(user == null) {
            return new LoginResponse(false,null,null);      }
        String hashedInput = sha256(request.getPassword());
        if (!user.getPassword().equals(hashedInput)) {
            return new LoginResponse(false,null,null);
        }
        return new LoginResponse(true, user.getAcname(), user.getName());
    }
    
    private String sha256(String input){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(input.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch ( Exception e) {
            throw new RuntimeException("SHA-256 error", e);
        }
    }
}
