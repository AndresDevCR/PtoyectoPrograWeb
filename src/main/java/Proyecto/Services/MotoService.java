package Proyecto.Services;

import java.util.List;

import Proyecto.Models.Moto;

public interface MotoService {
    
    public List<Moto> getAllMotos();

    public void save(Moto moto);

    public void delete(Moto moto);

    public Moto getMoto(Moto moto);

    public Moto find(Long id);
    
}
