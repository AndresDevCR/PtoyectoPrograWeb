package Proyecto.Services;

import Proyecto.Models.AutoUsado;
import Proyecto.Repositories.AutoUsadoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AutoUsadoServiceImp implements AutoUsadoService {

    @Autowired
    private AutoUsadoDao autousadoDao;

    @Override
    @Transactional(readOnly = true)
    public List<AutoUsado> getAllAutoUsados() {
        return (List<AutoUsado>) autousadoDao.findAll();
    }

    @Override
    @Transactional
    public void save(AutoUsado autousado) {
        autousadoDao.save(autousado);
    }

    @Override
    @Transactional
    public void delete(AutoUsado autousado) {
        autousadoDao.delete(autousado);
    }

    @Override
    @Transactional(readOnly = true)
    public AutoUsado getAutoUsado(AutoUsado autousado) {
        return autousadoDao.findById(autousado.getIdAuto()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public AutoUsado find(Long id) {
        return autousadoDao.findById(id).orElse(null);
    }

}

