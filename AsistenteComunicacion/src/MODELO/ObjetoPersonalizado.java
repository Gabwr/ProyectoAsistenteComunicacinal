
package MODELO;

public class ObjetoPersonalizado {

    private int idObjetoPerso, idAccion, idPersona;
    private String ObjetoPersoNombre;
    private byte[] imagen;
    
    public ObjetoPersonalizado(){
        
    }

    public ObjetoPersonalizado(int idObjetoPerso, int idAccion, int idPersona, String ObjetoPersoNombre, byte[] imagen) {
        this.idObjetoPerso = idObjetoPerso;
        this.idAccion = idAccion;
        this.idPersona = idPersona;
        this.ObjetoPersoNombre = ObjetoPersoNombre;
        this.imagen = imagen;
    }
    
    public int getIdObjetoPerso() {
        return idObjetoPerso;
    }

    public void setIdObjetoPerso(int idObjetoPerso) {
        this.idObjetoPerso = idObjetoPerso;
    }

    public int getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(int idAccion) {
        this.idAccion = idAccion;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getObjetoPersoNombre() {
        return ObjetoPersoNombre;
    }

    public void setObjetoPersoNombre(String ObjetoPersoNombre) {
        this.ObjetoPersoNombre = ObjetoPersoNombre;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    /* public int getIdObjeto() {
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
    
     */

    
}
