package com.tbd.lab3.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase que representa una Emergencia
 */
@Document(collection = "emergencies")
public class Emergency {
  @Id
  private ObjectId _id;
  private Integer id_emergency;
  private String name;
  private String description;
  private String status;
  private Integer id_institution;
  private Double latitud;
  private Double longitud;

  /**
   * Obtiene el id (integer) de una Emergencia
   * @return Integer
   */
  public Integer getId_emergency() {
    return id_emergency;
  }

  /**
   * Modifica un id (integer) a una Emergencia
   * @param id_emergency
   */
  public void setId_emergency(Integer id_emergency) {
    this.id_emergency = id_emergency;
  }

  /**
   * Obtiene el nombre (string) de una Emergencia
   * @return String
   */
  public String getName() {
    return name;
  }

  /**
   * Modifica el nombre (string) de una Emergencia
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Obtiene la descripción (string) de una Emergencia
   * @return String
   */

  public String getDescription() {
    return description;
  }

  /**
   * Modifica la descripción (string) de una Emergencia
   * @param name
   */

  public void setDescription(String description) {
    this.description = description;
  }
  /**
   * Obtiene el estado (string) de una Emergencia
   * @return String
   */
  public String getStatus() {
    return status;
  }

  /**
   * Modifica el estado (string) de una Emergencia
   * @param status
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * Obtiene el id de la institución (integer) de una Emergencia
   * @return Integer
   */
  public Integer getId_institution() {
    return id_institution;
  }

  /**
   * Modifica el id de la institución (integer) de una Emergencia
   * @param id_institution
   */
  public void setId_institution(Integer id_institution) {
    this.id_institution = id_institution;
  }

  /**
   * Método que retorna un string con los atributos de la clase Emergency
   * @return String
   */
  @Override
  public String toString() {
    return (
      "Emergency{" +
      "id_emergency=" +
      id_emergency +
      ", name='" +
      name +
      '\'' +
      ", status='" +
      status +
      '\'' +
      ", id_institution=" +
      id_institution +
      ", latitud=" +
      latitud +
      ", longitud=" +
      longitud +
      '}'
    );
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
}
