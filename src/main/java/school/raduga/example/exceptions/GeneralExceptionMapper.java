package school.raduga.example.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by etrubenok on 14/09/2016.
 */
public class GeneralExceptionMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(ExceptionInfo.create(e))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
