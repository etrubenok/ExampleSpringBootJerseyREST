package school.raduga.example.models;

import java.util.UUID;

/**
 * Created by etrubenok on 8/09/2016.
 */

public class User {
    String id;
    String name;

    public static User create(String id, String name) {
        return new User(id, name);
    }

    public static User create(String name) {
        return new User(UUID.randomUUID().toString(), name);
    }

    private User() {
    }

    private User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
