package MODELO;

public class Perfil {
    private int id;
    private String nombrePerfil;

    public Perfil(int id, String nombrePerfil) {
        this.id = id;
        this.nombrePerfil = nombrePerfil;
    }

    public Perfil() {
    }

    public int getId() {
        return id;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }
    
    
}
