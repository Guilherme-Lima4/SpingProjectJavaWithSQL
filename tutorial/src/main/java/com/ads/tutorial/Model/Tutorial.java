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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

import lombok.Data;

@Entity
@Data
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tutorial_generator")
    private Long id;
  
    @Column(length = 100, nullable = false)
    private String titulo;
  
    @Column(length = 250, nullable = false)
    private String descricao;
  
    @Column(name = "publicado")
    private Boolean publicado;

   
    @ManyToMany(fetch = FetchType.LAZY,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        })
    @JoinTable(name = "tutorial_etiqueta",
          joinColumns = { @JoinColumn(name = "tutorial_id") },
          inverseJoinColumns = { @JoinColumn(name = "etiqueta_id") })
    private Set<Etiqueta> etiquetas = new HashSet<>(); 
    
}
