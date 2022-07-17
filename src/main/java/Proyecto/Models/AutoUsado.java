package Proyecto.Models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "usados")
@Data
public class AutoUsado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAuto;
    private String brand;
    private String model;
    private int year;
    private String color;
    private int price;
    private int km;
    private String description;
    private String image;

    public AutoUsado() {
    }

    public AutoUsado(String brand, String model, int year, String color, int price, int km, String description,
            String image) {
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
