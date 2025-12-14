package com.microreport.reportservice.repository;

import com.microreport.reportservice.model.DetalleReporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleReporteRepository extends JpaRepository<DetalleReporte, Long>{
}
