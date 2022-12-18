package com.tbd.lab3.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tbd.lab3.models.Region;
import com.tbd.lab3.models.Voluntary;
import com.tbd.lab3.repositories.VoluntaryRepository;

/**
 * Clase servicio para Voluntary.
 */
@CrossOrigin
@RestController
public class VoluntaryService {

    @Autowired
    VoluntaryRepository voluntaryRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    /**
     * Método que conecta la ruta /emergencies con el método getAllEmergencies() del
     * repositorio de Emergency. Retorna una lista de todas las emergencias.
     * @return List<Emergency>
     */
    @GetMapping("/voluntaries")
    public List<Voluntary> getAllVoluntaries() {
        return voluntaryRepository.findAll();
    }

    @GetMapping("/abilities/region/{id}")
    public List<Voluntary> getAllTasks(@PathVariable("id") int id_region) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id_region").is(id_region));
        List <Region> regions = mongoTemplate.find(query, Region.class);
        BasicQuery query2 = new BasicQuery("{ location: { $geoWithin: {$geometry:"+ regions.get(0).getGeometry() +"} } }, {name: 1, abilities: 1, _id: 0}");
        List <Voluntary> voluntaries2 = mongoTemplate.find(query2, Voluntary.class);
        return voluntaries2;
    }
}
