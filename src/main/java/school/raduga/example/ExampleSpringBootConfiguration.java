package school.raduga.example;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import school.raduga.example.controllers.HealthcheckController;
import school.raduga.example.controllers.UserController;

/**
 * Created by etrubenok on 13/09/2016.
 */
@Configuration
public class ExampleSpringBootConfiguration extends ResourceConfig {
    public ExampleSpringBootConfiguration() {
        register(UserController.class);
        register(AppExceptionMapper.class);
        register(HealthcheckController.class);
    }
}


