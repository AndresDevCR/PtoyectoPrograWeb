package Proyecto.Services;

import Proyecto.Models.Moto;
import Proyecto.Repositories.MotoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MotoServiceImp implements MotoService {

    @Autowired
    private MotoDao motoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Moto> getAllMotos() {
        return (List<Moto>) motoDao.findAll();
    }

    @Override
    @Transactional
    public void save(Moto moto) {
        motoDao.save(moto);
    }

    @Override
    @Transactional
    public void delete(Moto moto) {
        motoDao.delete(moto);
    }

    @Override
    @Transactional(readOnly = true)
    public Moto getMoto(Moto moto) {
        return motoDao.findById(moto.getIdMoto()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Moto find(Long id) {
        return motoDao.findById(id).orElse(null);
    }

}

