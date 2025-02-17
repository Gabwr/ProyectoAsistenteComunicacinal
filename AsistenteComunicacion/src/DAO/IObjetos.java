/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

/**
 *
 * @author DELL
 */
import MODELO.Objeto;
import java.util.List;

public interface IObjetos {
 public List <Objeto> CargarObjeto();
 public boolean guardarImagenEnMongo(int idAccion, int idObjeto, String rutaImagen);
}
