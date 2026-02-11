package ph2.api;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class HelloController {

    @PostMapping("/api/hello")
    public Map<String, String> hello(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        return Map.of(
            "message", "Hello " + username
        );
    }
}

