package MODELO;

public class Persona {
    private int idPersona, IdPerfil;
    private String usuario, contrasenia, nombre, estado;
    private byte[] img;
    public Persona() {
    }
    
   //Persona Tutor, Admin, Paciente
    public Persona(int idPersona, int IdPerfil, String usuario, String contrasenia, String nombre,byte[]img, String estado) {
        this.idPersona = idPersona;
        this.IdPerfil = IdPerfil;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.img =img;
        this.estado = estado;
    }

    //Para recuperar Lista de personas
    public Persona(int idPersona,int IdPerfil, String usuario,String nombre,byte[]img , String estado) {
        this.idPersona =idPersona;
        this.IdPerfil = IdPerfil;
        this.usuario = usuario;
        this.nombre = nombre;
        this.img=img;
        this.estado = estado;
    }

    public Persona(int idPersona, int IdPerfil, String usuario, String nombre, String estado) {
        this.idPersona = idPersona;
        this.IdPerfil = IdPerfil;
        this.usuario = usuario;
        this.nombre = nombre;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
    
    
    
    @Override
    public String toString(){
        return usuario+" "+idPersona;
    }
}
