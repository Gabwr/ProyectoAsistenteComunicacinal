package CONTROLADOR;

import DAO.PersonaMetodos;
import MODELO.Perfil;
import MODELO.Persona;
import java.util.List;

public class ServicioPersona {
    
    public static Persona getpersona(int idpersona){
        return new PersonaMetodos().getpersona(idpersona);
    }
            
    public static List<Persona> ListaPersona(){
         return new PersonaMetodos().ListaPersona();
    }
    public static String userExiste(String usuario){
            return new PersonaMetodos().userExiste(usuario);
    }
   
   public static List<Persona> ListaPacientes(Persona tutor){
       return new PersonaMetodos().ListaPacientes(tutor);
   }
     
    public static boolean InsertarPersona(Persona persona){
        return new PersonaMetodos().InsertarPersona(persona);
    }
    
    public static boolean ActualizarPersona(Persona persona){
        return new PersonaMetodos().ActualizarPersona(persona);
    }
    
    public static boolean ActivarPersona(Persona persona){
        return new PersonaMetodos().ActivarPersona(persona);
    }
    
    public static boolean DesactivarPersona(Persona persona){
        return new PersonaMetodos().DesactivarPersona(persona);
    }
    
    public static String encriptar(String contrasenia){
     return new PersonaMetodos().encriptar(contrasenia);
    }
    
    public static String desencriptar(String contrasenia, String contraseniallevada) {
     return new PersonaMetodos().desencriptar(contrasenia,contraseniallevada); 
    }
    
    public static Persona desencrpitaryAutentificar(String usuario, String Contrasenia){
        return new PersonaMetodos().desencriptaryAutentificar(usuario, Contrasenia);
    }
    public static Perfil getperfil(int idperfil){
        return new PersonaMetodos().getperfil(idperfil);
    }
    
    public static boolean ActualizarContrasenia(String contrasenia, Persona perosonactualizar){
        return new PersonaMetodos().ActualizarContrasenia(contrasenia, perosonactualizar);
    }

}
