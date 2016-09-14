package school.raduga.example.exceptions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by etrubenok on 13/09/2016.
 */

@Provider
public class EntityNotFoundExceptionMapper implements ExceptionMapper<EntityNotFoundException> {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public Response toResponse(EntityNotFoundException e) {
        log.error("EntityNotFoundException", e);
        return Response.status(Response.Status.NOT_FOUND)
                .entity(ExceptionInfo.create(e))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
