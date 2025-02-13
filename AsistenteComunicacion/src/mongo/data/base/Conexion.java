
package mongo.data.base;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;
import javax.swing.JOptionPane;

public class Conexion {
     private MongoClient mongo;
    private MongoDatabase dataB;

    Conexion() {
       
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
    String uri = "mongodb+srv://cluster0.itbva.mongodb.net/\"";
    try{
        mongo = new MongoClient(new MongoClientURI(uri));
        dataB = mongo.getDatabase("ASISTENTE_VIRTUAL");
        
    }catch(MongoException ex){
        JOptionPane.showMessageDialog(null, "Error en la conexión a Mongodb"+ex.toString());
    }
        return new Conexion(mongo,dataB);
    }
}
