/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODELO.Accion;
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

public class AccionMetodos implements IAccion{
    Conexion conn = new Conexion();
    MongoDatabase database;
    private MongoCollection<org.bson.Document> ACCION;

 public AccionMetodos() {
   if (conn != null) {
     this.conn = conn.crearConexion();
     this.database = conn.getDataB();
    this.ACCION = database.getCollection("ACCCIONES");
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
    public boolean guardarImagenEnMongo(int idAccion, String rutaImagen) {
        try {
            File file = new File(rutaImagen);
            byte[] fileContent = Files.readAllBytes(file.toPath()); 
            String encodedString = Base64.encodeBase64String(fileContent); 
            Document doc = new Document("_idAccion", idAccion)
                    .append("imagen", encodedString);

            ACCION.insertOne(doc); 
            return true;
        } catch (MongoException e) {
            System.out.println("Error al guardar en MongoDB: " + e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(AccionMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

  @Override
public List<Accion> CargarAccion() {
    FindIterable<Document> documentos = ACCION.find(); 
    List<Accion> listaAcciones = new ArrayList<>();

    for (Document documento : documentos) {
        int idAccion = documento.getInteger("_idAccion", -1); 
        String encodedString = documento.getString("imagen");
        
        byte[] imagen = (encodedString != null) ? Base64.decodeBase64(encodedString) : new byte[0];
        
        Accion accion = new Accion();
        accion.setIdAccion(idAccion);
        accion.setImagen(imagen);
        listaAcciones.add(accion);
    }
    return listaAcciones;
}
}
