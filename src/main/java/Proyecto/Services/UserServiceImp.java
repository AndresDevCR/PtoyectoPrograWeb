package Proyecto.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Proyecto.Models.User;
import Proyecto.Repositories.UserDao;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return (List<User>) userDao.findAll();
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(User user) {
        return userDao.findById(user.getIdUser()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public User find(Long id) {
        return userDao.findById(id).orElse(null);
    }

}
