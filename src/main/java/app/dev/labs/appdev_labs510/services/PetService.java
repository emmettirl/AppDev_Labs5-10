package app.dev.labs.appdev_labs510.services;

import app.dev.labs.appdev_labs510.entities.PetEntity;
import app.dev.labs.appdev_labs510.records.PetNameAndBreed;
import app.dev.labs.appdev_labs510.records.PetStatistics;
import app.dev.labs.appdev_labs510.repositories.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PetService {
    // 1. Create Pet
    PetEntity createPet(PetEntity pet);

    // 2. Read All Pets
    List<PetEntity> readAllPets();

    // 3. Read Pet by ID
    PetEntity readPetById(Long id);

    // 4. Update Pet Details
    PetEntity updatePetDetails(Long id, PetEntity pet);

    // 5. Delete Pet by ID
    void deletePetById(Long id);

    // 6. Delete Pets by Name
    void deletePetsByName(String name);

    // 7. Find Pets by Animal Type
    List<PetEntity> findPetsByAnimalType(String animalType);

    // 8. Find Pets by Breed
    List<PetEntity> findPetsByBreedOrderByAge(String breed);

    // 9. Get name and breed only
    List<PetNameAndBreed> getNameAndBreedOnly();

    // 10. Get Pet Statistics (Average Age, Oldest Age)
    PetStatistics getPetStatistics();
}