package Proyecto.Services;

import java.util.List;

import Proyecto.Models.AutoUsado;


public interface AutoUsadoService {
    
    public List<AutoUsado> getAllAutoUsados();

    public void save(AutoUsado autousado);

    public void delete(AutoUsado autousado);

    public AutoUsado getAutoUsado(AutoUsado autousado);

    public AutoUsado find(Long id);
    
}
