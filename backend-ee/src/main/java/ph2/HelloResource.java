package ph2;
import javax.annotation.processing.Generated;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello(){
        return "{\"message\" : \"hello from widfly + Jakarta EE\"}";
    }
}
