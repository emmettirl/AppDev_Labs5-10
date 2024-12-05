package app.dev.labs.appdev_labs510.controllers;

import app.dev.labs.appdev_labs510.entities.HouseholdEntity;
import app.dev.labs.appdev_labs510.services.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// http://localhost:8080/households/no-pets
// will call AOP logging and return a list of households with no pets

@RestController
@RequestMapping("/households")
public class HouseholdController {

    @Autowired
    private HouseholdService householdService;

    @GetMapping("/no-pets")
    public List<HouseholdEntity> getHouseholdsWithNoPets() {
        return householdService.FindAllHouseholdsNoPets();
    }
}