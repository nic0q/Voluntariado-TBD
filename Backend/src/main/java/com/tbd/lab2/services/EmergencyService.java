package com.tbd.lab2.services;

import com.tbd.lab2.Models.Emergency;
import com.tbd.lab2.repositories.EmergencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
