package app.dev.labs.appdev_labs510.repositories;

import app.dev.labs.appdev_labs510.entities.HouseholdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseholdRepository extends JpaRepository<HouseholdEntity, String> {
    @Query("SELECT h FROM HouseholdEntity h WHERE h.listOfPets IS EMPTY")
    List<HouseholdEntity> findHouseholdsWithNoPets();
}
