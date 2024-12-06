package app.dev.labs.appdev_labs510.controllers;

import app.dev.labs.appdev_labs510.entities.PetEntity;
import app.dev.labs.appdev_labs510.services.HouseholdService;
import app.dev.labs.appdev_labs510.services.PetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PetRestController {
    private final PetService petService;
    private final HouseholdService householdService;

    @GetMapping("/pets")
    public List<PetEntity> getPets() {
        return petService.GetPets();
    }

    @GetMapping("/pets/{id}")
    public PetEntity getPetById(@PathVariable Long id){
        return petService.readPetById(id);
    }

    @DeleteMapping("/pets/delete/{id}")
    public void deletePetById(@PathVariable Long id) {
        petService.deletePetById(id);
    }

    @GetMapping("/pets/create")
    public PetEntity createPet(
            @RequestParam String name,
            @RequestParam String animalType,
            @RequestParam String breed,
            @RequestParam Integer age,
            @RequestParam String household
    ){
        if (household == null || household.isEmpty()) {
            throw new IllegalArgumentException("Household cannot be null or empty");
        }

        PetEntity pet = new PetEntity();
        pet.setName(name);
        pet.setAnimalType(animalType);
        pet.setBreed(breed);
        pet.setAge(age);
        pet.setHousehold(householdService.FindHouseholdById(household));
        return petService.createPet(pet);
    }

    @GetMapping("/pets/update/{id}")
    public PetEntity updatePet(
            @PathVariable Long id,
            @RequestParam (required = false) String name,
            @RequestParam (required = false) String animalType,
            @RequestParam (required = false) String breed,
            @RequestParam (required = false) Integer age,
            @RequestParam (required = false) String household
    ){
        PetEntity originalPet = petService.readPetById(id);
        PetEntity newPet = new PetEntity();

        newPet.setName(name == null ? originalPet.getName() : name);
        newPet.setAnimalType(animalType == null ? originalPet.getAnimalType() : animalType);
        newPet.setBreed(breed == null ? originalPet.getBreed() : breed);
        newPet.setAge(age == null ? originalPet.getAge() : age);
        newPet.setHousehold(household == null ? originalPet.getHousehold() : householdService.FindHouseholdById(household));

        return petService.updatePetDetails(id, newPet);
    }

}
