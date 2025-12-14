package com.microreport.reportservice.repository;

import com.microreport.reportservice.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}
