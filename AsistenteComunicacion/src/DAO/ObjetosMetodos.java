/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author DELL
 */


import MODELO.Objeto;
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
import com.mongodb.client.result.UpdateResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjetosMetodos implements IObjetos{
    Conexion conn = new Conexion();
    MongoDatabase database;
    private MongoCollection<org.bson.Document> OBJETO;

 public ObjetosMetodos() {
   if (conn != null) {
     this.conn = conn.crearConexion();
     this.database = conn.getDataB();
    this.OBJETO = database.getCollection("OBJETODEFAULT");
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
public boolean guardarImagenEnMongo(int idAccion, int idObjeto, String rutaImagen, String NombreObjeto) {
    try {
       
        String extension = rutaImagen.substring(rutaImagen.lastIndexOf('.') + 1).toLowerCase();
        if (!extension.equals("jpg") && !extension.equals("jpeg") && !extension.equals("png")) {
            System.out.println("Formato de imagen no compatible. Solo se aceptan .jpg, .jpeg, .png");
            return false;
        }

        
        File file = new File(rutaImagen);
        byte[] fileContent = Files.readAllBytes(file.toPath()); 
        String encodedString = Base64.encodeBase64String(fileContent); 

       
        Document doc = new Document("_idAccion", idAccion)
                .append("_idObjeto", idObjeto)
                .append("imagen", encodedString)
                .append("Nombre_Objeto", NombreObjeto)
                ;
        
        OBJETO.insertOne(doc); 
        return true;
    } catch (MongoException e) {
        System.out.println("Error al guardar en MongoDB: " + e.getMessage());
    } catch (IOException ex) {
        Logger.getLogger(AccionMetodos.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
}



  @Override
public List<Objeto> CargarObjeto() {
    FindIterable<Document> documentos = OBJETO.find(); 
    List<Objeto> listaObjetos = new ArrayList<>();

    for (Document documento : documentos) {
        int idAccion = documento.getInteger("_idAccion", -1);  
        int idObjeto = documento.getInteger("_idObjeto", -1);
        String nombre= documento.getString("Nombre_Objeto");
        String encodedString = documento.getString("imagen");
        
        if (encodedString != null) {
            byte[] imagen = Base64.decodeBase64(encodedString);

            Objeto objeto = new Objeto();
            objeto.setIdAccion(idAccion);
            objeto.setIdObjeto(idObjeto);
            objeto.setObjetoNombre(nombre);
            objeto.setImagen(imagen);
            listaObjetos.add(objeto);
        } else {
            System.out.println("Imagen no encontrada para el objeto con ID: " + idObjeto);
        }
    }
    return listaObjetos;
}


   
    
   
  

    @Override
    public List<Objeto> CargarObjetosPorAccion(int idAccion) {
    List<Objeto> listaObjetos = new ArrayList<>();
    
    
    FindIterable<Document> documentos = OBJETO.find(eq("_idAccion", idAccion));

    
    for (Document documento : documentos) {
        
        int idObjeto = documento.getInteger("_idObjeto", -1);
        
        
        String encodedString = documento.getString("imagen");
        String nombre= documento.getString("Nombre_Objeto");

       
        byte[] imagen = (encodedString != null) ? Base64.decodeBase64(encodedString) : new byte[0];

        
        Objeto objeto = new Objeto();
        objeto.setIdAccion(idAccion);  
        objeto.setIdObjeto(idObjeto);  
        objeto.setImagen(imagen);
        objeto.setObjetoNombre(nombre);

        
        listaObjetos.add(objeto);
    }

    
    return listaObjetos;
}

    @Override
    public Objeto buscarObjetoPorNombre(int idAccion, String nombre) {
    try {
        Document filtro = new Document("_idAccion", idAccion)
                          .append("Nombre_Objeto", nombre); 
        
        Document documento = OBJETO.find(filtro).first(); 
        
        if (documento != null) {
            int idObjeto = documento.getInteger("_idObjeto", -1);
            String encodedString = documento.getString("imagen");

            byte[] imagen = (encodedString != null) ? Base64.decodeBase64(encodedString) : new byte[0];

            Objeto objeto = new Objeto();
            objeto.setIdAccion(idAccion);
            objeto.setIdObjeto(idObjeto);
            objeto.setObjetoNombre(nombre);
            objeto.setImagen(imagen);

            return objeto;
        }
    } catch (MongoException e) {
        System.out.println("Error al buscar objeto: " + e.getMessage());
    }
    return null;
}

}


