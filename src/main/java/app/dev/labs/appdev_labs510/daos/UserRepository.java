package app.dev.labs.appdev_labs510.daos;

import app.dev.labs.appdev_labs510.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
