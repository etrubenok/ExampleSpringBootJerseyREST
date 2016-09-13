package school.raduga.example;

/**
 * Created by etrubenok on 13/09/2016.
 */
public class AppException extends Exception {
    private final String entityId;

    public AppException(String entityId, String message) {
        super(message);
        this.entityId = entityId;
    }

    public ErrorObject getErrorObject() {
        return new ErrorObject(this.entityId, this.getMessage());
    }

    private class ErrorObject {
        private String entityId;
        private String message;

        public ErrorObject(String entityId, String message) {
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
}
