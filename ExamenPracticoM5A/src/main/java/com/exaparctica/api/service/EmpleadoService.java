package com.exaparctica.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.exaparctica.api.entity.Empleado;



public interface EmpleadoService {
	public Iterable<Empleado> findAll();
	public Page<Empleado> findAll(Pageable pageable);
	
	public Optional<Empleado> findById(Long id);
	
	public Empleado save(Empleado empleado);
	
	public void deleteById(Long id);
}
