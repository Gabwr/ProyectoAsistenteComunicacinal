package DAO;


import MODELO.Perfil;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;
import org.bson.Document;
import mongo.data.base.Conexion;
import MODELO.Persona;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PersonaMetodos implements Ipersona{
    Conexion conn = new Conexion();
    MongoDatabase database;
    private MongoCollection<org.bson.Document> PERSONA;
    private MongoCollection<org.bson.Document> PERFIL;

    public PersonaMetodos() {
        if (conn != null) {
            this.conn = conn.crearConexion();
            this.database = conn.getDataB();
            this.PERSONA = database.getCollection("PERSONA");
            this.PERFIL = database.getCollection("PERFIL");
        }
    }

    private void cerrarConexion() {
        try {
            conn.getMONGO().close();
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido cerrar la conexión, error: " + ex.toString());
        }
    }
    
        @Override
        public List<Persona> ListaPersona() {
        FindIterable<Document> documentos = PERSONA.find();
        List<Persona> listapersonas = new ArrayList<>();
        for (Document documento : documentos) {
            int IDPerfil = documento.getInteger("id_Perfil");
            String usuario = documento.getString("usuario");
            String nombre = documento.getString("nombre");
            
            Persona persona = new Persona(IDPerfil, usuario, nombre);
            listapersonas.add(persona);
        }

        return listapersonas;
    }
        
    @Override
    public boolean InsertarPersona(Persona persona) {
        Document documento;
        try {
            documento = new Document("id_Persona", persona.getIdPersona())
                    .append("id_Perfil", persona.getIdPerfil())
                    .append("usuario", persona.getUsuario())
                    .append("nombre", persona.getNombre())
                    .append("contrasenia", persona.getContrasenia());
            PERSONA.insertOne(documento);
            return true;
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido agregar la persona, error: " + ex.toString());
            return false;
        } finally {
            cerrarConexion();
        }
    }
    
    @Override
    public String encriptar(String contrasenia) {
        String Encriptado = "";
        try {
            MessageDigest gestor = MessageDigest.getInstance("MD5");
            byte[] llaveClave = gestor.digest(contrasenia.getBytes("utf-8"));
            byte[] clavebyte = Arrays.copyOf(llaveClave, 24);
            SecretKey llave = new SecretKeySpec(clavebyte, "DESede");
            Cipher cifrado = Cipher.getInstance("DESede");
            cifrado.init(Cipher.ENCRYPT_MODE, llave);

            byte[] textoPlano = contrasenia.getBytes("utf-8");
            byte[] buffer = cifrado.doFinal(textoPlano);
            byte[] base64 = Base64.encodeBase64(buffer);
            Encriptado = new String(base64);
        } catch (Exception e) {
        }
        return Encriptado;
    }

    @Override
    public String desencriptar(String contraseniaEncriptada, String contrasenia) {
        String desEncriptado = "";
        try {
            byte[] mensaje = Base64.decodeBase64(contraseniaEncriptada.getBytes("utf-8"));
            MessageDigest digestor = MessageDigest.getInstance("MD5");
            byte[] gestionado = digestor.digest(contrasenia.getBytes("utf-8"));
            byte[] llaveenBytes = Arrays.copyOf(gestionado, 24);
            SecretKey llave = new SecretKeySpec(llaveenBytes, "DESede");
            Cipher descifrado = Cipher.getInstance("DESede");
            descifrado.init(Cipher.DECRYPT_MODE, llave);
            byte[] textoPlano = descifrado.doFinal(mensaje);
            desEncriptado = new String(textoPlano, "UTF-8");
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException
                | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (Exception e) {
        }
        return desEncriptado;
    }
    
    @Override
    public Persona desencriptaryAutentificar(String usuario, String Contrasenia) {
        Persona suPersona = new Persona();
        Document filtro = null, resultado = null, perfil = null;
        try {
            filtro = new Document("usuario", usuario);
            resultado = (Document) PERSONA.find(eq("usuario", usuario)).first();
            if (resultado != null) {
                perfil = PERFIL.find(eq("id_perfil",
                        resultado.getInteger("id_perfil"))).first();
                    suPersona.setIdPerfil(perfil.getInteger("id_perfil"));
                    suPersona.setUsuario(usuario);
                    suPersona.setContrasenia(Contrasenia);
            } else {
                return null;
            }
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar el usuario, error: " + ex.toString());
            return null;
        }
        return suPersona;
    }

}
