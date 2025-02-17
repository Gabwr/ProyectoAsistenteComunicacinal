/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import java.util.List;
import DAO.ObjetosMetodos;
import DAO.ObjetosMetodos;
import MODELO.Objeto;

public class ObjetoServicio {
    public static  List<Objeto> CargarObjeto(){
         return new ObjetosMetodos().CargarObjeto();
     }
     public static boolean guardarImagenEnMongo(int idAccion, int idObjeto ,String rutaImagen){
         return new ObjetosMetodos().guardarImagenEnMongo(idAccion,idObjeto,rutaImagen);
     }
  
    public static List<Objeto> CargarObjetosPorAccion(int _idAccion) {
        return new ObjetosMetodos().CargarObjetosPorAccion(_idAccion);
    }
}
