package com.tbd.lab3.models;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "regions")
public class Region {
    @Id
    private ObjectId _id;
    private String name;
    private Integer id_region;

    private String geometry;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGeometry() {
        return geometry;
    }
    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }
    public Integer getId_region() {
        return id_region;
    }
    public void setId_region(Integer id_region) {
        this.id_region = id_region;
    }
}
