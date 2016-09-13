package school.raduga.example.controllers;

import org.glassfish.jersey.server.ManagedAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import school.raduga.example.AppException;
import school.raduga.example.models.User;

import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

/**
 * Created by etrubenok on 9/09/2016.
 */

@Component
@Path("/user")
public class UserController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GET
    @ManagedAsync
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void get(@PathParam("id") String id,
                    @Suspended final AsyncResponse asyncResponse)
            throws InterruptedException {
        try {
            User user = jdbcTemplate.queryForObject(
                    "select * from users where id = ?",
                    (rs, rowNum) -> User.create(rs.getString("id"), rs.getString("name")),
                    id);
            asyncResponse.resume(user);
        } catch (EmptyResultDataAccessException e) {
            asyncResponse.resume(new AppException(id, "User is not found"));
        }
    }

    @POST
    @ManagedAsync
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void create(User user,
                       @Suspended final AsyncResponse asyncResponse) {
        try {
            User userWithId = User.create(user.getName());
            jdbcTemplate.update("insert into users(id, name) values (?, ?)", userWithId.getId(), userWithId.getName());
            asyncResponse.resume(userWithId);
        } catch (Exception e) {
            asyncResponse.resume(e);
        }
    }
}
