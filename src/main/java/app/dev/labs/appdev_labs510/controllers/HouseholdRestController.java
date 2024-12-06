package app.dev.labs.appdev_labs510.controllers;

import app.dev.labs.appdev_labs510.entities.HouseholdEntity;
import app.dev.labs.appdev_labs510.services.HouseholdService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class HouseholdRestController {
    private final HouseholdService householdService;

    @GetMapping("/households")
    public List<HouseholdEntity> getHouseholds() {
        return householdService.GetHouseholds();
    }

    @GetMapping("/households/no_pets")
    public List<HouseholdEntity> getAllHouseholdsWithNoPets() {
        return householdService.FindAllHouseholdsNoPets();
    }

    @GetMapping("/households/{id}")
    public HouseholdEntity getHouseholdById(@PathVariable String id){
        return householdService.FindHouseholdById(id);
    }


}
