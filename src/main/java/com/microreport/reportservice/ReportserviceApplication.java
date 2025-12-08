package com.microreport.reportservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@SpringBootApplication(exclude = {
    DataSourceAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class,
    HibernateJpaAutoConfiguration.class
})
@RestController
public class ReportserviceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ReportserviceApplication.class, args);
    }
    
    @GetMapping("/api/health")
    public Map<String, String> health() {
        return Map.of(
            "status", "OK",
            "service", "reportservice", 
            "message", "Servicio de reportes funcionando"
        );
    }
}
