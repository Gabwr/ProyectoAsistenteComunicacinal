
package MODELO;


public class Objeto {
    private int idObjeto, idAccion;  
    private String ObjetoNombre;
    private byte[] imagen;

    public Objeto() {
    }

    public Objeto(int idObjeto, int idAccion, String ObjetoNombre, byte[] imagen) {
        this.idAccion=idAccion;
        this.idObjeto = idObjeto;
        this.ObjetoNombre = ObjetoNombre;
        this.imagen = imagen;
    }
public int getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(int idAccion) {
        this.idAccion = idAccion;
    }
    public int getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
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
