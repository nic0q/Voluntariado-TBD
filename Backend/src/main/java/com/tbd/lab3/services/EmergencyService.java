package com.tbd.lab3.services;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.bson.Document;
import com.tbd.lab3.models.Emergency;
import com.tbd.lab3.repositories.EmergencyRepository;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Clase servicio para Emergency.
 */
@CrossOrigin
@RestController
public class EmergencyService {
    @Autowired
    EmergencyRepository emergencyRepository;

    /**
     * Método que conecta la ruta /emergencies con el método getAllEmergencies() del
     * repositorio de Emergency. Retorna una lista de todas las emergencias.
     * @return List<Emergency>
     */
    @GetMapping("/emergencies")
    public List<Emergency> getAllEmergencies() {
        return emergencyRepository.findAll();
    }


    /**
     * Método que conecta la ruta /emergencies con el método createEmergency() del
     * repositorio de Emergency. Recibe un objeto de tipo Emergency y lo inserta en la
     * base de datos. Retorna el objeto de tipo Emergency que se insertó. Si no se pudo
     * insertar retorna null.
     * @param emergency
     * @return Emergency
     */
    @PostMapping("/emergencies")
    @ResponseBody
    public Emergency createEmergency(@RequestBody Emergency emergency){
        Emergency result = emergencyRepository.save(emergency);
        return result;
    }

    /**
     * Método que conecta la ruta /emergencies/{id} con el método editEmergency() del
     * repositorio de Emergency. Recibe un objeto de tipo Emergency y lo actualiza en la
     * base de datos. Retorna un mensaje de éxito si se pudo actualizar, de lo contrario retorna
     * un mensaje indicando que no se pudo encontrar la emergencia.
     * @param id
     * @param emergency
     * @return emergency
     */
    @PutMapping("/emergencies/{id}")
    public Emergency editEmergency(@RequestBody Emergency emergency){
        emergencyRepository.save(emergency);
        return emergency;
    }

    /**
     * Método que conecta la ruta /emergencies con el método deleteAllEmergency() del
     * repositorio de Emergency. Elimina todas las emergencias de la base de datos.
     * Retorna un mensaje de éxito si se pudo eliminar, de lo contrario retorna un mensaje
     * donde se indica que no se pudo eliminar.
     * @return String
     */
    @DeleteMapping("/emergencies")
    public String deleteAllEmergencies(){
        emergencyRepository.deleteAll();
        return "Emergencies deleted";
    }
        /**
     * Método que obtiene las tareas de una emergencia usando aggregate, lookup y unwind
     * @return String
     */
    @GetMapping("/emergency/tasks/{id}")
    public ArrayList<Document> getTasksByEmergency(@PathVariable("id") int id_emergency) {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017/test?readPreference=primary&serverSelectionTimeoutMS=2000&appname=MongoDB+Compass&directConnection=true&ssl=false"));
        MongoDatabase database = mongoClient.getDatabase("tbd3");
        MongoCollection<Document> collection = database.getCollection("tasks");
        AggregateIterable<Document> tareas = collection.aggregate(Arrays.asList(
        new Document("$match", new Document("id_emergency", id_emergency)),
        new Document("$lookup", new Document("from", "tasks").append("localField","id_task").append("foreignField","id_emergency").append("as","tasks")),
        new Document("$unwind", "$tasks"),
        new Document("$project", new Document("_id", 0).append("id_emergency", 1).append("tasks", 1))));
        ArrayList<Document> docOut = new ArrayList<>();
        for (Document document : tareas) {
            docOut.add(document);
        }
        return docOut;
    }
}
