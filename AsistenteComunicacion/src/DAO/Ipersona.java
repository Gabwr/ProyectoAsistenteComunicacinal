
package DAO;

import MODELO.Persona;
import java.util.List;

public interface Ipersona {
   
   public List<Persona> ListaPersona();
          
   public boolean InsertarPersona(Persona persona);
           
   public String encriptar(String contrasenia);
    
   public String desencriptar(String contraseniaEncriptada, String contrasenia);
    
   public Persona desencriptaryAutentificar(String usuario, String Contrasenia);
   
}
