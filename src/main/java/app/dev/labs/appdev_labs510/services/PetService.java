package app.dev.labs.appdev_labs510.services;

import app.dev.labs.appdev_labs510.entities.HouseholdEntity;
import app.dev.labs.appdev_labs510.entities.PetEntity;
import app.dev.labs.appdev_labs510.records.PetNameAndBreed;
import app.dev.labs.appdev_labs510.records.PetStatistics;
import app.dev.labs.appdev_labs510.repositories.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PetService {
    PetEntity createPet(PetEntity pet);

    List<PetEntity> readAllPets();

    PetEntity readPetById(Long id);

    PetEntity updatePetDetails(Long id, PetEntity pet);

    void deletePetById(Long id);

    void deletePetsByName(String name);

    List<PetEntity> findPetsByAnimalType(String animalType);

    List<PetEntity> findPetsByBreedOrderByAge(String breed);

    List<PetNameAndBreed> getNameAndBreedOnly();

    PetStatistics getPetStatistics();

    List<PetEntity> GetPets();
}