package app.dev.labs.appdev_labs510.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data@AllArgsConstructor
@NoArgsConstructor

public class UserEntity {
    @Id
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String role;
    private boolean enabled = true;
    private boolean accountNonExpired = true;
    private boolean credentialsNonExpired = true;
    private boolean accountNonLocked = true;
}
