package app.dev.labs.appdev_labs510.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pets")
@Data
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String animalType;
    private String breed;
    private int age;
}
