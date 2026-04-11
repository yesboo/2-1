package ph2.api.auth;
import org.springframework.web.bind.annotation.*;
import ph2.dto.LoginRequest;
import ph2.dto.LoginResponse;
import ph2.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final AuthService authSrv;
    public AuthController(AuthService authService){
        this.authSrv = authService;
    }
    @PostMapping("/api/auth/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        debugDb();
        return authSrv.login(request);
    }   

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void debugDb() {
        try {
            String db = jdbcTemplate.queryForObject("SELECT current_database()", String.class);
            String user = jdbcTemplate.queryForObject("SELECT current_user", String.class);
            String ip = jdbcTemplate.queryForObject("SELECT inet_server_addr()", String.class);

            System.out.println("DB名=" + db);
            System.out.println("ユーザ=" + user);
            System.out.println("DBのIP=" + ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}

