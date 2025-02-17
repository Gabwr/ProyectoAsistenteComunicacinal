package DAO;

import MODELO.ObjetoPersonalizado;
import java.util.List;

public interface IObjetosPerso {
    public List <ObjetoPersonalizado> CargarObjetoPerso();
    public boolean guardarImagenPersoEnMongo(int idPersona, int idAccion, int idObjetoPerso, String rutaImagen);
    public List<ObjetoPersonalizado> CargarPersoPorAccion(int idPersona,int idAccion);
}
