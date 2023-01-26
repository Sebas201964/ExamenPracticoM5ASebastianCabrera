package com.exaparctica.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.exaparctica.api.entity.Empleado;
import com.exaparctica.api.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	 @Autowired
	    private EmpleadoRepository empleadoRepository;

	    @Override
	    @Transactional(readOnly = true)
	    public Iterable<Empleado> findAll() {
	        return empleadoRepository.findAll();
	    }

	    @Override
	    @Transactional(readOnly = true)
	    public Page<Empleado> findAll(Pageable pageable) {
	        return empleadoRepository.findAll(pageable);
	    }

	    @Override
	    @Transactional(readOnly = true)
	    public Optional<Empleado> findById(Long id) {
	        return empleadoRepository.findById(id);
	    }

	    @Override
	    @Transactional
	    public Empleado save(Empleado empleado) {
	        return empleadoRepository.save(empleado);
	    }

	    @Override
	    @Transactional
	    public void deleteById(Long id) {
	    	empleadoRepository.deleteById(id);
	    }
	
	
	
	
	
	
	
	
	
	
	
}
