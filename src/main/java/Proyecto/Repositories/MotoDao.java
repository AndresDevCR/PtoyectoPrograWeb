package Proyecto.Repositories;

import org.springframework.data.repository.CrudRepository;

import Proyecto.Models.Moto;

public interface MotoDao extends CrudRepository<Moto, Long> {
    
}
