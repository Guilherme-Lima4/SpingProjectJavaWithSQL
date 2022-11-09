package com.ads.tutorial.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.ads.tutorial.Model.Tutorial;

import lombok.Data;

@Entity
@Data
public class Etiqueta {
     
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "etiqueta_generator")
    private Long id;
  
    @Column(length = 100, nullable = false)
    private String nome;
  
    @ManyToMany(fetch = FetchType.LAZY,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        },
        mappedBy = "etiquetas")
    @JsonIgnore
    private Set<Tutorial> tutorials = new HashSet<>(); 
}
