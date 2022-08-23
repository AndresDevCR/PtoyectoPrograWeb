package Proyecto.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "repuestos")
@Data
public class Repuestos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRepuesto;
    private String color;
    private String marca;
    private int price;

}
