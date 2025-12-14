package com.microreport.reportservice.mapper;

import com.microreport.reportservice.dto.ReporteDto;
import com.microreport.reportservice.model.Reporte;

import java.util.stream.Collectors;

public class ReporteMapper {

    public static ReporteDto toDto(Reporte r) {
        if (r == null) return null;

        return ReporteDto.builder()
                .id(r.getId())
                .tipoReporte(r.getTipoReporte())
                .tituloReporte(r.getTituloReporte())
                .fechaGeneracion(r.getFechaGeneracion())
                .generadoPorId(
                        r.getGeneradoPor() != null ? r.getGeneradoPor().getId() : null
                )
                .moduloId(
                        r.getModulo() != null ? r.getModulo().getId() : null
                )
                .detalles(
                        r.getDetalles() == null
                                ? null
                                : r.getDetalles().stream()
                                .map(d -> ReporteDto.DetalleDto.builder()
                                        .id(d.getId())
                                        .moduloId(
                                                d.getModulo() != null ? d.getModulo().getId() : null
                                        )
                                        .contenido(d.getContenido())
                                        .build()
                                )
                                .collect(Collectors.toList())
                )
                .build();
    }
}
