package com.microservicio.cliente.repository;

import com.microservicio.cliente.model.LogInversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogInversionRepository extends JpaRepository<LogInversion,Long> {

    public List<LogInversion> findByInversionId(Long inversionId);
}
