package app.dev.labs.appdev_labs510.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "households")
@Data
public class HouseholdEntity {
    @Id
    private String eircode;
    private int numberOfOccupants;
    private int maxNumberOfOccupants;
    private int OwnerOccupied;

    @OneToMany(mappedBy = "household")
    private List<PetEntity> listOfPets;
}
