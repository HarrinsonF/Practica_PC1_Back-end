package com.centroinformacion.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Revista;
import com.centroinformacion.service.RevistaService;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/revista")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class RevistaRegistraController {

	@Autowired
	private RevistaService revistaService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Revista>> listaRevista(){
		List<Revista> lista = revistaService.listaTodos();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> inserta(@RequestBody Revista obj){
		HashMap<String, Object> salida = new HashMap<>();
		
		obj.setFechaActualizacion(new Date());
		obj.setFechaRegistro(new Date());
		obj.setEstado(AppSettings.ACTIVO);
		
		
		Revista objSalida = revistaService.insertaActualizaRevista(obj);
		if (objSalida == null) {
			salida.put("mensaje","Error en el registro");
		}else {
			salida.put("mensaje","Se registró la Revista con el ID ==> " + objSalida.getIdRevista());
		}
		return ResponseEntity.ok(salida);
	}
}
