package app.dev.labs.appdev_labs510;

import app.dev.labs.appdev_labs510.entities.PetEntity;
import app.dev.labs.appdev_labs510.exceptions.RecordNotFoundException;
import app.dev.labs.appdev_labs510.repositories.PetRepository;
import app.dev.labs.appdev_labs510.services.PetServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PetServiceImplTest {

    @Mock
    private PetRepository petRepository;

    @InjectMocks
    private PetServiceImpl petService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatePet() {
        PetEntity pet = new PetEntity();
        pet.setName("Buddy");
        pet.setAnimalType("Dog");
        pet.setBreed("Golden Retriever");
        pet.setAge(5);

        when(petRepository.save(pet)).thenReturn(pet);


        try {
            PetEntity savedPet = petService.createPet(pet);

            assertNotNull(savedPet);
            assertEquals("Buddy", savedPet.getName());
            assertEquals("Dog", savedPet.getAnimalType());
            assertEquals("Golden Retriever", savedPet.getBreed());
            assertEquals(5, savedPet.getAge());

            verify(petRepository, times(1)).save(pet);

        } catch (Exception e) {
            fail("Exception thrown", e);
        }

    }

    @Test
    void testGetAllPets() {
        PetEntity pet1 = new PetEntity();
        pet1.setName("Buddy");
        pet1.setAnimalType("Dog");
        pet1.setBreed("Golden Retriever");
        pet1.setAge(5);

        PetEntity pet2 = new PetEntity();
        pet2.setName("Kitty");
        pet2.setAnimalType("Cat");
        pet2.setBreed("Siamese");
        pet2.setAge(3);

        when(petRepository.findAll()).thenReturn(Arrays.asList(pet1, pet2));

        List<PetEntity> pets = petService.getAllPets();

        assertNotNull(pets);
        assertEquals(2, pets.size());

        verify(petRepository, times(1)).findAll();

    }

    @Test
    void testGetPetById() {
        PetEntity pet = new PetEntity();
        pet.setId(1L);
        pet.setName("Buddy");
        pet.setAnimalType("Dog");
        pet.setBreed("Golden Retriever");
        pet.setAge(5);

        when(petRepository.findById(1L)).thenReturn(Optional.of(pet));

        PetEntity foundPet = petService.getPetById(1L);

        assertNotNull(foundPet);
        assertEquals(1L, foundPet.getId());
        assertEquals("Buddy", foundPet.getName());
        assertEquals("Dog", foundPet.getAnimalType());
        assertEquals("Golden Retriever", foundPet.getBreed());
        assertEquals(5, foundPet.getAge());

        verify(petRepository, times(1)).findById(1L);
    }


    @Test
    void testDeletePetById() {
        PetEntity pet = new PetEntity();
        pet.setId(1L);
        pet.setName("Buddy");
        pet.setAnimalType("Dog");
        pet.setBreed("Golden Retriever");
        pet.setAge(5);

        when(petRepository.findById(1L)).thenReturn(Optional.of(pet));

        try {
            petService.deletePetById(1L);
        } catch (RecordNotFoundException e) {
            assertEquals("Pet not found with id: 1", e.getMessage());
        }
    }
}