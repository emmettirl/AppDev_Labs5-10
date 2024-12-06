package app.dev.labs.appdev_labs510.controllers;

import app.dev.labs.appdev_labs510.entities.HouseholdEntity;
import app.dev.labs.appdev_labs510.entities.PetEntity;
import app.dev.labs.appdev_labs510.services.HouseholdService;
import app.dev.labs.appdev_labs510.services.PetService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class GraphQLAPI {
    private HouseholdService householdService;
    private PetService petService;

    @QueryMapping
    public List<HouseholdEntity> getHouseholds() {
        return householdService.GetHouseholds();
    }

    @QueryMapping
    public List<PetEntity> getPets() {
        return petService.GetPets();
    }

    @QueryMapping
    public List<HouseholdEntity> getAllHouseholdsWithNoPets() {
        return householdService.FindAllHouseholdsNoPets();
    }

    @QueryMapping
    public HouseholdEntity getHouseholdById(String id){
        return householdService.FindHouseholdById(id);
    }

    @QueryMapping
    public PetEntity getPetById(Long id){
        return petService.getPetById(id);
    }


    @MutationMapping
    public HouseholdEntity createHousehold(
            @Argument String eircode,
            @Argument int numberOfOccupants,
            @Argument int maxNumberOfOccupants,
            @Argument int OwnerOccupied
    ){
        HouseholdEntity household = new HouseholdEntity();
        household.setEircode(eircode);
        household.setNumberOfOccupants(numberOfOccupants);
        household.setMaxNumberOfOccupants(maxNumberOfOccupants);
        household.setOwnerOccupied(OwnerOccupied);
        return householdService.createHousehold(household);
    }

    @MutationMapping
    public boolean deletePetById(@Argument("id") int id) {
        petService.deletePetById((long) id);
        return true;
    }

}
