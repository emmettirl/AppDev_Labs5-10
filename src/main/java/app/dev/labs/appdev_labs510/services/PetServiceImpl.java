package app.dev.labs.appdev_labs510.services;

import app.dev.labs.appdev_labs510.entities.HouseholdEntity;
import app.dev.labs.appdev_labs510.entities.PetEntity;
import app.dev.labs.appdev_labs510.exceptions.BadDataException;
import app.dev.labs.appdev_labs510.exceptions.RecordNotFoundException;
import app.dev.labs.appdev_labs510.records.PetNameAndBreed;
import app.dev.labs.appdev_labs510.records.PetStatistics;
import app.dev.labs.appdev_labs510.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
    private PetRepository petRepository;
    // use named queries


    @Override
    public PetEntity createPet(PetEntity pet) {
        if (pet.getName() == null || pet.getAnimalType() == null) {
            throw new BadDataException("Pet name and animal type cannot be null");
        }
        return petRepository.save(pet);
    }

    @Override
    public List<PetEntity> readAllPets() {
        return petRepository.findAll();
    }

    @Override
    public PetEntity readPetById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public PetEntity updatePetDetails(Long id, PetEntity pet) {
        petRepository.findById(id).ifPresent(p -> {
            p.setName(pet.getName());
            p.setAnimalType(pet.getAnimalType());
            p.setBreed(pet.getBreed());
            p.setAge(pet.getAge());
            petRepository.save(p);
        });
        return pet;
    }

    @Override
    public void deletePetById(Long id) {
        if (!petRepository.existsById(id)) {
            throw new RecordNotFoundException("Pet not found with id: " + id);
        }
        petRepository.deleteById(id);
    }

    @Override
    public void deletePetsByName(String name) {
        PetEntity pet = (PetEntity) petRepository.findByName(name);
        if (pet == null) {
            throw new RecordNotFoundException("Pet not found with name: " + name);
        }
        petRepository.deleteByName(name);
    }

    @Override
    public List<PetEntity> findPetsByAnimalType(String animalType) {
        return petRepository.findByAnimalType(animalType);
    }

    @Override
    public List<PetEntity> findPetsByBreedOrderByAge(String breed) {
        return petRepository.findByBreedOrderByAge(breed);
    }

    @Override
    public List<PetNameAndBreed> getNameAndBreedOnly() {
        return null;
    }

    @Override
    public PetStatistics getPetStatistics() {
        List<PetEntity> pets = petRepository.findAll();
        int totalAge = pets.stream().mapToInt(PetEntity::getAge).sum();
        int averageAge = totalAge / pets.size();
        int oldestAge = pets.stream().mapToInt(PetEntity::getAge).max().orElse(0);
        return new PetStatistics(averageAge, oldestAge);
    }

    @Override
    public List<PetEntity> GetPets() {
        return petRepository.findAll();
    }

}