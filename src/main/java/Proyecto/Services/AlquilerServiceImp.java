package Proyecto.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Proyecto.Models.Alquiler;
import Proyecto.Repositories.AlquilerDao;

@Service
public class AlquilerServiceImp implements AlquilerService {

    @Autowired
    private AlquilerDao alquilerDao;

    @Override
    @Transactional(readOnly = true)
    public List<Alquiler> getAllAlquileres() {
        return (List<Alquiler>) alquilerDao.findAll();
    }

    @Override
    @Transactional
    public void save(Alquiler alquiler) {
        alquilerDao.save(alquiler);
    }

    @Override
    @Transactional
    public void delete(Alquiler alquiler) {
        alquilerDao.delete(alquiler);
    }

    @Override
    @Transactional(readOnly = true)
    public Alquiler getAlquiler(Alquiler alquiler) {
        return alquilerDao.findById(alquiler.getIdAlquiler()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Alquiler find(Long id) {
        return alquilerDao.findById(id).orElse(null);
    }
}