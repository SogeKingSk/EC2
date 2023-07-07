package com.example.accessingdatamysql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Curso {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String nombre;

  private Integer creditos;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return nombre;
  }

  public void setName(String nombre) {
    this.nombre = nombre;
  }

  public Integer getCredito() {
    return creditos;
  }

  public void setCredito(Integer creditos) {
    this.creditos = creditos;
  }
}