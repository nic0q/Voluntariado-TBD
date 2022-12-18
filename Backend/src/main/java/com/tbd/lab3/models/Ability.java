package com.tbd.lab3.models;

/**
 * Clase que representa una habilidad
 */
public class Ability {
    private Integer id_ability;
    private String name_ability;
    private String description_ability;

    /**
     * Obtiene el id de una Habilidad
     * @return Integer
     */
    public Integer getId_ability() {
        return id_ability;
    }

    /**
     * setea el id de una habilidad
     * @param id_ability
     */
    public void setId_ability(Integer id_ability) {
        this.id_ability = id_ability;
    }

    /**
     * Obtiene el nombre de una Habilidad
     * @return String
     */
    public String getName_ability() {
        return name_ability;
    }

    /**
     * setea el nombre de una habilidad
     * @param name_ability
     */
    public void setName_ability(String name_ability) {
        this.name_ability = name_ability;
    }

    /**
     * Obtiene la descripcion de una Habilidad
     * @return String
     */
    public String getDescription_ability() {
        return description_ability;
    }

    /**
     * setea la descripcion de una habilidad
     * @param description_ability
     */
    public void setDescription_ability(String description_ability) {
        this.description_ability = description_ability;
    }

    /**
     * Obtiene la informacion de una Habilidad
     * @return String
     */
    @Override
    public String toString() {
        return "ability{" +
                "id_ability=" + id_ability +
                ", name_ability='" + name_ability + '\'' +
                ", description_ability='" + description_ability + '\'' +
                '}';
    }
}
