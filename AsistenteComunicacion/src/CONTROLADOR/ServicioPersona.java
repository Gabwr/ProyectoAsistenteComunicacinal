package CONTROLADOR;

import DAO.PersonaMetodos;
import MODELO.Persona;
import java.util.List;

public class ServicioPersona {
    
    public static List<Persona> ListaPersona(){
         return new PersonaMetodos().ListaPersona();
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
    
}
