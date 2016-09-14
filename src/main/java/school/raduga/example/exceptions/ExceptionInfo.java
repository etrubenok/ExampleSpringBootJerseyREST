package school.raduga.example.exceptions;

import javax.ws.rs.NotFoundException;

/**
 * Created by etrubenok on 14/09/2016.
 */
public class ExceptionInfo {
    private final String entityId;
    private final String message;

    static public ExceptionInfo create(Exception e) {
        return new ExceptionInfo("undefined", "Internal server exception");
    }

    static public ExceptionInfo create(EntityNotFoundException e) {
        return new ExceptionInfo(e.getEntityId(), e.getMessage());
    }

    static public ExceptionInfo create(NotFoundException e) {
        return new ExceptionInfo("undefined", "path is not found");
    }

    static public ExceptionInfo create(String entityId, String message) {
        return new ExceptionInfo(entityId, message);
    }

    static public ExceptionInfo create(String message) {
        return new ExceptionInfo("undefined", message);
    }

    private ExceptionInfo(String entityId, String message) {
        this.entityId = entityId;
        this.message = message;
    }

    public String getEntityId() {
        return entityId;
    }

    public String getMessage() {
        return message;
    }
}
