package Proyecto.Repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import Proyecto.Models.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

    
}
