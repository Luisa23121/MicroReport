package com.microreport.reportservice.service;

import com.microreport.reportservice.model.Reporte;
import java.util.List;

public interface ReporteService {
    Reporte create(Reporte reporte);
    Reporte getById(Long id);
    List<Reporte> getAll();

    void deleteById(Long id);

}
