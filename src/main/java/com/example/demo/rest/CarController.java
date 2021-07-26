package com.example.demo.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Car;

@RestController
@RequestMapping("/api")
public class CarController {
	
	private final Logger log = LoggerFactory.getLogger(CarController.class);
	
	// find one
	/**
	 * http://localhost:8081/api/cars/1
	 */
	@GetMapping("/cars/{id}")
	public ResponseEntity<Car> findOne(@PathVariable("id") Long id) {
		log.info("REST request to find one car");
		
		Car car1 =  new Car(id, "Ford", "Mondeo", 1.5, 5);
		
		return ResponseEntity.ok(car1);	
	}
	
	// find all
	/**
	 * http://localhost:8081/api/cars
	 */
	@GetMapping("/cars")
	public List<Car> findAll() {
		log.info("REST request to find all cars");
		Car car1 =  new Car(1L, "Ford", "Mondeo", 2.5, 5);
		Car car2 =  new Car(1L, "Toyota", "Pirus", 2.5, 5);
		return List.of(car1, car2);
	}
	
	// create one
	@PostMapping("/cars")
	public ResponseEntity<Car> create(@RequestBody Car car) {
		log.info("REST request to create a new car");
		
		if (car.getId() != null) { // HAY ID - EL COCHE YA EXISTE NO PUEDO CREARLO DE NUEVO
			log.warn("Trying to create a new car with existent id");
			return ResponseEntity.badRequest().build();
		}
		
		car.setId(1L); // simular la creacion de un id
		return ResponseEntity.ok(car);
	}
	
	// update
	@PutMapping("/cars")
	public ResponseEntity<Car> update(@RequestBody Car car) {
		log.info("REST request to update an existing car");
		
		if (car.getId() == null) { // NO HAY ID - PO RTANTO NO EXISTE EL COCHE A ACTUALIZAR
			log.warn("Trying to update an existing car without id");
			return ResponseEntity.badRequest().build();
		}
		
		// simular actualización
		car.setManufacturer(car.getManufacturer() + "Editado");
		
		return ResponseEntity.ok(car);
	}
	
	// delete one
	@DeleteMapping("/cars/{ïd}")
	public ResponseEntity<Car> delete(@PathVariable Long id) {
		log.info("REST request to delete an existing car");
		
		// simular borrar de base de datos
		// deleteById(id)
		// return REsponseEntity.notFound().build();
		
		return ResponseEntity.noContent().build();
	}
	
	// delete all
	@DeleteMapping("/cars")
	public ResponseEntity<Car> deleteAll() {
		log.info("REST request to delete all cars");
		
		// simular borrar de base de datos
		// deleteAll()
		
		return ResponseEntity.noContent().build();
	}
	

}

