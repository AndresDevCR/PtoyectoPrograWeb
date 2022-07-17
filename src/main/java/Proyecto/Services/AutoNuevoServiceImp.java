package Proyecto.Services;

import Proyecto.Models.AutoNuevo;
import Proyecto.Repositories.AutoNuevoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AutoNuevoServiceImp implements AutoNuevoService {

    @Autowired
    private AutoNuevoDao autonuevoDao;

    @Override
    @Transactional(readOnly = true)
    public List<AutoNuevo> getAllAutoNuevos() {
        return (List<AutoNuevo>) autonuevoDao.findAll();
    }

    @Override
    @Transactional
    public void save(AutoNuevo autonuevo) {
        autonuevoDao.save(autonuevo);
    }

    @Override
    @Transactional
    public void delete(AutoNuevo autonuevo) {
        autonuevoDao.delete(autonuevo);
    }

    @Override
    @Transactional(readOnly = true)
    public AutoNuevo getAutoNuevo(AutoNuevo autonuevo) {
        return autonuevoDao.findById(autonuevo.getIdAuto()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public AutoNuevo find(Long id) {
        return autonuevoDao.findById(id).orElse(null);
    }

}

