package com.microreport.reportservice.service;

import com.microreport.reportservice.model.DetalleReporte;
import com.microreport.reportservice.model.Reporte;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.format.DateTimeFormatter;

@Service
public class ReportPdfService {

    public String generatePdf(Reporte reporte) throws Exception {
        if (reporte == null) {
            throw new IllegalArgumentException("Reporte no puede ser null");
        }

        String html = buildHtml(reporte);

        // Crear carpeta target/reports si no existe
        File dir = new File("target/reports");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String filePath = "target/reports/reporte-" +
                (reporte.getId() != null ? reporte.getId() : System.currentTimeMillis()) +
                ".pdf";

        try (OutputStream os = new FileOutputStream(filePath)) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.withHtmlContent(html, null);
            builder.toStream(os);
            builder.run();
        }

        return filePath;
    }

    private String buildHtml(Reporte r) {
        StringBuilder sb = new StringBuilder();

        // 🔹 Meta corregido para XML
        sb.append("<html><head><meta charset='UTF-8'/>");
        sb.append("<style>");
        sb.append("body{font-family:Arial;} h2{color:#333;} ul{margin-left:20px;} li{margin-bottom:5px;}");
        sb.append("</style></head><body>");

        sb.append("<h2>").append(r.getTituloReporte()).append("</h2>");
        sb.append("<p><strong>Tipo:</strong> ").append(r.getTipoReporte()).append("</p>");

        // Formatear fecha para mostrar solo fecha y hora legible
        if (r.getFechaGeneracion() != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            sb.append("<p><strong>Fecha:</strong> ").append(r.getFechaGeneracion().format(formatter)).append("</p>");
        }

        if (r.getDetalles() != null && !r.getDetalles().isEmpty()) {
            sb.append("<h3>Detalles</h3><ul>");
            for (DetalleReporte d : r.getDetalles()) {
                sb.append("<li>").append(d.getContenido()).append("</li>");
            }
            sb.append("</ul>");
        }

        sb.append("</body></html>");
        return sb.toString();
    }

} // Cierre de la clase
