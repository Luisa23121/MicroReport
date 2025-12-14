package com.microreport.reportservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "detalle_reporte")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class DetalleReporte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reporte_id")
    private Reporte reporte;

    @ManyToOne
    @JoinColumn(name = "modulo_id")
    private Modulo modulo;

    @Column(columnDefinition = "TEXT")
    private String contenido;
}
