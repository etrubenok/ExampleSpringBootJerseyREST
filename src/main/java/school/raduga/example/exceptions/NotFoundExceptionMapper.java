package school.raduga.example.exceptions;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by etrubenok on 14/09/2016.
 */
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {
    @Override
    public Response toResponse(NotFoundException e) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(ExceptionInfo.create(e))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
