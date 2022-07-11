package Proyecto.Repositories;

import org.springframework.data.repository.CrudRepository;

import Proyecto.Models.Car;

public interface CarDao extends CrudRepository<Car, Long> {
    
}
