/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 *
 * @author Kathy
 */
public class ObjetoPersonalizado {
    private int idObjeto, idAccion,idPaciente;
    private String ObjetoNombre;
    private byte[] imagen;

    public ObjetoPersonalizado(int idObjeto, int idAccion, int idPaciente, String ObjetoNombre, byte[] imagen) {
        this.idObjeto = idObjeto;
        this.idAccion = idAccion;
        this.idPaciente = idPaciente;
        this.ObjetoNombre = ObjetoNombre;
        this.imagen = imagen;
    }

    public int getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
    }

    public int getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(int idAccion) {
        this.idAccion = idAccion;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getObjetoNombre() {
        return ObjetoNombre;
    }

    public void setObjetoNombre(String ObjetoNombre) {
        this.ObjetoNombre = ObjetoNombre;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
    
    
}
