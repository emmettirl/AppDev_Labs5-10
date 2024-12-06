package app.dev.labs.appdev_labs510.repositories;

import app.dev.labs.appdev_labs510.entities.HouseholdEntity;
import app.dev.labs.appdev_labs510.entities.PetEntity;
import app.dev.labs.appdev_labs510.records.PetNameAndBreed;
import app.dev.labs.appdev_labs510.records.PetStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Long> {

    void deleteByName(String name);

    List<PetEntity> findByAnimalType(String animalType);

    List<PetEntity> findByBreedOrderByAge(String breed);

    Object findByName(String buddy);

    // Create method with this signature using @Query List<PetEntity> findByHousehold(HouseholdEntity householdEntity);
    @Query("SELECT p FROM PetEntity p WHERE p.household = ?1")
    List<PetEntity> findByHousehold(HouseholdEntity householdEntity);



}
