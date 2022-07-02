package Proyecto.Services;

import java.util.List;

import Proyecto.Models.User;

public interface UserService {

    public List<User> getAllUsers();

    public void save(User user);

    public void delete(User user);

    public User getUser(User user);

    public User find(Long id);
}
