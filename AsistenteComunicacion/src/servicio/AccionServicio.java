/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.util.List;
import DAO.AccionMetodos;
import MODELO.Accion;

public class AccionServicio {
    public static boolean CargarAccion(Accion accion){
         return new AccionMetodos().CargarAccion(accion);
     }
     public static boolean guardarImagenEnMongo(int idAccion, String rutaImagen){
         return new AccionMetodos().guardarImagenEnMongo(idAccion,rutaImagen);
     }
}
