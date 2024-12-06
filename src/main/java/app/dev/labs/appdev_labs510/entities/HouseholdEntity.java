package app.dev.labs.appdev_labs510.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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

    @OneToMany(mappedBy = "household", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<PetEntity> listOfPets;
}
