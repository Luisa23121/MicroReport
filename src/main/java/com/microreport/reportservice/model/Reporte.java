package com.microreport.reportservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "reporte")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoReporte;

    private String tituloReporte;

    private LocalDateTime fechaGeneracion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario generadoPor;

    @ManyToOne
    @JoinColumn(name = "modulo_id")
    private Modulo modulo;

    @OneToMany(mappedBy = "reporte", cascade = CascadeType.ALL)
    private List<DetalleReporte> detalles;
}
