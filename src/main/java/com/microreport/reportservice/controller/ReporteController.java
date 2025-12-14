package com.microreport.reportservice.controller;

import com.microreport.reportservice.dto.ReporteDto;
import com.microreport.reportservice.mapper.ReporteMapper;
import com.microreport.reportservice.model.Reporte;
import com.microreport.reportservice.service.ReportPdfService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    private final ReportPdfService pdfService;

    public ReporteController(ReportPdfService pdfService) {
        this.pdfService = pdfService;
    }

    // 🔹 Endpoint de prueba (sin BD todavía)
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Microservicio ReportService funcionando ✅");
    }

    // 🔹 Endpoint para generar PDF (mock por ahora)
    @PostMapping("/pdf")
    public ResponseEntity<String> generarPdf(@RequestBody Reporte reporte) throws Exception {
        String ruta = pdfService.generatePdf(reporte);
        return ResponseEntity.ok("PDF generado en: " + ruta);
    }
}