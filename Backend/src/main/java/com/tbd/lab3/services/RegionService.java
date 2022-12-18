package com.tbd.lab3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import com.tbd.lab3.models.Region;
import com.tbd.lab3.repositories.RegionRepository;

import java.util.List;
/**
 * Clase servicio para Region.
 */
@CrossOrigin
@RestController
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    /**
     * Método que conecta la ruta /regions con el método getAllRegions() del
     * repositorio de Region. Retorna una lista de todas las regiones.
     *
     * @return List<Region>
     */
    @GetMapping("/regions")
    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }
    @GetMapping("/regions/{id}")
    public Region getRegion(@PathVariable("id") int id_region) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id_region").is(id_region));
        List <Region> regions = mongoTemplate.find(query, Region.class);
        return regions.get(0);
    }
}
