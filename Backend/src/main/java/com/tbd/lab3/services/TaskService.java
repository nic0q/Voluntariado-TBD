package com.tbd.lab3.services;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.tbd.lab3.models.Task;
import com.tbd.lab3.repositories.TaskRepository;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    /**
     * Método que conecta la ruta /emergencies con el método getAllEmergencies() del
     * repositorio de Task. Retorna una lista de todas las emergencias.
     * @return List<Task>
     */
    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Método que conecta la ruta /emergencies con el método getAllEmergencies() del
     * repositorio de Task. Retorna una lista de todas las emergencias.
     * @return List<Task>
     */
    @GetMapping("/tasks/{id}")
    public Optional<Task> getTask(@PathVariable("id") int id) {
        return taskRepository.findById(id);
    }

    /**
     * Método que conecta la ruta /emergencies con el método createEmergency() del
     * repositorio de Task. Recibe un objeto de tipo Task y lo inserta en la
     * base de datos. Retorna el objeto de tipo Task que se insertó. Si no se pudo
     * insertar retorna null.
     * @param Task
     * @return Task
     */
    @PostMapping("/tasks")
    @ResponseBody
    public Task createTask(@RequestBody Task Task){
        Task result = taskRepository.save(Task);
        return result;
    }

    /**
     * Método que conecta la ruta /emergencies/{id} con el método editEmergency() del
     * repositorio de Task. Recibe un objeto de tipo Task y lo actualiza en la
     * base de datos. Retorna un mensaje de éxito si se pudo actualizar, de lo contrario retorna
     * un mensaje indicando que no se pudo encontrar la emergencia.
     * @param id
     * @param Task
     * @return Task
     */
    @PutMapping("/tasks/{id}")
    public Task editTask(@RequestBody Task Task){
        taskRepository.save(Task);
        return Task;
    }



    /**
     * Método que conecta la ruta /emergencies/{id} con el método deleteEmergency() del
     * repositorio de Task. Recibe un id y elimina la emergencia que tiene ese id.
     * Retorna un mensaje de éxito si se pudo eliminar, de lo contrario retorna un mensaje
     * donde se indica que la emergencia no se pudo encontrar.
     * @param id
     * @return String
     */
    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable("id") int id){
        taskRepository.deleteById(id);
        return "Task deleted";
    }

    /**
     * Método que conecta la ruta /emergencies con el método deleteAllEmergency() del
     * repositorio de Task. Elimina todas las emergencias de la base de datos.
     * Retorna un mensaje de éxito si se pudo eliminar, de lo contrario retorna un mensaje
     * donde se indica que no se pudo eliminar.
     * @return String
     */
    @DeleteMapping("/tasks")
    public String deleteAllTasks(){
        taskRepository.deleteAll();
        return "Tasks deleted";
    }

    @GetMapping("/emergency/tasks/{id}")
    public ArrayList<Document> getTasksByEmergency(@PathVariable("id") int id_emergency) {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017/test?readPreference=primary&serverSelectionTimeoutMS=2000&appname=MongoDB+Compass&directConnection=true&ssl=false"));
        MongoDatabase database = mongoClient.getDatabase("tbd3");
        MongoCollection<Document> collection = database.getCollection("tasks");
        AggregateIterable<Document> tareas = collection.aggregate(Arrays.asList(new Document("$match", new Document("id_task", id_emergency)),
                new Document("$lookup", new Document("from", "tasks").append("localField","id_task").append("foreignField","id_emergency").append("as","tasks"))));
        ArrayList<Document> docOut = new ArrayList<>();
        for (Document document : tareas) {
            docOut.add(document);
        }
        return docOut;
    }
}
