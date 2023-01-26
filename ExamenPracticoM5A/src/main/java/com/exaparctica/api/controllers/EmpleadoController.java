package com.exaparctica.api.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exaparctica.api.entity.Empleado;
import com.exaparctica.api.service.EmpleadoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {
	 @Autowired
	    private EmpleadoService empleadoService;

	    //Crear
	    @PostMapping
	    public ResponseEntity<?> create (@Valid @RequestBody Empleado empleado){
	        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoService.save(empleado));
	    }

	    //Leer
	    @GetMapping("/{id}")
	    public ResponseEntity<?> read (@PathVariable(value = "id") Long userId){
	        Optional<Empleado> oUser = empleadoService.findById(userId);

	        if(!oUser.isPresent()){
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(oUser);
	    }

	    //actualizar
	    @PutMapping("/{id}")
	    public ResponseEntity<?> update (@Valid @RequestBody Empleado userDetails, @PathVariable(value = "id") Long userId){
	        Optional<Empleado> empleado = empleadoService.findById(userId);

	        if (!empleado.isPresent()){
	            return ResponseEntity.notFound().build();
	        }
	        
	        empleado.get().setNombre(userDetails.getNombre());
	        empleado.get().setApellido(userDetails.getApellido());
	        empleado.get().setTelefono(userDetails.getTelefono());
	        empleado.get().setDireccion(userDetails.getDireccion());
	        empleado.get().setFecha_nacimiento(userDetails.getFecha_nacimiento());
	        empleado.get().setObservacion(userDetails.getObservacion());
	        empleado.get().setDias_trabajados(userDetails.getDias_trabajados());
	        empleado.get().setSueldo(userDetails.getSueldo());
	        
	        
	        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoService.save(empleado.get()));
	    }

	    //eliminar
	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> delete (@PathVariable(value = "id") Long userId){
	        if (!empleadoService.findById(userId).isPresent()){
	            return ResponseEntity.notFound().build();
	        }
	        empleadoService.deleteById(userId);
	        return ResponseEntity.ok().build();
	    }

	    //read all user
	    @GetMapping
	    public List<Empleado> readAll(){
	        List<Empleado> empleados = StreamSupport
	                .stream(empleadoService.findAll().spliterator(), false)
	                .collect(Collectors.toList());
	        return empleados;
	    }

}
