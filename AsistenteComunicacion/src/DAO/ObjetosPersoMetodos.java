/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODELO.ObjetoPersonalizado;
import MODELO.Persona;
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
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.and;
import com.mongodb.client.result.UpdateResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjetosPersoMetodos implements IObjetosPerso{
    
    Conexion conn = new Conexion();
    MongoDatabase database;
    private MongoCollection<org.bson.Document> OBJETOPERSONALIZADO;
    
    public ObjetosPersoMetodos() {
    if (conn != null) {
        this.conn = conn.crearConexion();
        this.database = conn.getDataB();
    this.OBJETOPERSONALIZADO = database.getCollection("OBJETOPERSONALIZADO");
   } 
   }

    private void CerrarConexion(){
        try {
            conn.getMONGO().close();
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido cerrar la conexión, error: " + ex.toString());
        }
    }
  
    @Override
    public boolean guardarImagenPersoEnMongo(int idPersona, int idAccion, int idObjetoPerso, String rutaImagen) {
       try{
           File file = new File(rutaImagen);
            byte[] fileContent = Files.readAllBytes(file.toPath()); 
            String encodedString = Base64.encodeBase64String(fileContent); 
            Document doc = new Document("_idPersona", idPersona)
                    .append("idAccion", idAccion)
                    .append("idObjetoPerso", idObjetoPerso)
                    .append("imagen", encodedString);
            

            OBJETOPERSONALIZADO.insertOne(doc); 
            return true;
       }catch (MongoException e) {
            System.out.println("Error al guardar en MongoDB: " + e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(AccionMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

      @Override
    public List<ObjetoPersonalizado> CargarObjetoPerso() {
         FindIterable<Document> documentos = OBJETOPERSONALIZADO.find();
         List<ObjetoPersonalizado> listaObjetoPerso = new ArrayList<>();
         
         for (Document documento : documentos) {
            int idPersona = documento.getInteger("idPersona",-1);
            int idAccion = documento.getInteger("idAccion", -1);  
            int idObjetoPerso = documento.getInteger("idObjetoPerso", -1);
        String encodedString = documento.getString("imagen");
        
        byte[] imagen = (encodedString != null) ? Base64.decodeBase64(encodedString) : new byte[0];
        
        ObjetoPersonalizado ObjetoPerso = new ObjetoPersonalizado();
        ObjetoPerso.setIdPersona(idPersona);
        ObjetoPerso.setIdAccion(idAccion);
        ObjetoPerso.setIdObjetoPerso(idObjetoPerso);
        ObjetoPerso.setImagen(imagen);
        listaObjetoPerso.add(ObjetoPerso);
    }
    return listaObjetoPerso;
           
    }
    
    @Override
    public List<ObjetoPersonalizado> CargarPersoPorAccion(int idPersona, int idAccion) {
        List<ObjetoPersonalizado> listaObjetoPerso = new ArrayList<>();
        
         FindIterable<Document> documentos = OBJETOPERSONALIZADO.find(
                 and(eq("idPersona",idPersona),eq("idAccion",idAccion)));
        
       for (Document documento : documentos) {
        int idPersonaDoc = documento.getInteger("idPersona", -1);
        int idAccionDoc = documento.getInteger("idAccion", -1);
        int idObjetoPerso = documento.getInteger("idObjetoPerso", -1);
        
        String encodedString = documento.getString("imagen");
        byte[] imagen = (encodedString != null) ? Base64.decodeBase64(encodedString) : new byte[0];

        ObjetoPersonalizado objetoPerso = new ObjetoPersonalizado();
        objetoPerso.setIdPersona(idPersonaDoc);
        objetoPerso.setIdAccion(idAccionDoc);
        objetoPerso.setIdObjetoPerso(idObjetoPerso);
        objetoPerso.setImagen(imagen);

        listaObjetoPerso.add(objetoPerso);
    }
   return listaObjetoPerso;
}
}
