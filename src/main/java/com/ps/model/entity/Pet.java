package com.ps.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Represents a pet in the database
 */
@Entity
public class Pet implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column
    @NotNull
    @Size(max = 10)
    private String name;

    @Column
    @NotNull
    private Double price;

    /**
     *
     * @return The price.
     */
    public Double getPrice() {
        return price;
    }

    /**
     *
     * @param price Set the price.
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     *
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name Set the name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return The id.
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id Set the id.
     */
    public void setId(Integer id) {
        this.id = id;
    }

}
