package app.dev.labs.appdev_labs510.services;

import app.dev.labs.appdev_labs510.entities.HouseholdEntity;
import app.dev.labs.appdev_labs510.repositories.HouseholdRepository;
import app.dev.labs.appdev_labs510.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseholdServiceImpl implements HouseholdService {
    @Autowired
    HouseholdRepository householdRepository;

    @Autowired
    PetRepository petRepository;

    @Override
    public HouseholdEntity FindHouseholdById(String id) {
        return householdRepository.findById(id).orElse(null);
    }

    @Override
    public HouseholdEntity EagerFindHouseholdById(String id) {
        HouseholdEntity householdEntity = householdRepository.findById(id).orElse(null);
        if (householdEntity != null) {
            // Trigger loading of pets
            householdEntity.getListOfPets().size();
        }
        return householdEntity;
    }

    @Override
    public List<HouseholdEntity> FindAllHouseholdsNoPets() {
        return householdRepository.findHouseholdsWithNoPets();
    }

    @Override
    public List<HouseholdEntity> GetHouseholds() {
        return householdRepository.findAll();
    }

}
