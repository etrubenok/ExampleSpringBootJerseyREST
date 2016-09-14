package school.raduga.example.exceptions;


import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by etrubenok on 14/09/2016.
 */
@XmlRootElement
public class EntityNotFoundException extends Exception {
    public final String entityId;

    public EntityNotFoundException(String entityId, String message) {
        super(message);
        this.entityId = entityId;
    }

    public String getEntityId() {
        return entityId;
    }
}

