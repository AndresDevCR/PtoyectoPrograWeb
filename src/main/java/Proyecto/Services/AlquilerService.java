package Proyecto.Services;

import java.util.List;
import Proyecto.Models.Alquiler;

public interface AlquilerService {
    
    public List<Alquiler> getAllAlquileres();

    public void save(Alquiler alquiler);

    public void delete(Alquiler alquiler);

    public Alquiler getAlquiler(Alquiler alquiler);

    public Alquiler find(Long id);

}