package com.microreport.reportservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "modulo")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
}
