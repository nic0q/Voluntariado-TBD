package com.tbd.lab3.models;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

import org.bson.types.ObjectId;

import org.springframework.data.annotation.Id;

/**
 * Clase que representa a un Voluntario.
 */
@Document(collection = "voluntaries")
public class Voluntary {
    @Id
    private ObjectId _id;
    private String rut;
    private String name;
    private Integer age;
    private Boolean avalaible;
    List<String> skills;
    private Double latitud;
    private Double longitud;
    private GeoJsonPoint location;  // GeoJsonPoint es un tipo de dato de MongoDB


    public Voluntary(String rut, String name, Integer age, Boolean avalaible, List<String> skills, Double latitud, Double longitud) {
      this.rut = rut;
      this.name = name;
      this.age = age;
      this.avalaible = avalaible;
      this.skills = skills;
      this.latitud = latitud;
      this.longitud = longitud;
      this.location = new GeoJsonPoint(latitud, longitud);
  }
    public void setLocation(GeoJsonPoint location) {
      this.location = location;
    }
    public GeoJsonPoint getLocation() {
      return location;
    }
    public ObjectId get_id() {
        return _id;
    }
    public void set_id(ObjectId _id) {
        this._id = _id;
    }
    /** 
     * Método que modifica el atributo rut (String).
     * @param rut
     */
    public void setRut(String rut) {
      this.rut = rut;
    }
    
    /** 
     * Método que modifica el atributo name (String)
     * @param name
     */
    public void setName(String name) {
      this.name = name;
    }
    
    /** 
     * Método que modifica el atributo age (Integer)
     * @param age
     */
    public void setAge(Integer age) {
      this.age = age;
    }
    
    /** 
     * Método que modifica el atributo avalaible (Boolean)
     * @param avalaible
     */
    public void setAvalaible(Boolean avalaible) {
      this.avalaible = avalaible;
    }
    
    /** 
     * Método que retorna el atributo rut (String)
     * @return String
     */
    public String getRut() {
        return rut;
    }
    
    /** 
     * Método que retorna el atributo name (String)
     * @return String
     */
    public String getName() {
        return name;
    }
    
    /** 
     * Método que retorna el atributo age (Integer)
     * @return Integer
     */
    public Integer getAge() {
        return age;
    }
    
    /** 
     * Método que retorna el atributo avalaible (Boolean)
     * @return Boolean
     */
    public Boolean getAvalaible() {
        return avalaible;
    }
    /**
   * Obtiene la latitud (double) de una Emergencia
   * @return Double
   */
  public Double getLatitud() {
    return latitud;
  }

  /**
   * Modifica la latitud (double) de una Emergencia
   * @param latitud
   */
  public void setLatitud(Double latitud) {
    this.latitud = latitud;
  }

  /**
   * Obtiene la longitud (double) de una Emergencia
   * @return Double
   */
  public Double getLongitud() {
    return longitud;
  }

  /**
   * Modifica la longitud (double) de una Emergencia
   * @param longitud
   */
  public void setLongitud(Double longitud) {
    this.longitud = longitud;
  }
  public List<String> getSkills() {
    return skills;
  }
  public void setSkills(List<String> skills) {
    this.skills = skills;
  }
}
