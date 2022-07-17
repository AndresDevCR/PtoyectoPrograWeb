package Proyecto.Services;

import java.util.List;

import Proyecto.Models.AutoNuevo;


public interface AutoNuevoService {
    
    public List<AutoNuevo> getAllAutoNuevos();

    public void save(AutoNuevo autonuevo);

    public void delete(AutoNuevo autonuevo);

    public AutoNuevo getAutoNuevo(AutoNuevo autonuevo);

    public AutoNuevo find(Long id);
    
}
