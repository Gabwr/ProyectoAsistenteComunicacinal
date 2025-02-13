package MODELO;

public class Persona {
    private int idPersona, IdPerfil;
    private String usuario, contrasenia, nombre;

    public Persona() {
    }
    
   //Persona Tutor, Admin, Paciente
    public Persona(int idPersona, int IdPerfil, String usuario, String contrasenia, String nombre) {
        this.idPersona = idPersona;
        this.IdPerfil = IdPerfil;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
    }

    //Para recuperar Lista de personas
    public Persona( int IdPerfil, String usuario,String nombre) {
        this.IdPerfil = IdPerfil;
        this.usuario = usuario;
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public int getIdPerfil() {
        return IdPerfil;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public void setIdPerfil(int IdPerfil) {
        this.IdPerfil = IdPerfil;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return usuario+IdPerfil;
    }
}
