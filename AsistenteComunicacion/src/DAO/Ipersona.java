
package DAO;

import MODELO.Perfil;
import MODELO.Persona;
import java.util.List;

public interface Ipersona {
  
   public boolean asignartutor(int idpac, int idtut);
   
   public boolean actualizartutor(int idpac, int idtut);
   
   public Persona getTutor(int pac);
   
   public List<Persona> ListaPersona();
   
   public String userExiste(String usuario);
   
   public List<Persona> ListaPacientes(Persona tutor);
           
   public boolean InsertarPersona(Persona persona);
   
   public boolean ActualizarPersona(Persona persona);
   
   public boolean ActivarPersona(Persona persona);
   
   public boolean DesactivarPersona(Persona persona);
           
   public String encriptar(String contrasenia);
    
   public String desencriptar(String contraseniaEncriptada, String contrasenia);
    
   public Persona desencriptaryAutentificar(String usuario, String Contrasenia);
   
   public Perfil getperfil(int idperfil);
   
   public Persona getpersona(int idpersona);
   
   public boolean ActualizarContrasenia(String contrasenia, Persona perosonactualizar);
   
   public List<Persona> ListaTutores();
}
