package app.dev.labs.appdev_labs510;

import app.dev.labs.appdev_labs510.entities.HouseholdEntity;
import app.dev.labs.appdev_labs510.repositories.HouseholdRepository;
import app.dev.labs.appdev_labs510.services.HouseholdServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class HouseholdServiceImplTests {
    @Mock
    HouseholdRepository householdRepository;
    @InjectMocks
    HouseholdServiceImpl householdService = new HouseholdServiceImpl();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindHouseholdById() {
        HouseholdEntity household = new HouseholdEntity();
        household.setEircode("D02XY45");
        when(householdRepository.findById("D02XY45")).thenReturn(Optional.of(household));

        HouseholdEntity result = householdService.FindHouseholdById("D02XY45");
        assertNotNull(result);
        assertEquals("D02XY45", result.getEircode());
    }

    @Test
    public void testEagerFindHouseholdById() {
        HouseholdEntity household = new HouseholdEntity();
        household.setEircode("D02XY45");
        household.setListOfPets(Collections.emptyList());
        when(householdRepository.findById("D02XY45")).thenReturn(Optional.of(household));

        HouseholdEntity result = householdService.EagerFindHouseholdById("D02XY45");
        assertNotNull(result);
        assertEquals("D02XY45", result.getEircode());
        assertNotNull(result.getListOfPets());
    }

    @Test
    public void testFindAllHouseholdsNoPets() {
        HouseholdEntity household = new HouseholdEntity();
        household.setEircode("D02XY45");
        household.setListOfPets(Collections.emptyList());
        when(householdRepository.findHouseholdsWithNoPets()).thenReturn(List.of(household));

        List<HouseholdEntity> result = householdService.FindAllHouseholdsNoPets();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("D02XY45", result.get(0).getEircode());
    }

}
