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
            System.out.println(encodedString);
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
    FindIterable<Document> documentos = ACCION.find(); // Similar a ListaPersona
    List<Accion> listaAcciones = new ArrayList<>();

    for (Document documento : documentos) {
        int idAccion = documento.getInteger("_idacciones", -1);
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

//    @Override
//public boolean CargarAccion(Accion accion) {
//    try {
//        Document doc = ACCION.find(eq("_id", accion.getIdAccion())).first();
//        if (doc != null) {
//            Object imgData = doc.get("imagen");
//            
//            if (imgData instanceof List) { 
//                List<Integer> imgList = (List<Integer>) imgData;
//                byte[] imgBytes = new byte[imgList.size()];
//                for (int i = 0; i < imgList.size(); i++) {
//                    imgBytes[i] = imgList.get(i).byteValue();
//                }
//                accion.setImagen(imgBytes);
//            } else if (imgData instanceof String) {
//                accion.setImagen(Base64.decodeBase64((String) imgData));
//            } else {
//                JOptionPane.showMessageDialog(null, "Formato de imagen no reconocido.");
//                return false;
//            }
//
//            return true;
//        } else {
//            JOptionPane.showMessageDialog(null, "No se encontró la acción con ID: " + accion.getIdAccion());
//        }
//    } catch (MongoException e) {
//        JOptionPane.showMessageDialog(null, "Error al cargar la acción: " + e.getMessage());
//    }
//    return false;
//}
