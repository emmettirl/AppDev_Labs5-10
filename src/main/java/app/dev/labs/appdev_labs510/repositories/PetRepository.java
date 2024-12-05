package app.dev.labs.appdev_labs510.repositories;

import app.dev.labs.appdev_labs510.entities.PetEntity;
import app.dev.labs.appdev_labs510.records.PetNameAndBreed;
import app.dev.labs.appdev_labs510.records.PetStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Long> {

    void deleteByName(String name);

    List<PetEntity> findByAnimalType(String animalType);

    List<PetEntity> findByBreedOrderByAge(String breed);

    List<PetNameAndBreed> getNameAndBreedOnly();

    void deleteByNameIgnoreCase(String buddy);

    Object getPetStatistics();

    Object findByName(String buddy);
}
