package app.dev.labs.appdev_labs510.services;

import app.dev.labs.appdev_labs510.entities.HouseholdEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HouseholdService {
    HouseholdEntity FindHouseholdById(String id);
    HouseholdEntity EagerFindHouseholdById(String id);
    List<HouseholdEntity> FindAllHouseholdsNoPets();

    List<HouseholdEntity> GetHouseholds();

    HouseholdEntity createHousehold(HouseholdEntity household);
}
