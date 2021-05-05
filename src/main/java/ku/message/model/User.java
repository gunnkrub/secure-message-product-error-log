package ku.message.model;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String email;

    private String role;

    private Instant createdAt;
}
