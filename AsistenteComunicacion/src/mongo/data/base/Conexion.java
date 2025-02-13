package mongo.data.base;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoException;
import javax.swing.JOptionPane;

public class Conexion {
     private MongoClient mongo;
    private MongoDatabase dataB;

    public Conexion() { 
    }

    public MongoClient getMONGO() {
        return mongo;
    }

    public MongoDatabase getDataB() {
        return dataB;
    }

    public Conexion(MongoClient mongoClient, MongoDatabase database) {
        this.mongo = mongoClient;
        this.dataB = database;
    }
    
    public Conexion crearConexion(){
    String uri = "mongodb+srv://admin:admin12345@cluster0.itbva.mongodb.net/ASISTENTE_VIRTUAL?retryWrites=true&w=majority";

    try{
        MongoClient mongo =  MongoClients.create(uri);
        dataB = mongo.getDatabase("ASISTENTE_VIRTUAL");
        
    }catch(MongoException ex){
        JOptionPane.showMessageDialog(null, "Error en la conexión a Mongodb"+ex.toString());
    }
        return new Conexion(mongo,dataB);
    }
}
