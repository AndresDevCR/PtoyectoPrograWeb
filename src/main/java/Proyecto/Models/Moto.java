package Proyecto.Models;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "motocicletas")
@Data
public class Moto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMoto;
    private String brand;
    private String model;
    private int year;
    private String color;
    private int price;
    private int km;
    private String description;
    private String image;

    public Moto() {
    }

    public Moto(String brand, String model, int year, String color, int price, int km, String description, String image) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.km = km;
        this.description = description;
        this.image = image;
    }

}