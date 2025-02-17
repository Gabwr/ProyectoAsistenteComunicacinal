
package DAO;

import MODELO.Perfil;
import MODELO.Persona;
import java.util.List;

public interface Ipersona {
   
   public List<Persona> ListaPersona();
          
   public boolean InsertarPersona(Persona persona);
   
   public boolean ActualizarPersona(Persona persona);
   
   public boolean ActivarPersona(Persona persona);
   
   public boolean DesactivarPersona(Persona persona);
           
   public String encriptar(String contrasenia);
    
   public String desencriptar(String contraseniaEncriptada, String contrasenia);
    
   public Persona desencriptaryAutentificar(String usuario, String Contrasenia);
   
   public Perfil getperfil(int idperfil);
   
   public Persona getpersona(int idpersona);
   
}
