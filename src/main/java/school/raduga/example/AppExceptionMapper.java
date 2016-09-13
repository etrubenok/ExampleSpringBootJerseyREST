package school.raduga.example;


import org.springframework.dao.EmptyResultDataAccessException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by etrubenok on 13/09/2016.
 */

@Provider
public class AppExceptionMapper implements ExceptionMapper<AppException> {
    @Override
    public Response toResponse(AppException e) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(e.getErrorObject())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
