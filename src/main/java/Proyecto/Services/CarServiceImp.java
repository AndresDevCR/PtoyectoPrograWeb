package Proyecto.Services;

import Proyecto.Models.Car;
import Proyecto.Repositories.CarDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CarServiceImp implements CarService {

    @Autowired
    private CarDao carDao;

    @Override
    @Transactional(readOnly = true)
    public List<Car> getAllCars() {
        return (List<Car>) carDao.findAll();
    }

    @Override
    @Transactional
    public void save(Car car) {
        carDao.save(car);
    }

    @Override
    @Transactional
    public void delete(Car car) {
        carDao.delete(car);
    }

    @Override
    @Transactional(readOnly = true)
    public Car getCar(Car car) {
        return carDao.findById(car.getIdCar()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Car find(Long id) {
        return carDao.findById(id).orElse(null);
    }

}

