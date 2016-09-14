package school.raduga.example;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import school.raduga.example.controllers.HealthcheckController;
import school.raduga.example.controllers.PausableController;
import school.raduga.example.controllers.UserController;
import school.raduga.example.exceptions.EntityNotFoundExceptionMapper;
import school.raduga.example.exceptions.GeneralExceptionMapper;
import school.raduga.example.exceptions.NotFoundExceptionMapper;

/**
 * Created by etrubenok on 13/09/2016.
 */
@Configuration
public class ExampleSpringBootConfiguration extends ResourceConfig {
    public ExampleSpringBootConfiguration() {
        register(UserController.class);
        register(HealthcheckController.class);
        register(PausableController.class);

        register(GeneralExceptionMapper.class);
        register(EntityNotFoundExceptionMapper.class);
        register(NotFoundExceptionMapper.class);
    }
}


