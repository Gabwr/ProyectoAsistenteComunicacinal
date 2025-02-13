
package MODELO;


public class Objeto {
    private int idObjeto;
    private String ObjetoNombre;
    private byte[] imagen;

    public Objeto() {
    }

    public Objeto(int idObjeto, String ObjetoNombre, byte[] imagen) {
        this.idObjeto = idObjeto;
        this.ObjetoNombre = ObjetoNombre;
        this.imagen = imagen;
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
