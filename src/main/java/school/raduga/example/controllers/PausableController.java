package school.raduga.example.controllers;

import org.glassfish.jersey.server.ManagedAsync;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.TimeUnit;

/**
 * Created by etrubenok on 14/09/2016.
 */

@Component
@Path("/pause")
public class PausableController {
    @GET
    @ManagedAsync
    @Produces(MediaType.APPLICATION_JSON)
    public void getPaused(@Suspended final AsyncResponse asyncResponse) {
        try {
            TimeUnit.SECONDS.sleep(2);
            asyncResponse.resume(new PausedResponse());
        } catch (InterruptedException e) {
            asyncResponse.resume(e);
        }
    }

    private class PausedResponse {
        public String getMessage() {
            return "Slept for 2 seconds";
        }
    }
}
