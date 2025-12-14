package com.microreport.reportservice.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReporteDto {

    private Long id;
    private String tipoReporte;
    private String tituloReporte;
    private LocalDateTime fechaGeneracion;
    private Long generadoPorId;
    private Long moduloId;
    private List<DetalleDto> detalles;

    // ✅ CLASE INTERNA REAL
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class DetalleDto {
        private Long id;
        private Long moduloId;
        private String contenido;
    }
}