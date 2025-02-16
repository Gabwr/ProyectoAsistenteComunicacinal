/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import MODELO.Accion;
import java.util.List;

public interface IAccion {
 public boolean CargarAccion(Accion accion);
 public boolean guardarImagenEnMongo(int idAccion, String rutaImagen);
}
