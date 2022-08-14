package Proyecto.Models;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "alquileres")
@Data
public class Alquiler implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlquiler;
    private String brand;
    private String model;
    private int year;
    private String color;
    private int price;
    private int km;
    private String description;
    private String image;

}