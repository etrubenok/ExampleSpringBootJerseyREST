package school.raduga.example.controllers;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by etrubenok on 9/09/2016.
 */
@Component
@Path("/healthcheck")
public class HealthcheckController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public HealthcheckModel healthcheck() {
        return new HealthcheckModel();
    }

    private class HealthcheckModel {
        public Boolean getHealhcheck() { return true; }
        public Long getUptime() { return 1234567890L; }
    }
}
