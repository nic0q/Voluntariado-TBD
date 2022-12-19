package com.tbd.lab3.models;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase que representa a una Región.
 */
@Document(collection = "regions")
public class Region {
    @Id
    private ObjectId _id;
    private String name;
    private Integer id_region;

    private String geometry;
    
    
    /** 
     * Método que retorna el atributo name (String)
     * @return String
     */
    public String getName() {
        return name;
    }
    
    /** 
     * Método que modifica el atributo name (String)
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /** 
     * Método que retorna el atributo Geometry (String)
     * @return String
     */
    public String getGeometry() {
        return geometry;
    }
    
    /** 
     * Método que modifica el atributo Geometry (String)
     * @param geometry
     */
    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }
    
    /** 
     * Método que retorna el atributo id_region (Integer)
     * @return Integer
     */
    public Integer getId_region() {
        return id_region;
    }
    
    /** 
     * Método que modifica el atributo id_region (Integer)
     * @param id_region
     */
    public void setId_region(Integer id_region) {
        this.id_region = id_region;
    }
}
