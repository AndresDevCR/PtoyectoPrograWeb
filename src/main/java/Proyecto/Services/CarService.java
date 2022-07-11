package Proyecto.Services;

import java.util.List;

import Proyecto.Models.Car;

public interface CarService {
    
    public List<Car> getAllCars();

    public void save(Car car);

    public void delete(Car car);

    public Car getCar(Car car);

    public Car find(Long id);
    
}
