package com.microreport.reportservice.service.impl;

import com.microreport.reportservice.model.Reporte;
import com.microreport.reportservice.repository.ReporteRepository;
import com.microreport.reportservice.service.ReporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReporteServiceImpl implements ReporteService {

    private final ReporteRepository repo;

    @Override
    public Reporte create(Reporte reporte) {
        return repo.save(reporte);
    }

    @Override
    public Reporte getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Reporte> getAll() {
        return repo.findAll();
    }
    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

}
